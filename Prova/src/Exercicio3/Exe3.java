package Exercicio3;

import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite quantas threads você deseja:");
        int totalThreads = entrada.nextInt();
        entrada.nextLine();
        minhaThread3[]vetorThreads=new minhaThread3[totalThreads];
        for (int x=0;x<totalThreads;x++){
            vetorThreads[x]=new minhaThread3(x);
            vetorThreads[x].start();
        }
    }
}

