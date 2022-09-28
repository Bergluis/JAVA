/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioselecao2;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Exe4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x,idade,nota,quant10,maiida,idades,notabaix=0,nome=0,velho=0;
        float medidade,porcento;
        maiida=0;
        quant10=0;
        idades=0;
        
        for(x=0;x<=100;x++){
            System.out.println("Sua idade: ");
            idade = entrada.nextInt();
            System.out.println("Sua poltrona: ");
            nome = entrada.nextInt();
            System.out.println("Sua opinião sobre a peça (0 à 10): ");
            nota = entrada.nextInt();
            if(nota == 10){
                quant10++;
            }
            idades=idades+idade;
            if(nota <= 5){
                notabaix++;
            }
            if(idade>maiida){
                maiida = idade;
                velho = nome;
            }
        }
        System.out.println(quant10 + " pessoas deram nota máxima para a peça");
        medidade = (float)idades/100;
        System.out.println("A média das idades é " + medidade);
        System.out.println(notabaix + "% das pessoas deram nota menor ou igual a 5");
        System.out.println(velho + " foi a poltrona da pessoa mais velha a assistir a peça");
    }
}
