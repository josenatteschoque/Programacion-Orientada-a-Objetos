package mensajes.ui.impl.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mensajes.ui.i18n.Messages;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/ui/javafx/view/Mensajes.fxml"),
            Messages.bundle());
        stage.setScene(new Scene(loader.load(), 440, 240));
        stage.setTitle(Messages.text("app.title"));
        stage.show();
    }
}
