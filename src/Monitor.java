import java.util.concurrent.Semaphore;

public class Monitor {

  int n,tam,frente,cola;
  Semaphore nolleno,novacio;
   int recurso[];

    public Monitor(int n) {
        this.tam = 0;
        this.frente = 0;
        this.cola = 0;
        this.n=n;
        this.recurso=new int[n];
        nolleno= new Semaphore(n);
        novacio=new Semaphore(0);
    }
    public void insertar(int number){
        try {
            System.out.println("por producir, soy: "+Thread.currentThread().getName()+"; Recursos disponibles: "+tam);
            nolleno.acquire(); //entra a nolleno, decrementa
            recurso[cola]=number;
            cola=(cola+1)%n;
            tam++;
           // System.out.println("valor de cola : "+ cola +"\n valor de n :"+n);
          //  System.out.println("info del semaforo nolleno: "+ nolleno.toString());
            System.out.println("recurso producido por: "+Thread.currentThread().getName()+ " Recursos disponibles: "+tam);
            novacio.release();

            //System.out.println("info del semaforo novacio (insertar): "+ novacio.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public int extraer(){
        int unidad;
        try {
            System.out.println("por consumir, soy: "+Thread.currentThread().getName()+"; Recursos disponibles: "+tam);
            novacio.acquire(); //entra al novacio decrementa contador
           // System.out.println("valor frente antes de extraer: "+ frente+"\n");
            unidad=recurso[frente];
            frente=(frente+1)%n;
            tam--;
          //  System.out.println("valor de frente : "+ frente +"\nvalor de unidad :"+unidad);
            //System.out.println("info del semaforo novacio: "+ novacio.toString());
            System.out.println("recurso consumido por: "+Thread.currentThread().getName()+ " Recursos disponibles: "+tam);
            nolleno.release();

            //System.out.println("info del semaforo novacio (extraer): "+ novacio.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return unidad;
    }

}
