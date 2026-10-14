package ejercicio3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacion {
	public static void main(String [] args) {
		
		//Creo 12 hilos
		 ExecutorService pool = Executors.newFixedThreadPool(12);
		 pool.execute(new Escritor(2));
		 pool.execute(new Escritor(2));
		 pool.execute(new Lector());
		 
		 
	}
}
