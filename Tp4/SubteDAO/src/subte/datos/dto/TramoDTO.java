package subte.datos.dto;

public class TramoDTO {
    private String codigoEstacion1; // IDs de referencia
    private String codigoEstacion2;
    private int tiempo;
    private int tipo;

    public TramoDTO(String codigoEstacion1, String codigoEstacion2, int tiempo, int tipo) {
        this.codigoEstacion1 = codigoEstacion1;
        this.codigoEstacion2 = codigoEstacion2;
        this.tiempo = tiempo;
        this.tipo = tipo;
    }

    public String getCodigoEstacion1() { return codigoEstacion1; }
    public String getCodigoEstacion2() { return codigoEstacion2; }
    public int getTiempo() { return tiempo; }
    public int getTipo() { return tipo; }
}
