package br.com.grupo.trabalho;

import java.time.LocalTime;
import java.util.Objects;

import br.com.grupo.trabalho.fact.IniciarCurso;

public abstract class Curso implements IniciarCurso {
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
		if((diaAula == null) || (Objects.equals(diaAula, "Segunda-feira")) || (Objects.equals(diaAula, "Terça-feira")) || (Objects.equals(diaAula, "Quarta-feira")) || (Objects.equals(diaAula, "Quinta-feira")) || (Objects.equals(diaAula, "Sexta-feira")) || (Objects.equals(diaAula, "Sábado")) || (Objects.equals(diaAula, "Domingo"))) {
			this.diaAula = diaAula;
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
		if((hora < 0) || (hora > 23) || (minuto < 0) || (minuto > 59) || (segundo < 0) || (segundo > 59)) {
			System.out.println("Horário inválido.");
			return false;
		} else {
			this.horarioAula = LocalTime.of(hora, minuto, segundo);
			return true;
		}
	}
	
	public void exibirInfomacoes() {
		
	}
}
