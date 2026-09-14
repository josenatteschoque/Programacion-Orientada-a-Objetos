package suma;
import javax.swing.JOptionPane;

public class EntradaRapida {
    public static void main(String[] args) {
        // 1. Mostrar un mensaje
        JOptionPane.showMessageDialog(null, "¡Hola! Vamos a pedirte unos datos.");

        // 2. Pedir un texto (Input)
        String nombre = JOptionPane.showInputDialog("¿Cómo te llamás?");

        // 3. Pedir un número (siempre entra como texto, hay que convertirlo)
        String inputEdad = JOptionPane.showInputDialog("¿Cuántos años tenés?");
        int edad = Integer.parseInt(inputEdad);

        // 4. Mostrar el resultado
        JOptionPane.showMessageDialog(null, "Hola " + nombre + ", tenés " + edad + " años.");
    }
}