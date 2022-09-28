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
public class Exe3 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num1,num2,num3,res3;
        float res1;
        
        System.out.println("Digite o 1° número: ");
            num1 = entrada.nextInt();
        System.out.println("Digite o 2° número: ");
            num2 = entrada.nextInt();
        System.out.println("Digite o 3° número: ");
            num3 = entrada.nextInt();
        
        if (num1 > 0){
            res1 = num1*3;
            System.out.println("Triplo de "+ num1 +" é "+ res1);
        }
        else{
            res1 = num1/3;
            System.out.println("A terça parte de "+ num1 +" é "+ res1);
        }
        
        if (num2 > 5 && num2 < 20){
            System.out.println("Número está entre 5 e 20");
        }
        
        if(num1 > num3){
            res3 = num1-num3;
            System.out.println("A diferença entre o 1° e o 3° número é "+ res3);
        }
        else{
            res3 = num3*2;
            System.out.println("O dobro de "+ num3 +" é "+ res3);
        }
    }
}
