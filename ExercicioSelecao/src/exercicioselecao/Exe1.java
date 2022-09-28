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
public class Exe1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int votos1,votos2; 
        
        System.out.println("Votos do candidato 1: ");
            votos1 = entrada.nextInt();
        System.out.println("Votos do candidato 2: ");
            votos2 = entrada.nextInt();
        
        if (votos1 > votos2){
            System.out.println("O candidato que assumirá o cargo será o Candidato 1!");
        }
        else    if (votos2 > votos1){
                    System.out.println("O candidato que assumirá o cargo será o Candidato 2!");
                } 
                else{
                    System.out.println("Houve um empate entre os Candidatos!");
                }    
    }
    
}
