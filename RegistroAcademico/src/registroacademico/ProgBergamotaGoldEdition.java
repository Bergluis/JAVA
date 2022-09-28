/*Nome: Rosnei Almeida e Luis Bergamaschi     Turma: INF3AMB*/
package registroacademico;

import java.util.Scanner;

public class ProgBergamotaGoldEdition {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantidade de alunos: ");
        int qtalunos = entrada.nextInt();
        BergamotaGoldEdition[] alunos = new BergamotaGoldEdition[qtalunos];
        
        for(int x = 0; x < alunos.length; x++){
            System.out.print("Matricula: ");
                String matricula = entrada.nextLine();
                matricula = entrada.nextLine();
            System.out.print("Nome: ");
                String nome = entrada.nextLine();
            System.out.print("Curso: ");
                String curso = entrada.nextLine();
            alunos[x] = new BergamotaGoldEdition(matricula, nome, curso);
        }
        
        for(int x = 0; x < alunos.length; x++){
            System.out.println("Pessoa "+ (x+1) +"->  Nome: "+ alunos[x].getNome() +" Matricula: "+ alunos[x].getMatricula() +" Curso: "+ alunos[x].getCurso());
        }
    }
}
