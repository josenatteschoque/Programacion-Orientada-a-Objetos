
public class Main {
	public static void main(String[] ags) {
		Hilo hilo = new Hilo();
		hilo.start();
		
		Ejecutable ejecutable = new Ejecutable();
		Thread thread = new Thread(ejecutable);
		thread.start();
	}
	
}
