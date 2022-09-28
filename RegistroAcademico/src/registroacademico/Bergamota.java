/*Nome: Rosnei Almeida e Luis Bergamaschi     Turma: INF3AMB*/
package registroacademico;

import java.util.Scanner;

public class Bergamota {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
            System.out.print("Informe a quantidade de alunos no Câmpus:");
                int qtAlunos = entrada.nextInt();
            String container [][] = new String[qtAlunos][3];
            float ctrl [][] = new float[qtAlunos][5];
            int vtr[] = new int[qtAlunos];
            
            for(int x = 0; x < qtAlunos; x++){
                System.out.print("Informe o número da matrícula: ");
                    container[x][0] = entrada.nextLine();
                    container[x][0] = entrada.nextLine();
                System.out.print("Informe o nome do aluno: ");
                    container[x][1] = entrada.nextLine();
                System.out.print("Informe o curso do aluno: ");
                    container[x][2] = entrada.nextLine();         
                for(int y = 0; y < 3; y++){
                    System.out.print("Entre com a nota "+ (y+1) +": ");
                        ctrl[x][y] = entrada.nextFloat();
                }
                System.out.print("Informe a frequência do aluno: ");
                ctrl[x][3] = entrada.nextFloat();
            }
            
            for(int x = 0; x < ctrl.length; x++){
                ctrl[x][4] = (ctrl[x][0] + ctrl[x][1] + ctrl[x][2])/3;
                if(ctrl[x][4] >= 6 && ctrl[x][3] >= 75){
                    vtr[x] = 1;
                }else{
                    vtr[x] = 2;
                }
            }
            
            for(int x = 0; x < container.length; x++){
                for(int y = 0; y < container[x].length; y++){
                    System.out.print(container[x][y] + "  ");
                }
                System.out.print(ctrl[x][4]+"  ");
                System.out.print(vtr[x]);
                System.out.println(" ");
            }      
    }
}