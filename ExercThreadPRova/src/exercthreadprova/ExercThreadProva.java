package exercthreadprova;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class minhathread extends Thread{
int maximo;
    
minhathread(int p){
    this.maximo = p;
    }

    public void run(){
        int metade = maximo/2;
        
        //achar um numero aleatorio = http://www.devmedia.com.br/numeros-aleatorios-em-java-a-classe-java-util-random/26355 
        Random gerador = new Random();
        int segundos = gerador.nextInt(5);
        
        
        for (int x = 0; x < maximo; x++)
        {
            if (x == metade)
                            try {
                                //fazer parar por alguns segundos = http://www.guj.com.br/t/funcao-sleep/33034/2
                                Thread.currentThread().sleep(segundos*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(minhathread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Thread : "+x);
        }
    }
}


public class ExercThreadProva {
    public static void main(String[] args) {
        System.out.println("em programação, ninguém, além do criador do código, é capaz de entender a sua lógica.");
        /*System.out.println("Digite quantas threads voce quer:");
        Scanner e = new Scanner(System.in);
        int totalThreads = e.nextInt();
        e.nextLine();
        
        int maximoThread[] = new int[totalThreads];
        
        for (int p = 0; p< totalThreads; p++){
            System.out.println("Digite o maximo da Thread "+(p+1)+" :");
            
            maximoThread[p] = e.nextInt();
            e.nextLine();
        
        }
        
        minhathread[]vetorThreads = new minhathread[totalThreads];
        
        //caso queiram podem usar arraylist.
        for (int p = 0; p< totalThreads; p++){
        vetorThreads[p] = new minhathread(maximoThread[p]);
        vetorThreads[p].start();
            }*/
        }
    
    
        
        
    }