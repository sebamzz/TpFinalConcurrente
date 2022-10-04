import java.util.concurrent.TimeUnit;

public class Productor implements Runnable {
    Monitor m;
    Recursos recursos;
    static int elemento;
    public Productor(Monitor m, Recursos recursos) {
        elemento=1;
     this.m=m;
     this.recursos=recursos;
    }
    @Override
    public void run() {
        while(true) {
            m.permiteinsertar();
            recursos.insertar(elemento);
            elemento++;
           m.recursoinsertado();
        }
        }
}
