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
public class Exe1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1,num2,op,res;
        
        System.out.println("Digite o primeiro valor: ");
        num1 = entrada.nextInt();
        System.out.println("Digite o segundo valor");
        num2 = entrada.nextInt();
        System.out.println("Qual operação você quer fazer: \n 1: Obter o maior valor\n 2: Obter o menor valor \n 3: Verificar se o primeiro valor é maior do que 100\n 4: Verificar se o segundo valor é maior do que 50");
        op = entrada.nextInt();
        switch (op) {
            case 1:
                res = (num1>num2 ? num1 : num2);
                System.out.println("O maior número é " + res);
                break;
            case 2:
                res = (num1<num2 ? num1 : num2);
                System.out.println("O menor valo é " + res);
                break;
            case 3:
                res = (num1>100 ? 1 : 0);
                if (res==1){
                    System.out.println("O primeiro número é maior que 100");}
                else{
                    System.out.println("O primeiro número não é maior que 100");                    
                }
                break;
            case 4:
                res = (num2>50 ? 1 : 0);
                if (res==1){
                    System.out.println("O segundo número é maior que 50");
                }
                else{
                    System.out.println("O segundo número não é maior que 50");                    
                }
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}