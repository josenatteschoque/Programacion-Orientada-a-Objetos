package mensajes.modelo;

import java.util.List;

public class SeleccionMensaje {
    public enum Tipo { BIENVENIDA, DESPEDIDA }

    private Tipo seleccion;

    public List<Tipo> opciones() {
        return List.of(Tipo.values());
    }

    public void seleccionar(Tipo tipo) {
        seleccion = tipo;
    }

    public Tipo getSeleccion() {
        return seleccion;
    }
}
