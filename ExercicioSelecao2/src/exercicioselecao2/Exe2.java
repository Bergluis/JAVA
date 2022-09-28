/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioselecao2;

/**
 *
 * @author Luis
 */
public class Exe2 {
    public static void main (String[] args){
        float s;
        int x,y;
        y=1;
        s=0;
        for(x=1;x<=50;x++){
            s=s+((float) y/x);
            y=y+2;
        }
        System.out.println("O resultado é " + s);
    }
}
