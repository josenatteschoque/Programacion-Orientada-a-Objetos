package mensajes.ui.i18n;

import java.util.ResourceBundle;
import mensajes.config.CargaParametros;

public class Messages {
    private static final ResourceBundle TEXTOS = ResourceBundle.getBundle(
        "ui.i18n.labels", CargaParametros.locale());

    public static ResourceBundle bundle() {
        return TEXTOS;
    }

    public static String text(String clave) {
        return TEXTOS.getString(clave);
    }
}
