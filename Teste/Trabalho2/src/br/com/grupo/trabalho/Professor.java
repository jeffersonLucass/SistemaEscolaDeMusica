package br.com.grupo.trabalho;

import java.time.LocalTime;
import java.util.Scanner;

import br.com.grupo.trabalho.fact.IniciarCurso;
import br.com.grupo.trabalho.inter.Agendavel;
import br.com.grupo.trabalho.obser.Observer;

public class Professor extends Pessoa implements Observer, Agendavel {
	Scanner scanner = new Scanner(System.in);

	private String cursoLecionado;

	public Professor(String nome, int idade, String endereco, String cursoLecionado) {
		super(nome, idade, endereco);
		this.cursoLecionado = cursoLecionado;
	}

	@Override
	public void update(String mensagem) {
		System.out.println(getNome() + " foi notificado pois: " + mensagem);
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
		LocalTime horarioTemp = LocalTime.of(00, 00, 00);
		if(cursos.getHorarioAula().equals(horarioTemp)) {
			validacao = false;
		} else {
			System.out.println("\nSua aula " + cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h foi agendada com sucesso.\n");
			validacao = true;
		}
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