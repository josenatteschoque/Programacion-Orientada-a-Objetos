import java.util.concurrent.BlockingQueue;

public class Empacadora implements Runnable {

    private final BlockingQueue<String> cinta;
    private final int totalProductos;

    public Empacadora(BlockingQueue<String> cinta, int totalProductos) {
        this.cinta = cinta;
        this.totalProductos = totalProductos;
    }

    @Override
    public void run() {
        int enCaja = 0;
        try {
            for (int i = 1; i <= totalProductos; i++) {
                String producto = cinta.take(); // se bloquea si está vacía
                Thread.sleep(1000);             // 1 segundo por producto
                enCaja++;
                System.out.println("    Empacado: " + producto
                        + " (" + enCaja + "/6 en la caja)");

                if (enCaja == 6) {
                    Thread.sleep(3000);         // 3 segundos para cerrar la caja
                    System.out.println("    >>> Caja cerrada <<<");
                    enCaja = 0;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}