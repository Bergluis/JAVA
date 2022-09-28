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
public class Exe2 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int golgre,golint;
        
        System.out.println("Gols do gremio: ");
            golgre = entrada.nextInt();
        System.out.println("Gols do inter: ");
            golint = entrada.nextInt();
        
        if (golgre > golint){
            System.out.println("Vitória do GRÊMIO!");
        }
        else    if (golint > golgre){
                    System.out.println("Vitória do inter!");
                } 
                else{
                    System.out.println("EMPATE!");
                }    
    }
}
