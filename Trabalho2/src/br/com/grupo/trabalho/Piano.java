package br.com.grupo.trabalho;

public class Piano extends Curso {
	public Piano(String nome, String diaAula, int hora, int minuto, int segundo) {
		super(nome, diaAula, hora, minuto, segundo);
	}

	@Override
	public void iniciarAula() {
		System.out.println("Aula de piano iniciada.");
	}
}
