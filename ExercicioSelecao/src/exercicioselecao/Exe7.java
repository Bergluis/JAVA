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
public class Exe7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nome1,nome2,nome3;
        
        System.out.println("Insira o 1° nome: ");
            nome1 = entrada.nextLine();
        System.out.println("Insira o 2° nome: ");
            nome2 = entrada.nextLine();
        System.out.println("Insira o 3° nome: ");
            nome3 = entrada.nextLine();
            
        if (nome1.equalsIgnoreCase(nome2) && nome1.equalsIgnoreCase(nome3)){
            System.out.println("Os nomes são todos iguais!");
        }
        else if (nome1.equalsIgnoreCase(nome2)){
                System.out.println("Apenas os nomes 1 e 2 são iguais!");
            }
            else if (nome2.equalsIgnoreCase(nome3)){
                    System.out.println("Apenas os nomes 2 e 3 são iguais!");
                }
                else if (nome1.equalsIgnoreCase(nome3)){
                        System.out.println("Apenas os nomes 1 e 3 são iguais!");
                    }
                    else{
                        System.out.println("Os nomes são todos diferentes");
                    }
    }
}
