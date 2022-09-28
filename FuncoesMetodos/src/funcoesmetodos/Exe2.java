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
public class Exe2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String par;
        int x1,x2,x3,y1,opca;
        do{
            System.out.println("Digite o primeiro número: ");
            x1 = entrada.nextInt();
            System.out.println("Digite o segundo número: ");
            x2 = entrada.nextInt();
            System.out.println("Digite o terceiro número: ");
            x3 = entrada.nextInt();
            System.out.println("Operação maior ou menor (1 ou 2)");
            opca = entrada.nextInt();
            y1 = obtemMaiorMenorValor(x1, x2, x3, opca);
            if(opca == 1){
                System.out.println("O maior valor é " + y1);
            }else if(opca == 2){
                System.out.println("O menor valor é " + y1);
            }
            System.out.println("Quer realizar a operação novamente? ");
            par = entrada.next();
        }while(par.equalsIgnoreCase("sim"));
    }
    
    
    static int obtemMaiorMenorValor(int num1,int num2,int num3,int oper){
        int val = 0;
        if(oper == 1){
            if(num1>num2 && num1>num3){
                val = num1;
            }else if(num2>num3 && num2>num1){
                val = num2;
            }else if(num3>num1 && num3>num2){
                val = num3;
            }
        }else if(oper == 2){
            if(num1<num2 && num1<num3){
                val = num1;
            }else if(num2<num3 && num2<num1){
                val = num2;
            }else if(num3<num1 && num3<num2){
                val = num3;
            }
        }
        return val;
    }
}
