package exe3;

public class minhaThread3 extends Thread {
    int num;
    public minhaThread3(int n){
        this.num=n;
    }
    @Override
    public void run() {
       System.out.println("Olá eu sou a Thread número "+this.num+".Onde "+this.num+" é o número da Thread criada.");
    }
}