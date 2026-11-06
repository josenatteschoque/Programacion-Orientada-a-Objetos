import java.util.concurrent.ThreadLocalRandom;

public class Ejecutable implements Runnable{

	@Override
	public void run() {
		try {
			int randoNum = ThreadLocalRandom.current().nextInt(2000, 5000);
			System.out.println("Hola soy executable!");
			Thread.sleep(randoNum);
			System.out.println("Adios soy executable!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
