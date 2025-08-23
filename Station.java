public class Station {
    public final long identificadorBaseDeDatos;
    public final String codigoDeEstacion;
    public final String nombreDeLaEstacion;
    public final String direccion;
    public final double latitudDecimal;
    public final double longitudDecimal;


//Contructor de clase
    public Station(long identificadorBaseDeDatos, String codigoDeEstacion, String nombreDeLaEstacion, String direccion, double latitudDecimal, double longitudDecimal){
        this.identificadorBaseDeDatos = identificadorBaseDeDatos;
        this.codigoDeEstacion = codigoDeEstacion;
        this.nombreDeLaEstacion = nombreDeLaEstacion;
        this.direccion = direccion;
        this.latitudDecimal = latitudDecimal;
        this.longitudDecimal = longitudDecimal;

    }

    @Override
    public String toString(){
        return String.format("%s (%s) [%f, %f] - %s",
        nombreDeLaEstacion,codigoDeEstacion,
        latitudDecimal,longitudDecimal,direccion);
    }

}
