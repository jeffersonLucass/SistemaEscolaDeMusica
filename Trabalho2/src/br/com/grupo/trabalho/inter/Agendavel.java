package br.com.grupo.trabalho.inter;

import br.com.grupo.trabalho.fact.IniciarCurso;

public interface Agendavel {
	public boolean agendarAula(IniciarCurso cursos);
	public boolean cancelarAula(IniciarCurso cursos);
}
