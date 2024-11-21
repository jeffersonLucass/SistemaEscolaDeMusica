package br.com.grupo.trabalho.inter;

//importação da interface
import br.com.grupo.trabalho.fact.IniciarCurso;

//declaração da interface
public interface Agendavel {

	//método abstrato para agendar uma aula
	//parâmetro: um objeto do tipo IniciarCurso que representa o curso que será agendado
	//retorna: um booleano indicando se o agendamento foi bem-sucedido
	public boolean agendarAula(IniciarCurso cursos);

	//método abstrato para cancelar uma aula
	//parâmetro: um objeto do tipo IniciarCurso que representa o curso cuja aula será cancelada
	//retorna: um booleano indicando se o cancelamento foi bem-sucedido
	public boolean cancelarAula(IniciarCurso cursos);
}
