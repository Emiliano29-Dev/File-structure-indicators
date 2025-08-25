import java.util.List;

public interface StationRepository {
    // Debería devolver todo el repositorio de
    // estaciones independientemente desde
    // donde se consulten
    List<Station> findAllActivas() throws Exception;
}

