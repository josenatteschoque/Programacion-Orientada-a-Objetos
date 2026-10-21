package mensajes.ui.impl.javafx.controller;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import mensajes.modelo.SeleccionMensaje;
import mensajes.modelo.SeleccionMensaje.Tipo;
import mensajes.ui.i18n.Messages;

public class MensajesController {
    private final SeleccionMensaje modelo = new SeleccionMensaje();
    private final List<Tipo> tipos = modelo.opciones();

    @FXML private ComboBox<String> opciones;
    @FXML private Label resultado;

    @FXML
    private void initialize() {
        for (Tipo tipo : tipos) {
            opciones.getItems().add(Messages.text("option." + tipo.name()));
        }
    }

    @FXML
    private void mostrar() {
        int indice = opciones.getSelectionModel().getSelectedIndex();
        modelo.seleccionar(indice < 0 ? null : tipos.get(indice));
        Tipo elegido = modelo.getSeleccion();
        String clave = elegido == null
            ? "message.required" : "message." + elegido.name();
        resultado.setText(Messages.text(clave));
    }

    //Metodo a implementar
    @FXML 
    private void limpiar() {
    	int indice = opciones.getSelectionModel().getSelectedIndex();
    	resultado.getText();
    	resultado.setText(null);
    }
}
