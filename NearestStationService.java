// NearestStationService.java
import java.util.List;

public class NearestStationService {
    private final StationRepository repo;
    public NearestStationService(StationRepository repo) { this.repo = repo; }

    public Result findNearest(double lat, double lon) throws Exception {
        List<Station> stations = repo.findAllActivas();
        if (stations == null || stations.isEmpty()) {
            throw new IllegalStateException("No hay estaciones activas para evaluar.");
        }
        Station best = null;
        double bestDist = Double.POSITIVE_INFINITY;
        for (Station s : stations) {
            double d = Geo.haversine(lat, lon, s.latitudDecimal, s.longitudDecimal);
            if (d < bestDist) { bestDist = d; best = s; }
        }
        return new Result(best, bestDist);
    }

    public static final class Result {
        public final Station station;
        public final double distanceMeters;
        public Result(Station station, double distanceMeters) {
            this.station = station; this.distanceMeters = distanceMeters;
        }
    }
}
