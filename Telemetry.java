public class Telemetry {
    //Copiamos los campos tal cual de la API de CEIBA II
    private String terid;
    private String gpstime;    
    private Integer altitude;  // 600
    private Integer direction; // 45
    private String gpslat;     // "23.654123"
    private String gpslng;     // "108.432143"
    private Integer speed;     // 80
    private Integer recordspeed;// 0
    private Integer state;     // 0
    private String time;       // "2017-06-19 00:00:00"

    // Jackson requiere constructor vacío
    public Telemetry() {}

    // Getters de la clase
    public String getTerid() { return terid; }
    public String getGpstime() { return gpstime; }
    public Integer getAltitude() { return altitude; }
    public Integer getDirection() { return direction; }
    public String getGpslat() { return gpslat; }
    public String getGpslng() { return gpslng; }
    public Integer getSpeed() { return speed; }
    public Integer getRecordspeed() { return recordspeed; }
    public Integer getState() { return state; }
    public String getTime() { return time;}

    // Setters de la clase
    public void setTerid(String terid) { this.terid = terid; }
    public void setGpstime(String gpstime) { this.gpstime = gpstime; }   
    public void setAltitude(Integer altitude) { this.altitude = altitude; }
    public void setDirection(Integer direction) { this.direction = direction; }
    public void setGpslat(String gpslat) { this.gpslat = gpslat; }
    public void setGpslng(String gpslng) { this.gpslng = gpslng; }
    public void setSpeed(Integer speed) { this.speed = speed; }
    public void setRecordspeed(Integer recordspeed) { this.recordspeed = recordspeed; }
    public void setState(Integer state) { this.state = state; }
    public void setTime(String time) { this.time = time; }

    // Conveniencias numéricas
    public double lat() {
        return Double.parseDouble(gpslat);
    }
    public double lon() {
        return Double.parseDouble(gpslng);
    }

    public boolean formatoValidoCoordenadas() {
        try {
            double la = lat(), lo = lon();
            return la >= -90 && la <= 90 && lo >= -180 && lo <= 180;
        } catch (Exception e) {
            return false;
        }
    }

    @Override public String toString() {
        return "Telemetry{terid=" + terid +
               ", gpslat=" + gpslat +
               ", gpslng=" + gpslng +
               ", speed=" + speed +
               ", time=" + time + "}";
    }
}
