package subte.datos.dao;

import java.util.List;

import subte.datos.dto.TramoDTO;

public interface TramoDAO {
    List<TramoDTO> obtenerTodos() throws Exception;
}
