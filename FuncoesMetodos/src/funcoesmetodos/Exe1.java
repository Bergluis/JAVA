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
public class Exe1 {
            
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String par;
        int x1,x2,x3,y1,y2;
        do{
            System.out.println("Digite o primeiro número: ");
            x1 = entrada.nextInt();
            System.out.println("Digite o segundo número: ");
            x2 = entrada.nextInt();
            System.out.println("Digite o terceiro número: ");
            x3 = entrada.nextInt();
            y1 = obtemMaiorValor(x1, x2, x3);
            y2 = obtemMenorValor(x1, x2, x3);
            System.out.println("O maior valor é " + y1 + " e o menor valor é " + y2);
            System.out.println("Quer realizar a operação novamente? ");
            par = entrada.next();
        }while(par.equalsIgnoreCase("sim"));
    }
    
    
    static int obtemMaiorValor(int num1,int num2,int num3){
        int maival = 0;
        if(num1>num2 && num1>num3){
            maival = num1;
        }else if(num2>num3 && num2>num1){
            maival = num2;
        }else if(num3>num1 && num3>num2){
            maival = num3;
        }
        return maival;
    }
    
    static int obtemMenorValor(int num1,int num2,int num3){
        int menval = 0;
        if(num1<num2 && num1<num3){
            menval = num1;
        }else if(num2<num3 && num2<num1){
            menval = num2;
        }else if(num3<num1 && num3<num2){
            menval = num3;
        }
        return menval;
    }
}
