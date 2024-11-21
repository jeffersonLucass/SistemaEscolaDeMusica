package br.com.grupo.trabalho.fact;

//importação da classe localtime que é utilizada para representar horários
import java.time.LocalTime;

//declaração de interface
public interface IniciarCurso {

	//método abstrato para iniciar uma aula
	public void iniciarAula();

	//método abstrato para obter o nome do curso
	public String getNome();

	//método abstrato para definir o nome do curso
	public void setNome(String nome);

	//método abstrato para obter o dia da aula
	public String getDiaAula();

	//método abstrato para definir o dia da aula
	public boolean setDiaAula(String diaAula);

	//método abstrato para obter o horário da aula
	public LocalTime getHorarioAula();

	//método abstrato para definir o horário da aula
	//recebe como parâmetros os valores de hora, minuto e segundo
	//e retorna um booleano indicando se a operação foi bem sucedida
	public boolean setHorarioAula(int hora, int minuto, int segundo);
}
