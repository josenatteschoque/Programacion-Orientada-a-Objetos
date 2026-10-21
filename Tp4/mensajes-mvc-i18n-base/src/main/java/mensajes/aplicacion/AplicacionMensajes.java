package mensajes.aplicacion;

import mensajes.config.UILoader;
import mensajes.ui.api.UIEngine;

public class AplicacionMensajes {
    public static void main(String[] args) {
        UIEngine ui = UILoader.createUIEngine();
        ui.start();
    }
}
