import java.util.ArrayList;
import java.util.List;

public class InMemoryStationRepository implements StationRepository {
    @Override
    public List<Station> findAllActivas() { 
        List<Station> list = new ArrayList<>();

        //Direccion CHA-SAN
        list.add(new Station(1L, "CHA", "CHAPULTEPEC", "CHA-SAN", 19.4206333333333, -99.1761666666666, true));
        list.add(new Station(2L, "JNO", "JUANACATLAN_OESTE", "CHA-SAN", 19.41283, -99.1820466666666, false));
        list.add(new Station(3L, "IGE", "IGNACIO_ESTEVAN", "CHA-SAN", 19.4095333333, -99.1836, false));
        list.add(new Station(4L, "BFK", "BENJAMIN_FRANKLIN", "CHA-SAN", 19.4078444444, -99.1842166667, false));
        list.add(new Station(5L, "PNO", "AV_PROGRESO_NACIONAL_OESTE", "CHA-SAN", 19.4063944444, -99.1844, false));
        list.add(new Station(6L, "JMO", "JOSE_MARTI_OESTE", "CHA-SAN", 19.4033083333, -99.1846472222, false));
        list.add(new Station(7L, "JMA", "JOSE_MARIA_VIGIL", "CHA-SAN", 19.4014416667, -99.1847694444, false));
        list.add(new Station(8L, "H10", "HEROE_DE_1810", "CHA-SAN", 19.39890167, -99.18509167, false));     
        list.add(new Station(9L, "11E", "11_DE_ABRIL_OESTE", "CHA-SAN", 19.3959388889, -99.1, false));
        list.add(new Station(10L, "C02", "CALLE_2", "CHA-SAN", 19.3924055556, -99.18579444, false));
        list.add(new Station(11L, "SPP", "SAN_PEDRO_DE_LOS_PINOS", "CHA-SAN", 19.39130167, -99.1859466666666, false));
        list.add(new Station(12L, "C10", "CALLE_10", "CHA-SAN", 19.3891722222, -99.1861805556, false));
        list.add(new Station(13L, "C22", "CALLE_22", "CHA-SAN", 19.3859166667, -99.1865805556, false));
        list.add(new Station(14L, "SAT", "SALVADOR_AGRAZ_TERMINAL", "CHA-SAN", 19.38486389, -99.18686111, false));
        list.add(new Station(15L, "RMD", "REMBRANDT", "CHA-SAN", 19.3812305556, -99.1871027778, false));
        list.add(new Station(16L, "MRL", "MURILLO", "CHA-SAN", 19.3803883333333, -99.1919116666666, false));
        list.add(new Station(17L, "MXO", "MIXCOAC_OESTE", "CHA-SAN", 19.3762266666666, -99.1877416666666, false));
        list.add(new Station(18L, "TZI", "TIZIANO", "CHA-SAN", 19.3731472222, -99.1880861111, false));
        list.add(new Station(19L, "CHV", "LOS ECHAVE", "CHA-SAN", 19.3719472222, -99.1882277778, false));
        list.add(new Station(20L, "CTÑ", "LA_CASTAÑEDA", "CHA-SAN", 19.3709833333, -99.1883305556, false));
        list.add(new Station(21L, "MCB", "MIGUEL_CABRERA", "CHA-SAN", 19.3693472222, -99.1885194444, false));
        list.add(new Station(22L, "MCG", "MERCED_GOMEZ", "CHA-SAN", 19.3668083333, -99.1888111111, false));
        list.add(new Station(23L, "JTI", "JUAN_TINOCO", "CHA-SAN", 19.3647555556, -99.1890638889, false));
        list.add(new Station(24L, "BMU", "BARRANCA_DEL_MUERTO", "CHA-SAN", 19.361435, -99.1892716666666, false));
        list.add(new Station(25L, "SOF", "SOFIA", "CHA-SAN", 19.3574027778, -99.1897444444, false));
        list.add(new Station(26L, "RBK", "ROBERTO_BOCKER", "CHA-SAN", 19.356005, -99.1900266666666, false));
        list.add(new Station(27L, "TCP", "TLACOPAC", "CHA-SAN", 19.3540277778, -99.19025, false));
        list.add(new Station(28L, "MLU", "MARIA_LUISA", "CHA-SAN", 19.3513694444, -99.1904472222, false));
        list.add(new Station(29L, "ATV", "ALTAVISTA", "CHA-SAN", 19.3471722222, -99.1902805556, false));
        list.add(new Station(30L, "AVP", "AVENIDA_DE_LA_PAZ", "CHA-SAN", 19.3464833333, -99.1901222222, false));
        list.add(new Station(31L, "DRG", "DOCTOR_GALVEZ", "CHA-SAN", 19.34385, -99.190355, false));
        list.add(new Station(32L, "RCU", "REY_CUAUHTEMOC", "CHA-SAN", 19.3424166667, -99.1908527778, false));
        list.add(new Station(33L, "ALT", "ALTAMIRANO", "CHA-SAN", 19.3398916667, -99.1916444444, false));
        list.add(new Station(34L, "E10", "EJE_10_SUR", "CHA-SAN", 19.33863, -99.1921833333333, false));
        list.add(new Station(35L, "PSJ", "PUENTE_SAN_JERONIMO", "CHA-SAN", 19.3366416666666, -99.1931766666666, true));

        //Direccion SAN-CHA
        list.add(new Station(36L, "PSJ", "PUENTE_SAN_JERONIMO", "SAN-CHA", 19.3366416666666, -99.1931766666666, true));
        list.add(new Station(37L, "E10", "EJE_10_SUR", "SAN-CHA", 19.33863, -99.1921833333333, false));
        list.add(new Station(38L, "ALT", "ALTAMIRANO", "SAN-CHA", 19.3398916667, -99.1916444444, false));
        list.add(new Station(39L, "RCU", "REY_CUAUHTEMOC", "SAN-CHA", 19.3424166667, -99.1908527778, false));
        list.add(new Station(40L, "DRG", "DOCTOR_GALVEZ", "SAN-CHA", 19.34385, -99.190355, false));
        list.add(new Station(41L, "AVP", "AVENIDA_DE_LA_PAZ", "SAN-CHA", 19.3464833333, -99.1901222222, false));
        list.add(new Station(42L, "ATV", "ALTAVISTA", "SAN-CHA", 19.3471722222, -99.1902805556, false));
        list.add(new Station(43L, "MLU", "MARIA_LUISA", "SAN-CHA", 19.3513694444, -99.1904472222, false));
        list.add(new Station(44L, "FVL", "FERNANDO_VILLALPANDO", "SAN-CHA", 19.3513694444, -99.1904472222, false));
        list.add(new Station(45L, "RCT", "RICARDO_CASTRO", "SAN-CHA", 19.3556777778, -99.189825, false));
        list.add(new Station(46L, "SOF", "SOFIA", "SAN-CHA", 19.3574027778, -99.1897444444, false));
        list.add(new Station(47L, "FLP", "FELIPE_VILLANUEVA", "SAN-CHA", 19.3602055556, -99.1892888889, false));
        list.add(new Station(48L, "BMU", "BARRANCA_DEL_MUERTO", "SAN-CHA", 19.361435, -99.1892716666666, false));
        list.add(new Station(49L, "JMV", "JOSE_MARIA_VELASCO", "SAN-CHA", 19.3644861111, -99.1888694444 , false));
        list.add(new Station(50L, "DBC", "DIEGO_BECERRA", "SAN-CHA", 19.3665638889, -99.1886055556, false));
        list.add(new Station(51L, "ADC", "ANDRES_DE_LA_CONCHA", "SAN-CHA", 19.3687111111, -99.1883555556, false));
        list.add(new Station(52L, "JCT", "JOSE_DEL_CASTILLO", "SAN-CHA", 19.3717444444, -99.1880361111, false));
        list.add(new Station(53L, "GOY", "GOYA", "SAN-CHA", 19.3739416667, -99.1870583333, false));
        list.add(new Station(54L, "MXE", "MIXCOAC_ESTE", "SAN-CHA", 19.3760722222, -99.1865583333, false));
        list.add(new Station(55L, "RBN", "RUBENS", "SAN-CHA", 19.378325, -99.1857861111, false));
        list.add(new Station(56L, "ING", "INEGI_PATRIOTISMO", "SAN-CHA", 19.379775, -99.1853388889, false));
        list.add(new Station(57L, "HOL", "HOLBEIN", "SAN-CHA", 19.3808138889, -99.1847944444, false));
        list.add(new Station(58L, "TTT", "TINTORETO", "SAN-CHA", 19.3836416667, -99.183644444, false));
        list.add(new Station(59L, "SAN", "SAN_ANTONIO", "SAN-CHA", 19.3849138889, -99.1830916667, false));
        list.add(new Station(60L, "C21", "CALLE_21", "SAN-CHA", 19.3872555556, -99.1824916667, false));
        list.add(new Station(61L, "C17", "CALLE_17", "SAN-CHA", 19.3885944444, -99.1823361111, false));
        list.add(new Station(62L, "C09", "CALLE_09", "SAN-CHA", 19.391075, -99.1820416667, false));
        list.add(new Station(63L, "PMR", "PUENTE_DE_LA_MORENA", "SAN-CHA", 19.3952277778, -99.1813638889, false));
        list.add(new Station(64L, "11E", "11_DE_ABRIL_ESTE", "SAN-CHA", 19.3969527778, -99.1809111111, false));
        list.add(new Station(65L, "13S", "13_DE_SEPTIEMBRE", "SAN-CHA", 19.3989833333, -99.1803027778, false));
        list.add(new Station(66L, "MRC", "MARTIRES_DE_LA_CONQUISTA", "SAN-CHA", 19.4005666667, -99.1797277778, false));
        list.add(new Station(67L, "JME", "JOSE_MARTI_ESTE", "SAN-CHA", 19.4005666667, -99.1797277778, false));
        list.add(new Station(68L, "PNE", "AV_PROGRESO_NACIONAL_ESTE", "SAN-CHA", 19.4042555556, -99.1784055556, false));
        list.add(new Station(69L, "PAT", "PATRIOTISMO", "SAN-CHA", 19.4057722222, -99.1780083333, false));
        list.add(new Station(70L, "TAM", "AV_TAMAULIPAS", "SAN-CHA", 19.4070055556, -99.17855, false));
        list.add(new Station(71L, "MZT", "AV_MAZATLÁN", "SAN-CHA", 19.4089944444, -99.1797583333, false));
        list.add(new Station(72L, "ARY", "ALFONSO_REYES", "SAN-CHA", 19.4104388889, -99.1806444444, false));
        list.add(new Station(73L, "JNE", "JUANACATLAN_ESTE", "SAN-CHA", 19.4123861111, -99.1812222222, false));
        list.add(new Station(74L, "CJE", "CALLE_JUAN_ESCUTIA", "SAN-CHA", 19.4165333333, -99.17895, false));
        list.add(new Station(75L, "FMS", "FARMACIA_IMSS", "SAN-CHA", 19.4195833333, -99.177325, false));
        list.add(new Station(76L, "CHA", "CHAPULTEPEC", "SAN-CHA", 19.4206333333333, -99.1761666666666, true));
        return list;
    }
}