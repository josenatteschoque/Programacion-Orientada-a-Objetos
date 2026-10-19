package subte.datos.dao;

import java.util.List;
import subte.datos.dto.LineaDTO;

public interface LineaDAO {
    List<LineaDTO> obtenerTodas() throws Exception;
}