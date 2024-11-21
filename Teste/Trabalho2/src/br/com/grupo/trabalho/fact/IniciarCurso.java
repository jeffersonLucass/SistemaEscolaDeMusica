package br.com.grupo.trabalho.fact;

import java.time.LocalTime;

public interface IniciarCurso {
	public void iniciarAula();
	public String getNome();
	public void setNome(String nome);
	public String getDiaAula();
	public boolean setDiaAula(String diaAula);
	public LocalTime getHorarioAula();
	public boolean setHorarioAula(int hora, int minuto, int segundo);
}
