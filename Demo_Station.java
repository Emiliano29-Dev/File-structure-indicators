public class Demo_Station {

    public static void main(String [] args) {
        //Creamos objeto de tipo estacion
        Station Estacion_Prueba = new Station(
        1,
        "CHA",
        "CHAPULTEPEC",
        "CHA-SAN",
        19.4206333333333,
        -99.1761666666666, true      
        );

        //Vemos si se creo exitosamente el objeto
        System.out.println(Estacion_Prueba);

        double distancia = Geo.haversine(
            19.42, -99.17,
         19.387, -99.1902);

        String distancia_truncada = String.format("%.2f",distancia);

        System.out.println("La distancia es de: " + distancia_truncada + "metros");
    }
    
}
