package br.com.grupo.trabalho;

//classe Canto
//representa um curso específico de canto e herda de Curso
public class Canto extends Curso {
	// Construtor da classe Canto
	public Canto(String nome, String diaAula, int hora, int minuto, int segundo) {
		super(nome, diaAula, hora, minuto, segundo);
	}
	//sobrescrita do método iniciarAula
	@Override
	public void iniciarAula() {
		System.out.println("Aula de canto iniciada.");
	}
}