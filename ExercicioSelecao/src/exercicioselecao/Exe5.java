/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioselecao;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Exe5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float precocom;
        int quant,cod;
        
        System.out.println("Insira o código do produto: ");
            cod = entrada.nextInt();
        System.out.println("Digite a quantidade do produto: "+ cod +" que você comprou!"); 
            quant = entrada.nextInt();
        
        if(cod == 100){
            precocom = (float) 2.5 * quant;
            System.out.println("Total da compra: R$"+ precocom);
        }
        else if (cod == 101){
                precocom = 3 * quant;
                System.out.println("Total da compra: R$"+ precocom);
            }
            else if (cod == 102){
                precocom = 5 * quant;
                System.out.println("Total da compra: R$"+ precocom);
                }
                else if (cod == 103){
                        precocom = (float) 7.5 * quant;
                        System.out.println("Total da compra: R$"+ precocom);
                    }
                else if (cod == 104){
                        precocom = 15 * quant;
                        System.out.println("Total da compra: R$"+ precocom);
                    }
                else{
                    System.out.println("Código do produto inválido");
                }
    }
}
