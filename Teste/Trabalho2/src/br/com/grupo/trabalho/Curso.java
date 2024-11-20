
package br.com.grupo.trabalho;

import java.time.LocalTime;
import java.util.Objects;

import br.com.grupo.trabalho.fact.IniciarCurso;
import br.com.grupo.trabalho.obser.Sujeito;

public abstract class Curso extends Sujeito implements IniciarCurso {
	private String nome;
	private String diaAula;
	private LocalTime horarioAula;

	public Curso(String nome, String diaAula, int hora, int minuto, int segundo) {
		super();
		this.nome = nome;
		this.diaAula = diaAula;
		this.horarioAula = LocalTime.of(hora, minuto, segundo);
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getDiaAula() {
		return diaAula;
	}

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

	@Override
	public LocalTime getHorarioAula() {
		return horarioAula;
	}

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
