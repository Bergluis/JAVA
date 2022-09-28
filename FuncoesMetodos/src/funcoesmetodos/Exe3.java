/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoesmetodos;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Exe3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int vetor[] = new int[10];
        for(int x=0;x<vetor.length;x++){
            System.out.println("Digite o valor para o vetor posição " + x);
            vetor[x] = entrada.nextInt();
        }
        int h1 = contaPositivos(vetor);
        int h2 = contaNegativos(vetor);
        int h3 = contaZeros(vetor);
        System.out.println(h1 + " valores são positivos");
        System.out.println(h2 + " valores são negativos");
        System.out.println(h3 + " valores são zero");
    }
    
    static int contaPositivos(int[] valores){
        int y = 0;
        for(int x=0;x<valores.length;x++){
            if(valores[x]>0){
                y++;
            }
        }
        return y;
    }
    
    static int contaNegativos(int[] valores){
        int y = 0;
        for(int x=0;x<valores.length;x++){
            if(valores[x]<0){
                y++;
            }
        }
        return y;
    }
    
    static int contaZeros(int[] valores){
        int y = 0;
        for(int x=0;x<valores.length;x++){
            if(valores[x]==0){
                y++;
            }
        }
        return y;
    }
}
