package br.com.grupo.trabalho;

public class Professor extends Pessoa{
    private String disciplina;

    public Professor(String nome, int idade, String endereco, String disciplina) {
        super(nome, idade, endereco);
        this.disciplina = disciplina;
    }

    public void agendarAula(String horario) {
        System.out.println(getNome() + " agendou uma aula de " + disciplina + " para " + horario);
    }

    public void cancelarAula(String horario) {
        System.out.println(getNome() + " cancelou a aula de " + disciplina + " para " + horario);
    }

    public String getDisciplina() {
        return disciplina;
    }
}
