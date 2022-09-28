/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contalewis;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class User {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Quantas contas irão ser criadas? ");
        int qtcontas = entrada.nextInt();
        Conta[] contas = new Conta[qtcontas];
        
        for(int x = 0; x < contas.length; x++){
            System.out.println("CPF do titular: ");
            String cpf = entrada.next();
            System.out.println("Nome do titular: ");
            String nome = entrada.next();
            
            contas[x] = new Conta(cpf,nome);
        }
        
        int opca;
        
        do{
            System.out.println("1-Visualizar o nome e o CPF do titular da conta;");
            System.out.println("2-Verificar saldo;");
            System.out.println("3-Efetuar saque;");
            System.out.println("4-Efetuar deposito;");
            System.out.println("5-Encerrar programa.");
            opca = entrada.nextInt();
            int num = 0;
            if(opca != 5){
                System.out.println("Número da conta: ");
                num = entrada.nextInt();
            }
            switch(opca){
                case 1:
                    System.out.println("Nome: " + contas[num].getNomeTitular() + " CPF: " + contas[num].getCpfTitular());
                    break;
                case 2:
                    System.out.println("Saldo: " + contas[num].getSaldo());
                    break;
                case 3:
                    System.out.println("Valor do saque: ");
                    float saque = entrada.nextFloat();
                    boolean teste = contas[num].sacar(saque);
                    if(teste == false){
                        System.out.println("Saque não efetuado!");
                    }
                    break;
                case 4:
                    System.out.println("Valor do depoisito: ");
                    float deposito = entrada.nextFloat();
                    contas[num].depositar(deposito);
                    break;
                default:
                    System.out.println("Programa encerrado!!");
            }
        }while(opca != 5);
        
        System.out.println("Relatório:");
        for(int x = 0; x < contas.length; x++){
            System.out.println("Nome: " + contas[x].getNomeTitular());
            System.out.println("CPF: " + contas[x].getCpfTitular());
            System.out.println("Saldo: " + contas[x].getSaldo());
        }
    }
}
