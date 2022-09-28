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
public class Exe5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int ano,quantliv,fic,quant2=0,maiquant=0,x=0,y=0,fic1;
        float per;
        
        System.out.println("Informe seu ano: ");
            ano = entrada.nextInt();
        while(ano!=0){
            x++;
            System.out.println("Quantidade de livros que você lê por ano: ");
                quantliv = entrada.nextInt();
                System.out.println("Você gosta de livros de ficção (1=sim 2=não)? ");
            fic1 = entrada.nextInt();
            if(ano==2){
                quant2++;
            }else if(ano==3 && quantliv > maiquant){
                maiquant = quantliv;
            }else if(fic1==1 && ano==1){
                y++;
            }
            System.out.println("Informe seu ano: ");
                ano = entrada.nextInt();
        }
        if(ano!=0 || x!=0){
        System.out.println(quant2 + " aluno(s) está(ão) no segundo ano!");
        System.out.println("O aluno do terceiro ano que mais leu livros esse ano, leu " + maiquant + " livros");
        per = (y*100)/x;
        System.out.println(per + "% dos alunos são do primeiro ano e gostam de ficção!");
        }
    }
}
