import java.util.concurrent.ThreadLocalRandom;

public class Hilo extends Thread {
	
	public void run() {
		try {
			int randoNum = ThreadLocalRandom.current().nextInt(2000, 5000);
			System.out.println("Hola soy un hilo!");
			Thread.sleep(randoNum);
			System.out.println("Adios soy un hilo!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
