package Exercicio4;

import Exercicio4.minhaThread4;
import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite quantas threads você deseja:");
        int totalThread = entrada.nextInt();
        System.out.println("Digite um inteiro:");
        int num = entrada.nextInt();
        entrada.nextLine();
        int y = num/totalThread;
        if(!(y%3==0)){
            System.err.println("Número inválido");
        }
        minhaThread4[]vetorThreads=new minhaThread4[totalThread];
            vetorThreads[0]=new minhaThread4(y);
            vetorThreads[0].start();
            vetorThreads[1]=new minhaThread4(y*2);
            vetorThreads[1].start();
            vetorThreads[2]=new minhaThread4(y*3);
            vetorThreads[2].start();
    }
}
