/*Nome: Rosnei Almeida e Luis Bergamaschi     Turma: INF3AMB*/
package registroacademico;

public class BergamotaGoldEdition {
    private String matricula;
    private String nome;
    private String curso;
    private float nota1;
    private float nota2;
    private float nota3;
    private float frequencia;
    private float media;
    private int situacao;

    public BergamotaGoldEdition(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(float frequencia) {
        this.frequencia = frequencia;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public void calcularmedia(){
        this.media = (this.nota1 + this.nota2 + this.nota3)/3;
    }
    
    public void verificarSituacao(){
        if(media >= 6 && frequencia >= 75){
            this.situacao = 1;
        } else {
            this.situacao = 2;
        }
    }
    
    public String situacaoLiteral(){
        String retorno = "";
        if(this.situacao == 1){
            retorno = "Aprovado";
        }else if(this.situacao == 2){
            retorno = "Reprovado";
        }
        return retorno;
    }
}
