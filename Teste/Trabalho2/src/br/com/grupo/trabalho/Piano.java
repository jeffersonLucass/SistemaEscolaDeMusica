package br.com.grupo.trabalho;

//classe Piano
public class Piano extends Curso {
	//construtor da classe Piano
	public Piano(String nome, String diaAula, int hora, int minuto, int segundo) {
		super(nome, diaAula, hora, minuto, segundo);
	}
	//sobrescrita do método iniciarAula
	@Override
	public void iniciarAula() {
		System.out.println("Aula de piano iniciada.");
	}
}