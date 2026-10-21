package mensajes.ui.impl.javafx;

import javafx.application.Application;
import mensajes.ui.api.UIEngine;

public class JavaFXUserInterface implements UIEngine {
    @Override
    public void start() {
        Application.launch(MainApp.class);
    }
}
