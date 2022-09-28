/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contalewis;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Contalista {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        LinkedList<Conta>listaContas = new LinkedList();
        System.out.println("1-Cadastrar conta;");
        System.out.println("2-Verificar saldo;");
        System.out.println("3-Efetuar saque;");
        System.out.println("4-Efetuar deposito;");
        System.out.println("5-Pesquisa por CPF;");
        System.out.println("6-Encerrar programa.");
        int opca = entrada.nextInt();
        boolean x;
        int y;
        
        while(opca != 6){
            switch(opca){
                case 1:
                    System.out.print("CPF: ");
                    String cpf = entrada.next();
                    System.out.print("Nome: ");
                    String nome = entrada.next();
                    Conta minhaConta = new Conta(cpf, nome);
                    listaContas.add(minhaConta);
                    break;
                case 2:
                    System.out.println("Número da conta: ");
                    y = entrada.nextInt();
                    minhaConta = listaContas.get(y);
                    x = minhaConta.verificaSituacao(listaContas.size(), y);
                    if(x == true){
                        System.out.println("Saldo: " + minhaConta.getSaldo());
                    } else {
                        System.err.println("Conta inválida!");
                    }
                    break;
                case 3:
                    System.out.println("Número da conta: ");
                    y = entrada.nextInt();
                    minhaConta = listaContas.get(y);
                    x = minhaConta.verificaSituacao(listaContas.size(), y);
                    if(x == true){
                        System.out.println("Valor do saque: ");
                        float valorSaque = entrada.nextFloat();
                        boolean h = minhaConta.sacar(valorSaque);
                        if(h == true){
                            System.out.println("Saque efetuado com sucesso!");
                        } else {
                            System.err.println("Saque inválido!");
                        }
                    } else {
                        System.err.println("Conta inválida!");
                    }
                    break;
                case 4:
                    System.out.println("Número da conta: ");
                    y = entrada.nextInt();
                    minhaConta = listaContas.get(y);
                    x = minhaConta.verificaSituacao(listaContas.size(), y);
                    if(x == true){
                        System.out.println("Valor do deposito: ");
                        float valorDeposito = entrada.nextFloat();
                        minhaConta.depositar(valorDeposito);
                    } else {
                        System.err.println("Conta inválida!");
                    }
                    break;
                case 5:
                    System.out.println("CPF: ");
                    cpf = entrada.next();
                    boolean teste = false;
                    for(int i = 0;i < listaContas.size();i++){
                        minhaConta = listaContas.get(i);
                        if(minhaConta.getCpfTitular().equals(cpf)){
                            System.out.println("Nome: " + minhaConta.getNomeTitular() + ", Saldo: " + minhaConta.getSaldo());
                            teste = true;
                            break;
                        }
                    }
                    if(teste == false){
                        System.err.println("CPF Inválido!");
                        break;
                    }
            }
            
            System.out.println("1-Cadastrar conta;");
            System.out.println("2-Verificar saldo;");
            System.out.println("3-Efetuar saque;");
            System.out.println("4-Efetuar deposito;");
            System.out.println("5-Pesquisa por CPF;");
            System.out.println("6-Encerrar programa.");
            opca = entrada.nextInt();
        }
        System.out.println("Relatório:");
        for(int i = 0; i < listaContas.size(); i++){
                    Conta minhaConta = listaContas.get(i);
                    System.out.println("Nome: " + minhaConta.getNomeTitular());
                    System.out.println("CPF: " + minhaConta.getCpfTitular());
                    System.out.println("Saldo: " + minhaConta.getSaldo());
                }
    }
}
