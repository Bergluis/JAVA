
package exe3;

import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args){
        Scanner e = new Scanner(System.in);
        System.out.println("Digite quantas threads você quer:");
        int totalThreads = e.nextInt();
        e.nextLine();
        minhaThread3[]vetorThreads=new minhaThread3[totalThreads];
        for (int i=0;i<totalThreads;i++){
            vetorThreads[i]=new minhaThread3(i);
            vetorThreads[i].start();
        }
    }
}
