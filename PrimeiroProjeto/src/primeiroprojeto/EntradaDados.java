/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeiroprojeto;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class EntradaDados {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int idade;
        String nome;
        float altura;
        System.out.println("Informe o nome: ");
            nome = entrada.nextLine();//line=string
        System.out.println("Informe a idade: ");
            idade = entrada.nextInt();//int=int
        System.out.println("Informe a altura: ");
            altura = entrada.nextFloat();//float=float
        System.out.println("      Ficha");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Altura" + altura);
        
        if (nome.equalsIgnoreCase ("Luis")){
            System.out.println("Que nome Beautiful!");
        }
    }    
}
