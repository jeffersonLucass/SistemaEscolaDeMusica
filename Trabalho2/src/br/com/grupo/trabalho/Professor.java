package br.com.grupo.trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.grupo.trabalho.fact.IniciarCurso;
import br.com.grupo.trabalho.inter.Agendavel;
import br.com.grupo.trabalho.obser.Observer;

public class Professor extends Pessoa implements Observer, Agendavel {
	Scanner scanner = new Scanner(System.in);
	private List<Observer> alunosInscritos = new ArrayList<>();

	private String cursoLecionado;

	public Professor(String nome, int idade, String endereco, String cursoLecionado) {
		super(nome, idade, endereco);
		this.cursoLecionado = cursoLecionado;
	}

	@Override
	public void update(String mensagem) {
		System.out.println(getNome() + " foi notificado pois: " + mensagem);
	}

	public void adicionarAlunoInscrito(Observer aluno, String curso) {
		if (cursoLecionado.equalsIgnoreCase(curso) && !alunosInscritos.contains(aluno)) {
			alunosInscritos.add(aluno);
		}
	}

	public void notificarObservers(String mensagem) {
		for (Observer aluno : alunosInscritos) {
			aluno.update(mensagem);
		}
	}



	public String getCursoLecionado() {
		return cursoLecionado;
	}

	public void setCursoLecionado(String cursoLecionado) {
		this.cursoLecionado = cursoLecionado;
	}

	@Override
	public boolean agendarAula(IniciarCurso cursos) {
		boolean validacao;
		do {
			System.out.print("\nInforme o dia da semana que deseja marcar a aula(Ex: Segunda-feira): ");
			String diaAula = scanner.nextLine();
			validacao = cursos.setDiaAula(diaAula);
		} while(validacao == false);
		do {
			System.out.print("Informe o horário da aula(Ex: hh mm ss): ");
			int hora = scanner.nextInt();
			int minuto = scanner.nextInt();
			int segundo = scanner.nextInt();
			scanner.nextLine();
			validacao = cursos.setHorarioAula(hora, minuto, segundo);
		} while(validacao == false);
		System.out.println("\nAula agendada com sucesso.");
		return validacao;
	}

	@Override
	public boolean cancelarAula(IniciarCurso cursos) {
		if(cursos.getDiaAula() == null) {
			System.out.println("O(a) senhor(a) não tem nenhuma aula agendada que possa desmarcar.");
			return false;
		} else {
			System.out.print("\nSua aula " + cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h.");
			cursos.setDiaAula(null);
			cursos.setHorarioAula(00, 00, 00);
			System.out.println(" Foi cancelada com sucesso.");
			return true;
		}
	}

}