package ejercicio3;

public class ReadWriteLock{

  //Lector
  private int readers       = 0;
  
  //Escritoras
  private int writers       = 0;
  
  //Escribir solicitudes
  private int writeRequests = 0;

  //Este metodo lo que hace bloquea para leer
  public synchronized void lockRead() throws InterruptedException{
    while(writers > 0 || writeRequests > 0){
      wait();
    }
    readers++;
  }

  //Este metodo lo que hace es desbloquear para leer
  public synchronized void unlockRead(){
    readers--;
    notifyAll();
  }

  //Este metodo lo que hace es bloquea para escribir
  public synchronized void lockWrite() throws InterruptedException{
    writeRequests++;

    while(readers > 0 || writers > 0){
      wait();
    }
    writeRequests--;
    writers++;
  }

  //Este metodo lo que hace es desbloquea para poder escribir
  public synchronized void unlockWrite() throws InterruptedException{
    writers--;
    notifyAll();
  }
}
