package mensajes.config;

import mensajes.ui.api.UIEngine;
import mensajes.ui.impl.cli.Interfaz;
import mensajes.ui.impl.javafx.JavaFXUserInterface;

public class UILoader {
    public static UIEngine createUIEngine() {
        return switch (CargaParametros.ui()) {
            case "javafx" -> new JavaFXUserInterface();
            case "cli" -> new Interfaz();
            default -> throw new IllegalArgumentException(
                "app.ui debe ser javafx o cli");
        };
    }
}
