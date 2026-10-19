import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class EjemploI18NAmpliado {

    public static void main(String[] args) {
        System.out.println("=== Caso 1: Español ===");
        mostrarInterfaz(new Locale("es"));

        System.out.println("\n=== Caso 2: Inglés ===");
        mostrarInterfaz(new Locale("en"));
    }

    private static void mostrarInterfaz(Locale locale) {
        // Cargar el conjunto de recursos adecuado
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println("Título: " + bundle.getString("app.title"));

        // Formatear cadenas parametrizadas
        String saludo = MessageFormat.format(bundle.getString("welcome.user"), "María");
        String carrito = MessageFormat.format(bundle.getString("items.count"), 5);

        System.out.println(saludo);
        System.out.println(carrito);

        // Clave tomada del bundle base si no existe en el idioma específico
        System.out.println("Mensaje de error: " + bundle.getString("error.not_found"));
    }
}