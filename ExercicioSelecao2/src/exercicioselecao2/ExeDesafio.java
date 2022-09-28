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
public class ExeDesafio {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int dia,mes,ano;
        String teste;
        
        do{
            System.out.println("Mês de nascimento: ");
                mes = entrada.nextInt();
            System.out.println("Dia de nascimento: ");
                dia = entrada.nextInt();
            if(mes==2 && (dia>29 || dia<1)){
                System.out.println("Dia inválido!");
                    do{
                        System.out.println("Dia de nascimento: ");
                             dia = entrada.nextInt();
                    }while( dia>29 && dia<1);
                }else if((mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) && (dia>31 || dia<1)){
                        System.out.println("Dia inválido!");
                        do{
                            System.out.println("Dia de nascimento: ");
                                dia = entrada.nextInt();
                        }while (dia>31 && dia<1);
                    }else if(dia>30 || dia<1){
                        System.out.println("Dia inválido!");
                        do{
                            System.out.println("Dia de nascimento: ");
                                dia = entrada.nextInt();
                        }while( dia>30 && dia<1);
                }
            System.out.println("Ano de nascimento: ");
                ano = entrada.nextInt();
            switch(mes){
                case 1:
                    if(dia<=19){
                        System.out.println("Seu signo é Capricórnio");
                    }else{
                        System.out.println("Seu signo é Aquário");
                    }
                    break;
                case 2:
                    if(dia<=18){
                        System.out.println("Seu signo é Aquário");
                    }else{
                        System.out.println("Seu signo é Peixes");
                    }
                    break;
                case 3:
                    if(dia<=20){
                        System.out.println("Seu signo é Peixes");
                    }else{
                        System.out.println("Seu signo é Áries");
                    }
                    break;
                case 4:
                    if(dia<=19){
                        System.out.println("Seu signo é Áries");
                    }else{
                        System.out.println("Seu signo é Touro");
                    }
                    break;
                case 5:
                    if(dia<=20){
                        System.out.println("Seu signo é Touro");
                    }else{
                        System.out.println("Seu signo é Gêmeos");
                    }
                    break;
                case 6:
                    if(dia<=20){
                        System.out.println("Seu signo é Gêmeos");
                    }else{
                        System.out.println("Seu signo é Câncer");
                    }
                    break;
                case 7:
                    if(dia<=22){
                        System.out.println("Seu signo é Câncer");
                    }else{
                        System.out.println("Seu signo é Leão");
                    }
                    break;
                case 8:
                    if(dia<=22){
                        System.out.println("Seu signo é Leão");
                    }else{
                        System.out.println("Seu signo é Virgem");
                    }
                    break;
                case 9:
                    if(dia<=22){
                        System.out.println("Seu signo é Virgem");
                    }else{
                        System.out.println("Seu signo é Libra");
                    }
                    break;
                case 10:
                    if(dia<=22){
                        System.out.println("Seu signo é Libra");
                    }else{
                        System.out.println("Seu signo é Escorpião");
                    }
                    break;
                case 11:
                    if(dia<=21){
                        System.out.println("Seu signo é Escorpião");
                    }else{
                        System.out.println("Seu signo é Sagitário");
                    }
                    break;
                case 12:
                    if(dia<=22){
                        System.out.println("Seu signo é Sagitário");
                    }else{
                        System.out.println("Seu signo é Capricórnio");
                    }
                    break;     
            }
            System.out.println("Você deseja refazer o teste? ");
                teste = entrada.next();
        }while(teste.equalsIgnoreCase("sim"));
    }    
}
