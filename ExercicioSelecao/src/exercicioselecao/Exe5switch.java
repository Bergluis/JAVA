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
public class Exe5switch {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double precocom;
        int quant,cod;
        
        System.out.println("Insira o código do produto: ");
            cod = entrada.nextInt();
        System.out.println("Digite a quantidade do produto: "+ cod +" que você comprou!"); 
            quant = entrada.nextInt();
        
        switch (cod) {
            case 100:
                precocom = 2.5 * quant;
                System.out.println("Total da compra: R$"+ precocom);
                break;
            case 101:
                precocom = 3 * quant;
                System.out.println("Total da compra: R$"+ precocom);
                break;
            case 102:
                precocom = 5 * quant;
                System.out.println("Total da compra: R$"+ precocom);
                break;
            case 103:
                precocom = 7.5 * quant;
                System.out.println("Total da compra: R$"+ precocom);
                break;
            case 104:
                precocom = 15 * quant;
                System.out.println("Total da compra: R$"+ precocom);
                break;
            default:
                System.out.println("Código inválido");
                break;
        }
    }
}
