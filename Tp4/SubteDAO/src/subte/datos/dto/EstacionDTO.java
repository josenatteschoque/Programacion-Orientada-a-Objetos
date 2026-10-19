package subte.datos.dto;

public class EstacionDTO {
    private String codigo;
    private String nombre;
    private String codigoLinea; // En el DTO viaja solo el ID/Código, no el objeto Línea completo

    public EstacionDTO(String codigo, String nombre, String codigoLinea) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoLinea = codigoLinea;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCodigoLinea() { return codigoLinea; }
}
