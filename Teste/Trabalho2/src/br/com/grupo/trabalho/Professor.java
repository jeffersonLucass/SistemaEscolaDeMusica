package br.com.grupo.trabalho;

import java.time.LocalTime;//para trabalhar com horários
import java.util.Scanner;//para capturar entradas do usuário

import br.com.grupo.trabalho.fact.IniciarCurso;//para capturar entradas do usuário
import br.com.grupo.trabalho.inter.Agendavel;//interface para gerenciamento de agendamento
import br.com.grupo.trabalho.obser.Observer;//interface para implementação do padrão Observer

//classe Professor
public class Professor extends Pessoa implements Observer, Agendavel {
	Scanner scanner = new Scanner(System.in);//Scanner para capturar entradas do usuário

	//atributo específico do professor
	private String cursoLecionado;

	//construtor da classe Professor
	public Professor(String nome, int idade, String endereco, String cursoLecionado) {
		super(nome, idade, endereco);
		this.cursoLecionado = cursoLecionado;
	}

	//implementação do método update da interface Observer
	@Override
	public void update(String mensagem) {
		System.out.println(getNome() + " foi notificado pois: " + mensagem);
	}

	//método getter para obter o curso lecionado
	public String getCursoLecionado() {
		return cursoLecionado;
	}
	//método setter para alterar o curso lecionado
	public void setCursoLecionado(String cursoLecionado) {
		this.cursoLecionado = cursoLecionado;
	}

	//implementação do método agendarAula da interface Agendavel
	@Override
	public boolean agendarAula(IniciarCurso cursos) {
		boolean validacao;
		LocalTime horarioTemp = LocalTime.of(00, 00, 00);
		if(cursos.getHorarioAula().equals(horarioTemp)) {
			validacao = false;
		} else {// Exibe uma mensagem de sucesso para o professor
			System.out.println("\nSua aula " + cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h foi agendada com sucesso.\n");
			validacao = true;
		}
		return validacao;
	}

	//implementação do método cancelarAula da interface Agendavel
	@Override
	public boolean cancelarAula(IniciarCurso cursos) {
		if(cursos.getDiaAula() == null) {
			System.out.println("O(a) senhor(a) não tem nenhuma aula agendada que possa desmarcar.");
			return false;
		} else {//exibe uma mensagem indicando que a aula foi cancelada
			System.out.print("\nSua aula " + cursos.getDiaAula() + " às " + cursos.getHorarioAula() + "h.");
			cursos.setDiaAula(null);
			cursos.setHorarioAula(00, 00, 00);
			System.out.println(" Foi cancelada com sucesso.");
			return true;
		}
	}

}