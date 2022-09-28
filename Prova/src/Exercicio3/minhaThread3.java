package Exercicio3;

public class minhaThread3 extends Thread {
    int entrada;
    public minhaThread3(int p){
        this.entrada=p;
    }
    @Override
    public void run() {
       System.out.println("Olá eu sou a Thread número "+(this.entrada+1)+".Onde "+this.entrada+" é o número da Thread criada.");
    }
}