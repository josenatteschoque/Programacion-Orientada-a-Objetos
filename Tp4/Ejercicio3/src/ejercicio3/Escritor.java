package ejercicio3;

import java.util.concurrent.BlockingQueue;

public class Escritor implements Runnable{
	private final int num;
	
	public Escritor(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		System.out.println("Esta escribiendo");
	}
	
}
