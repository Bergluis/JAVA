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
public class ExeDesafio {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int[] vetor = new int [5];
        for(int x=0;x<vetor.length;x++){
            System.out.println("Digite um número para a posição do vetor: ");
            vetor[x] = entrada.nextInt();
        }
        System.out.println("Ordenar crescente ou decrescente (1 ou 2)? ");
        int aux = entrada.nextInt();
        System.out.println("    ");
        if(aux==1){
            ordenadorCrescente(vetor);
        }else{
            ordenadorDecrescente(vetor);
        }
    }
    
    static void ordenadorCrescente(int[] numeros){
        int aux;
        for(int x=0;x<numeros.length-1;x++){
            for(int y=0;y<numeros.length-1;y++){
                if(numeros[y+1]<numeros[y]){
                    aux = numeros[y];
                    numeros[y] = numeros[y+1];
                    numeros[y+1] = aux;
                }
            }
        }
        for(int h=0;h<numeros.length;h++){
            System.out.println(""+ numeros[h]);
        }
    }
    
    static void ordenadorDecrescente(int[] numeros){
        int aux;
        for(int x=0;x<numeros.length-1;x++){
            for(int y=0;y<numeros.length-1;y++){
                if(numeros[y+1]>numeros[y]){
                    aux = numeros[y];
                    numeros[y] = numeros[y+1];
                    numeros[y+1] = aux;
                }
            }
        }
        for(int h=0;h<numeros.length;h++){
            System.out.println(""+ numeros[h]);
        }
    }
}
