import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DemoCounter {
    private static Telemetry makeT(String terid, double lat, double lon, String time) {
        Telemetry t = new Telemetry();
        t.setTerid(terid);
        t.setGpslat(Double.toString(lat));
        t.setGpslng(Double.toString(lon));
        t.setTime(time);
        return t;
    }

    public static void main(String[] args) throws Exception {
        StationRepository repo = new InMemoryStationRepository();
        NearestStationService nearest = new NearestStationService(repo);

        Set<String> checkpoints = new HashSet<>(Arrays.asList("CHA"));
        double ENTER_RADIUS_M = 75.0, EXIT_RADIUS_M = 110.0;
        int MIN_LAP_INTERVAL_SEC = 30;

        LapCounter counter = new LapCounter(nearest, checkpoints, ENTER_RADIUS_M, EXIT_RADIUS_M, MIN_LAP_INTERVAL_SEC);

        String terid = "AE99873120";
        double baseLat = 19.4206333333333, baseLon = -99.1761666666666;

        Telemetry[] track = new Telemetry[] {
            makeT(terid, baseLat + 0.0027, baseLon, "2017-06-19 00:00:00"),
            makeT(terid, baseLat + 0.0011, baseLon, "2017-06-19 00:00:20"),
            makeT(terid, baseLat + 0.0005, baseLon, "2017-06-19 00:01:00"),
            makeT(terid, baseLat + 0.0004, baseLon, "2017-06-19 00:01:10"),
            makeT(terid, baseLat + 0.0015, baseLon, "2017-06-19 00:01:40"),
            makeT(terid, baseLat + 0.00055, baseLon, "2017-06-19 00:02:20"),
        };

        for (Telemetry t : track) {
            LapCounter.LapEvent ev = counter.process(t);
            if (ev != null) System.out.println(ev);
        }

        System.out.println("Total de vueltas: " + counter.getLapCount());
    }
}
