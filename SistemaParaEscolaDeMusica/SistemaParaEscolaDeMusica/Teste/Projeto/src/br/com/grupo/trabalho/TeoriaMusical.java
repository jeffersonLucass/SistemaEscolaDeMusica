package br.com.grupo.trabalho;

//classe TeoriaMusical
public class TeoriaMusical extends Curso {
	//construtor da classe TeoriaMusical
	public TeoriaMusical(String nome, String diaAula, int hora, int minuto, int segundo) {
		super(nome, diaAula, hora, minuto, segundo);
	}

	//sobrescrita do método iniciarAula
	@Override
	public void iniciarAula() {
		System.out.println("Aula de teoria musical iniciada.");
	}
}