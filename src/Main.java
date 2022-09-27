public class Main  {
    public static void main(String[] args) {
        int hilos=4;
        Monitor monitor= new Monitor(4);
        Runnable productor=new Productor(monitor);
        Runnable consumidor= new Consumidor(monitor);
        Thread[] hilosproductores = new  Thread[hilos] ;
        Thread[] hilosconsumidores = new  Thread[hilos] ;

        for(int i=0; i<hilos;i++) {
            hilosproductores[i]= new Thread(productor);
            hilosconsumidores[i]= new Thread(consumidor);
            hilosproductores[i].setName("Productor " + i);
            hilosconsumidores[i].setName("Consumidor " + i);
        }
        for(int i=0; i<hilos;i++) {
            hilosproductores[i].start();
            hilosconsumidores[i].start();
        }

    }
}
