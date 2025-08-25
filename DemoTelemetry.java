import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoTelemetry {

    // Extrae el valor de "key": "valor" o "key": valor
    private static String extract(String json, String key) {
        String pattern = "\"" + key + "\"\\s*:\\s*\"?([^\",}\\]]+)\"?";
        Matcher m = Pattern.compile(pattern).matcher(json);
        if (m.find()) return m.group(1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        // 1. Leer JSON desde archivo
        String json = Files.readString(Path.of("telemetry.json"));

        // 2. Crear objeto Telemetry
        Telemetry t = new Telemetry();

        // 3. Extraer campos mínimos
        String terid  = extract(json, "terid");
        String gpslat = extract(json, "gpslat");
        String gpslng = extract(json, "gpslng");
        String speed  = extract(json, "speed");
        String time   = extract(json, "time");

        // 4javac. Rellenar con setters
        if (terid  != null) t.setTerid(terid);
        if (gpslat != null) t.setGpslat(gpslat);
        if (gpslng != null) t.setGpslng(gpslng);
        if (speed  != null) t.setSpeed(Integer.parseInt(speed));
        if (time   != null) t.setTime(time);

        // 5. Mostrar y probar métodos
        System.out.println("Objeto Telemetry:");
        System.out.println(t);
        System.out.println("Latitud (double): " + t.lat());
        System.out.println("Longitud (double): " + t.lon());
        System.out.println("Coordenadas válidas: " + t.formatoValidoCoordenadas());
    }
}
