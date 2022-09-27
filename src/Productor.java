import java.util.concurrent.TimeUnit;

public class Productor implements Runnable {
    Monitor m;

    public Productor(Monitor m) {
     this.m=m;
    }

    @Override
    public void run() {
        while(true) {
            m.insertar(5);
            System.out.println("estoy producciendo "+ Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }
}
