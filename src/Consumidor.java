import java.util.concurrent.TimeUnit;

public class Consumidor implements Runnable {
    Monitor m;
    public Consumidor(Monitor m) {
        this.m=m;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Estoy consumiendo :" + m.extraer() +" - "+ Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
