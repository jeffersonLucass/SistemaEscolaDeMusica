package br.com.grupo.trabalho;

public class Aluno extends Pessoa {
    private String cursoInscrito;

    public Aluno(String nome, int idade, String endereco) {
        super(nome, idade, endereco);
        this.cursoInscrito = null;
    }

    public void inscreverCurso(String curso) {
        this.cursoInscrito = curso;
        System.out.println(getNome() + " se inscreveu no curso de " + curso);
    }

    public void cancelarInscricao() {
        this.cursoInscrito = null;
        System.out.println(getNome() + " cancelou a inscrição no curso.");
    }

    public String getCursoInscrito() {
        return cursoInscrito;
    }
}
