package mensajes.config;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class CargaParametros {
    private static final Properties CONFIG = new Properties();

    static {
        try (var in = CargaParametros.class
                .getResourceAsStream("/application.properties")) {
            if (in == null) {
                throw new IllegalStateException("Falta application.properties");
            }
            CONFIG.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer la configuración", e);
        }
    }

    public static Locale locale() {
        return Locale.of(CONFIG.getProperty("app.language", "es"),
                         CONFIG.getProperty("app.country", "AR"));
    }
    public static String ui() {
        return CONFIG.getProperty("app.ui", "javafx")
            .trim().toLowerCase(Locale.ROOT);
    }
}
