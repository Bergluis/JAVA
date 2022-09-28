
package registroacademico;

import java.util.LinkedList;
import java.util.Scanner;

public class BergamotaComLista {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        LinkedList<BergamotaGoldEdition>listaAlunos = new LinkedList();
        System.out.println("Deseja: 1 - Cadastrar  2 - Visualizar Cadastros  3 - Sair");
            int opcao = entrada.nextInt();
            
        while(opcao != 3){
            if(opcao == 1){
                System.out.print("Matricula: ");
                String matricula = entrada.nextLine();
                matricula = entrada.nextLine();
            System.out.print("Nome: ");
                String nome = entrada.nextLine();
            System.out.print("Curso: ");
                String curso = entrada.nextLine();
            BergamotaGoldEdition meuAluno = new BergamotaGoldEdition(matricula, nome, curso);
            
                System.out.println("Nota 1:");
                float nota1 = entrada.nextFloat();
                meuAluno.setNota1(nota1);
                System.out.println("Nota 2:");
                float nota2 = entrada.nextFloat();
                meuAluno.setNota2(nota2);
                System.out.println("Nota 3:");
                float nota3 = entrada.nextFloat();
                meuAluno.setNota3(nota3);
                
                meuAluno.calcularmedia();
                meuAluno.verificarSituacao();
                
                listaAlunos.add(meuAluno);
            }else if(opcao == 2){
                for(int x = 0; x < listaAlunos.size(); x++){
                    BergamotaGoldEdition meuAluno = listaAlunos.get(x);
                    System.out.println("Pessoa "+ (x+1) +"->  Nome: "+ meuAluno.getNome() +" Matricula: "+ meuAluno.getMatricula() +" Curso: "+ meuAluno.getCurso());
                    System.out.println("Situação: "+ meuAluno.getSituacao());
                }
            }
        System.out.println("Deseja: 1 - Cadastrar  2 - Visualizar Cadastros  3 - Sair");
            opcao = entrada.nextInt();
        }       
    }
}