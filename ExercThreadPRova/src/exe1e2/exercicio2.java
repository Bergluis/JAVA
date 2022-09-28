package exe1e2;

public class exercicio2 {

    public static void main(String[] args) {
        Thread mt1= new Thread(new minhaThread());
        mt1.start();
        
        minhaThread2 mt2=new minhaThread2();
        mt2.start();
    }
}
