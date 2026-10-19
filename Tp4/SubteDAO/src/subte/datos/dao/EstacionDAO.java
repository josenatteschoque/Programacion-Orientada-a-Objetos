package subte.datos.dao;

import java.util.List;
import subte.datos.dto.EstacionDTO;

public interface EstacionDAO {
    List<EstacionDTO> obtenerTodas() throws Exception;
}
