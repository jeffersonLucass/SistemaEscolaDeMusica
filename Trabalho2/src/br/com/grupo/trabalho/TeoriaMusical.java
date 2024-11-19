package br.com.grupo.trabalho;

public class TeoriaMusical extends Curso {
	public TeoriaMusical(String nome, String diaAula, int hora, int minuto, int segundo) {
		super(nome, diaAula, hora, minuto, segundo);
	}

	@Override
	public void iniciarAula() {
		System.out.println("Aula de teoria musical iniciada.");
	}
}
