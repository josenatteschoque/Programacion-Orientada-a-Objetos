package subte.datos.dto;

public class LineaDTO {
    private String codigo;
    private String nombre;

    public LineaDTO(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}
