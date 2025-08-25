public final class Geo {
    //Radio terrestre en metros}
    private static final double RADIO_TERRESTRE_METROS = 6371000.0;

    //Ca
    public static double haversine (double lat1_dec, double lon1_dec, double lat2_dec, double lon2_dec){
        //convertimos valores decimales a radianes
        double lat1 = Math.toRadians(lat1_dec);
        double lon1 = Math.toRadians(lon1_dec);
        double lat2 = Math.toRadians(lat2_dec);
        double lon2 = Math.toRadians(lon2_dec);

        //deltas
        double deltalat = (lat2-lat1);
        double deltalon = (lon2-lon1);
        
        //Formula del Haversiano

        //miembro 1
        double miem1 = Math.sin(deltalat/2) * Math.sin(deltalat/2) +
        Math.cos(lat1) * Math.cos(lat2) * 
        Math.sin(deltalon/2) * Math.sin(deltalat/2);

        //miembro 2
        double miem2 = 2 * Math.asin(Math.sqrt(miem1));
        
        //Distancia entre coordenadas
        return RADIO_TERRESTRE_METROS * miem2;
    }
    private Geo(){}
}


