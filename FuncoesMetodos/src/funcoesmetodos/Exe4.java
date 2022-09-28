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
public class Exe4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int vetor[] = new int[10];
        for(int x=0;x<vetor.length;x++){
            System.out.println("Digite o valor para o vetor posição " + x);
            vetor[x] = entrada.nextInt();
        }
        System.out.println("Operação positivos, negativos e zeros (1, 2 ou 3)");
        int opca = entrada.nextInt();
        int h1 = contaValores(vetor, opca);
        if(opca == 1){
            System.out.println(h1 + " valores são positivos");
        }else if(opca == 2){
            System.out.println(h1 + " valores são negativos");
        }else if(opca == 3){
            System.out.println(h1 + " valores são zero");
        }
    }
    
    static int contaValores(int[] valores, int cont){
        int y = 0;
        if(cont == 1){
            for(int x=0;x<valores.length;x++){
                if(valores[x]>0){
                    y++;
                }
            }
        }else if(cont == 2){
            for(int x=0;x<valores.length;x++){
                if(valores[x]<0){
                    y++;
                }
            }
        }else if(cont == 3){
                for(int x=0;x<valores.length;x++){
                    if(valores[x]==0){
                        y++;
                    }
                }
            }
        return y;
        }
}
