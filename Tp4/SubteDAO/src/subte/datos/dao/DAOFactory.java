package subte.datos.dao;

public interface DAOFactory {
    LineaDAO getLineaDAO();
    EstacionDAO getEstacionDAO();
    TramoDAO getTramoDAO();
}
