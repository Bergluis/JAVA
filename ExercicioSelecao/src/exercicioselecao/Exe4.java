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
public class Exe4 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float nota1,nota2,freq,med;
        int aulas,aulasalu;
        
        System.out.println("Nota 1 do aluno: ");
            nota1 = entrada.nextFloat();
        System.out.println("Nota 2 do aluno: ");
            nota2 = entrada.nextFloat();
        System.out.println("Quantidade de aulas ministradas: ");
            aulas = entrada.nextInt();
        System.out.println("Quantidade de aulas assistidas pelo aluno: ");
            aulasalu = entrada.nextInt();
        
        med = (nota1+nota2)/2;
        freq = (aulasalu*100)/aulas;
        
        if (med >= 6 && freq >= 75){
            System.out.println("Aluno aprovado com nota "+ med +" na média!");
            System.out.println("Frequência: "+ freq +"%");
        }
        else{
            System.out.println("Aluno reprovado com nota "+ med +" na média!");
            System.out.println("Frequência: "+ freq +"%");
        }
    }
}
