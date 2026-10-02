import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int CANT_EQUIPOS = 3;
    public static final int PRODUCTOS_POR_EQUIPO = 24;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> cinta = new ArrayBlockingQueue<>(12);

        // Pool de 4 hilos: 3 equipos + 1 empacadora
        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.execute(new Equipo(cinta, 1));
        pool.execute(new Equipo(cinta, 2));
        pool.execute(new Equipo(cinta, 3));
        pool.execute(new Empacadora(cinta, CANT_EQUIPOS * PRODUCTOS_POR_EQUIPO));

        pool.shutdown();                              // no acepta tareas nuevas
        pool.awaitTermination(10, TimeUnit.MINUTES);  // espera a que terminen

        System.out.println("Simulación terminada.");
    }
}