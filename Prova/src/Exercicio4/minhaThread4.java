package Exercicio4;

public class minhaThread4 extends Thread{
    int entrada;
    public minhaThread4(int p){
        this.entrada=p;
    }
    @Override
    public void run() {
        for(int x = 0; x>entrada ;x++){
        System.out.println("Valor: "+this.entrada);
        this.entrada++;
        }
    }
}
