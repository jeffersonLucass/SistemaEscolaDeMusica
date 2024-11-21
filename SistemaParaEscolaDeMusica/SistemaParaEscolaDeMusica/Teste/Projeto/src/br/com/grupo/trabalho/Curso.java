
package br.com.grupo.trabalho;

import java.time.LocalTime;//para trabalhar com horários
import java.util.Objects;//para comparações seguras de objetos

import br.com.grupo.trabalho.fact.IniciarCurso;//interface implementada pela classe
import br.com.grupo.trabalho.obser.Sujeito;//classe que implementa o padrão Observer

//classe abstrata Curso
public abstract class Curso extends Sujeito implements IniciarCurso {
	//atributos da classe
	private String nome;
	private String diaAula;
	private LocalTime horarioAula;

	//construtor da classe Curso
	public Curso(String nome, String diaAula, int hora, int minuto, int segundo) {
		super();
		this.nome = nome;
		this.diaAula = diaAula;
		this.horarioAula = LocalTime.of(hora, minuto, segundo);
	}

	//implementação do método getNome da interface IniciarCurso
	@Override
	public String getNome() {
		return nome;
	}

	//implementação do método setNome da interface IniciarCurso
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	//implementação do método getDiaAula da interface IniciarCurso
	@Override
	public String getDiaAula() {
		return diaAula;
	}

	//implementação do método setDiaAula da interface IniciarCurso
	@Override
	public boolean setDiaAula(String diaAula) {
		if (diaAula == null || diaAula.matches("(Segunda-feira|Terça-feira|Quarta-feira|Quinta-feira|Sexta-feira|Sábado|Domingo)")) {
			this.diaAula = diaAula;
			notifyObservers("Dia da aula alterado para: " + diaAula);
			return true;
		} else {
			System.out.println("Dia da semana inválido.");
			return false;
		}
	}

	//implementação do método getHorarioAula da interface IniciarCurso
	@Override
	public LocalTime getHorarioAula() {
		return horarioAula;
	}

	//implementação do método setHorarioAula da interface IniciarCurso
	@Override
	public boolean setHorarioAula(int hora, int minuto, int segundo) {
		if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59 || segundo < 0 || segundo > 59) {
			System.out.println("Horário inválido.");
			return false;
		} else {
			this.horarioAula = LocalTime.of(hora, minuto, segundo);
			notifyObservers("Horário da aula alterado para: " + horarioAula);
			return true;
		}
	}
}
