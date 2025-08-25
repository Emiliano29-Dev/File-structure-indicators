import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class LapCounter {
    private final NearestStationService nearestService;
    private final Set<String> checkpointCodes;
    private final double enterRadiusM;
    private final double exitRadiusM;
    private final int minLapIntervalSec;

    private boolean insideCheckpoint = false;
    private String currentCheckpointCode = null;
    private LocalDateTime lastLapTime = null;
    private int lapCount = 0;

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LapCounter(NearestStationService nearestService,
                      Set<String> checkpointCodes,
                      double enterRadiusM,
                      double exitRadiusM,
                      int minLapIntervalSec) {
        this.nearestService = nearestService;
        this.checkpointCodes = checkpointCodes;
        this.enterRadiusM = enterRadiusM;
        this.exitRadiusM = exitRadiusM;
        this.minLapIntervalSec = minLapIntervalSec;
    }

    public LapEvent process(Telemetry t) throws Exception {
        NearestStationService.Result r = nearestService.findNearest(t.lat(), t.lon());
        Station st = r.station;
        double dist = r.distanceMeters;

        boolean isCheckpoint = checkpointCodes.contains(st.codigoDeEstacion);
        LocalDateTime now = parseTimeOrNull(t.getTime());

        if (!insideCheckpoint) {
            if (isCheckpoint && dist <= enterRadiusM && passesInterval(now)) {
                lapCount++;
                insideCheckpoint = true;
                currentCheckpointCode = st.codigoDeEstacion;
                if (now != null) lastLapTime = now;

                return new LapEvent(
                        lapCount, st, dist, t.getTime(), t.getTerid()
                );
            }
            return null;
        } else {
            boolean leftByDistance = dist >= exitRadiusM;
            boolean switchedStation = !st.codigoDeEstacion.equals(currentCheckpointCode);
            boolean notCheckpoint = !isCheckpoint;
            if (leftByDistance || switchedStation || notCheckpoint) {
                insideCheckpoint = false;
                currentCheckpointCode = null;
            }
            return null;
        }
    }

    private boolean passesInterval(LocalDateTime now) {
        if (minLapIntervalSec <= 0) return true;
        if (lastLapTime == null || now == null) return true;
        long sec = Duration.between(lastLapTime, now).getSeconds();
        return sec >= minLapIntervalSec;
    }

    private static LocalDateTime parseTimeOrNull(String s) {
        if (s == null || s.isEmpty()) return null;
        try { return LocalDateTime.parse(s, FMT); } catch (Exception e) { return null; }
    }

    public int getLapCount() { return lapCount; }

    public static final class LapEvent {
        public final int lapNumber;
        public final Station station;
        public final double distanceMeters;
        public final String telemetryTime;
        public final String terid;

        public LapEvent(int lapNumber, Station station, double distanceMeters, String telemetryTime, String terid) {
            this.lapNumber = lapNumber;
            this.station = station;
            this.distanceMeters = distanceMeters;
            this.telemetryTime = telemetryTime;
            this.terid = terid;
        }

        @Override public String toString() {
            return String.format("Lap #%d @ %s (%s) dist=%.1f m time=%s terid=%s",
                    lapNumber, station.nombreDeLaEstacion, station.codigoDeEstacion,
                    distanceMeters, telemetryTime, terid);
        }
    }
}
