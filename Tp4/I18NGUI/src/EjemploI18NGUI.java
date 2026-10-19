import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class EjemploI18NGUI extends JFrame {

// Componentes de la interfaz
    private JLabel lblWelcome;
    private JLabel lblMessage;
    private JButton btnAction;
    private JComboBox<String> comboLanguage;

    // Recurso de internacionalización
    private ResourceBundle bundle;

    public EjemploI18NGUI() {
        // Configurar la ventana principal
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        // Instanciar los componentes
        lblWelcome = new JLabel();
        lblMessage = new JLabel();
        btnAction = new JButton();

        // Opciones del selector con banderas (Emojis Unicode)
        String[] languages = { "🇪🇸 Español", "🇬🇧 English" , "Peruano", "Frances", "Ruso"};
        comboLanguage = new JComboBox<>(languages);

        // Escuchador para detectar cuando el usuario cambia el idioma
        comboLanguage.addActionListener(e -> {
            int selectedIndex = comboLanguage.getSelectedIndex();
            if (selectedIndex == 0) {
                actualizarIdioma(new Locale("es"));
            } else if(selectedIndex == 1) {
                actualizarIdioma(new Locale("en"));
            } else if (selectedIndex == 2){
            	actualizarIdioma(new Locale("pe"));
            }else if (selectedIndex == 3){
            	actualizarIdioma(new Locale("fran"));
            } else {
            	actualizarIdioma(new Locale("ru"));
            }
        });

        // Agregar componentes a la ventana
        add(comboLanguage);
        add(lblWelcome);
        add(lblMessage);
        add(btnAction);

        // Cargar idioma por defecto (Español)
        actualizarIdioma(new Locale("es"));
    }

    /**
     * Método para recargar el ResourceBundle y actualizar los textos de la GUI
     */
    private void actualizarIdioma(Locale locale) {
        // Cargar el paquete correspondiente al nuevo Locale
        bundle = ResourceBundle.getBundle("MessagesBundle", locale);

        // Actualizar los textos de la interfaz gráfica
        setTitle(bundle.getString("app.title"));
        lblWelcome.setText(bundle.getString("label.welcome"));
        lblMessage.setText(bundle.getString("label.message"));
        btnAction.setText(bundle.getString("button.action"));
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new EjemploI18NGUI().setVisible(true);
        });
    }
}