package br.com.grupo.trabalho.single;

import java.util.ArrayList;
import java.util.List;

import br.com.grupo.trabalho.Aluno;
import br.com.grupo.trabalho.Curso;
import br.com.grupo.trabalho.Professor;

public class GerenciadorDeAula {

    // Instância única do Singleton
    private static GerenciadorDeAula instancia;

    // Listas para armazenar dados do sistema
    private List<Curso> cursos;
    private List<Professor> professores;
    private List<Aluno> alunos;

    // Construtor privado para evitar instância externa
    private GerenciadorDeAula() {
        cursos = new ArrayList<>();
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    // Método para obter a instância única
    public static GerenciadorDeAula getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorDeAula();
        }
        return instancia;
    }

    // Métodos de gerenciamento
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    // Exemplo: Encontrar um curso por nome
    public Curso encontrarCursoPorNome(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        return null;
    }
}
