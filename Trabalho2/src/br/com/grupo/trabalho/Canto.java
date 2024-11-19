package br.com.grupo.trabalho;

public class Canto extends Curso {
	public Canto(String nome, String diaAula, int hora, int minuto, int segundo) {
		super(nome, diaAula, hora, minuto, segundo);
	}

	@Override
	public void iniciarAula() {
		System.out.println("Aula de canto iniciada.");
	}
}