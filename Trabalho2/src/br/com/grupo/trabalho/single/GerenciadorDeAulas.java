package br.com.grupo.trabalho.single;


import br.com.grupo.trabalho.Curso;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeAulas {
    private static GerenciadorDeAulas instancia;
    private final List<Curso> listaDeCursos;

    private GerenciadorDeAulas() {
        listaDeCursos = new ArrayList<>();
    }

    public static GerenciadorDeAulas getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorDeAulas();
        }
        return instancia;
    }

    public void adicionarCurso(Curso curso) {
        listaDeCursos.add(curso);
    }

    public List<Curso> getCursos() {
        return listaDeCursos;
    }
}

