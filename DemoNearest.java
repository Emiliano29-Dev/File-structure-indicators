import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoNearest {

    // Extraemos el key
    private static String extract(String json, String key) {
        String pattern = "\"" + key + "\"\\s*:\\s*\"?([^\",}\\]]+)\"?";
        Matcher m = Pattern.compile(pattern).matcher(json);
        if (m.find()) return m.group(1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        // 1) Leer telemetría desde archivo (usa tu telemetry.json)
        String json = Files.readString(Path.of("telemetry.json"));

        Telemetry t = new Telemetry();
        String terid  = extract(json, "terid");
        String gpslat = extract(json, "gpslat");
        String gpslng = extract(json, "gpslng");
        String time   = extract(json, "time");

        if (terid  != null) t.setTerid(terid);
        if (gpslat != null) t.setGpslat(gpslat);
        if (gpslng != null) t.setGpslng(gpslng);
        if (time   != null) t.setTime(time);

        if (!t.formatoValidoCoordenadas()) {
            System.out.println("Telemetría inválida: " + t);
            return;
        }

        // Instanciar repositorio y servicio
        StationRepository repo = new InMemoryStationRepository();
        NearestStationService service = new NearestStationService(repo);

        // Calcular estación más cercana
        NearestStationService.Result r = service.findNearest(t.lat(), t.lon());

        //  Imprimir resultados
        System.out.printf("Telemetría: terid=%s  [%.6f, %.6f]  time=%s%n",
                t.getTerid(), t.lat(), t.lon(), t.getTime());
        System.out.printf("Más cercana: %s (%s)  [%.6f, %.6f]%n",
                r.station.nombreDeLaEstacion,
                r.station.codigoDeEstacion,
                r.station.latitudDecimal,
                r.station.longitudDecimal);
        System.out.printf("Distancia: %.1f m (%.3f km)%n",
                r.distanceMeters, r.distanceMeters / 1000.0);
    }
}
