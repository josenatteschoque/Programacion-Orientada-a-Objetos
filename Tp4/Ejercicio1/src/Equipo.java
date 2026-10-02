import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Equipo implements Runnable {

    private final BlockingQueue<String> cinta;
    private final int numero;
    private final Random random = new Random();

    public Equipo(BlockingQueue<String> cinta, int numero) {
        this.cinta = cinta;
        this.numero = numero;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= Main.PRODUCTOS_POR_EQUIPO; i++) {
                // entre 2000 y 3000 ms
                Thread.sleep(2000 + random.nextInt(1001));

                String producto = "Equipo " + numero + " - producto " + i;
                cinta.put(producto); // se bloquea si la cinta está llena
                System.out.println("Ingresó a la cinta: " + producto);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}