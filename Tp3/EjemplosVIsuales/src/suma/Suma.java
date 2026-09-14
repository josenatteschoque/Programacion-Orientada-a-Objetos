package suma;
import javax.swing.JOptionPane;

public class Suma {
	public static void main(String[] arr) {
		JOptionPane.showInternalMessageDialog(null, "Programa para sumar");
		String dato1 = JOptionPane.showInputDialog("Ingrese el primer numero: ");
		int num1 = Integer.parseInt(dato1);
		
		String dato2 = JOptionPane.showInputDialog("Ingrese el segundo numero: ");
		int num2 = Integer.parseInt(dato2);
		
		int resul = num1 + num2;
		
		JOptionPane.showMessageDialog(null, resul);
		
	}
}
