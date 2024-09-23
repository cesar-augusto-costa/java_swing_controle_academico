package dev.service;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Aluno> alunos;
    private List<Professor> professores;

    // Construtor
    public PessoaService() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    // Métodos para Alunos
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso: " + aluno.getNomeCompleto());
    }

    public Aluno buscarAlunoPorMatricula(String numeroMatricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumeroMatricula().equals(numeroMatricula)) {
                return aluno;
            }
        }
        System.out.println("Aluno com número de matrícula " + numeroMatricula + " não encontrado.");
        return null;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    // Métodos para Professores
    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso: " + professor.getNomeCompleto());
    }

    public Professor buscarProfessorPorIdentificacao(String numeroIdentificacao) {
        for (Professor professor : professores) {
            if (professor.getNumeroIdentificacao().equals(numeroIdentificacao)) {
                return professor;
            }
        }
        System.out.println("Professor com número de identificação " + numeroIdentificacao + " não encontrado.");
        return null;
    }

    public List<Professor> listarProfessores() {
        return professores;
    }
}

