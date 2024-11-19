package br.com.grupo.trabalho;

import java.util.Scanner;

import br.com.grupo.trabalho.fact.IniciarCurso;
import br.com.grupo.trabalho.inter.Agendavel;
import br.com.grupo.trabalho.obser.Observer;

public class Aluno extends Pessoa implements Observer, Agendavel {
	Scanner scanner = new Scanner(System.in);
	
 	private int matricula;
 	private String cursoInscrito;
 	private boolean presenca = false;
	
	public Aluno(String nome, int idade, String endereco, int matricula) {
		super(nome, idade, endereco);
		this.matricula = matricula;
	 }

	@Override
	public void update(String mensagem) {
		System.out.println(getNome() + " foi notificado pois: " + mensagem);
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public void setCursoInscrito(String cursoInscrito) {
		this.cursoInscrito = cursoInscrito;
	}
	
	public String getCursoInscrito() {
	    return cursoInscrito;
	}
	
	public boolean getPresenca() {
		return presenca;
	}

	public int inscreverCurso() {
		int op;
		do {
			System.out.println("\nOlá, " + getNome() + ". Em qual curso deseja se inscrever: ");
			System.out.println("1 - Canto");
			System.out.println("2 - Teoria Musical");
			System.out.println("3 - Piano");
			System.out.print("Informe a opção desejada: ");
			op = scanner.nextInt();
			scanner.nextLine();
			switch(op) {
				case 1: 
					cursoInscrito = "Canto";
					break;
				case 2:
					cursoInscrito = "Teoria Musical";
					break;
				case 3:
					cursoInscrito = "Piano";
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while((op < 1) && (op > 3));
		return op;
	}
	
	@Override
	public boolean agendarAula(IniciarCurso cursos) {
		int op;
		System.out.print(cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h. ");
		do {
			System.out.println("Deseja agendar aula para esse dia? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Informe a opção desejada: ");
			op = scanner.nextInt();
			switch(op) {
				case 1:
					presenca = true;
					System.out.println("\nAula agendada.");
					break;
				case 2:
					presenca = false;
					System.out.println("\nAula não agendada.");
					break;
				default: 
					System.out.println("\nOpção inválida.");
					break;
			}
		} while((op < 1) || (op > 2));
		return true;
	}

	@Override
	public boolean cancelarAula(IniciarCurso cursos) {
		int op;
		System.out.println(cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h e o(a) senhor(a) agendou uma aula para esse dia.");
		do {
			System.out.println("Deseja desagendar a aula desse dia? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Informe a opção desejada: ");
			op = scanner.nextInt();
			switch(op) {
				case 1:
					presenca = true;
					System.out.println("\nAula desagendada.");
					break;
				case 2:
					presenca = false;
					System.out.println("\nAula não desagendada.");
					break;
				default: 
					System.out.println("\nOpção inválida.");
					break;
			}
		} while((op < 1) || (op > 2));
		return true;
	}

}