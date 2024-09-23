package dev.model;

import java.util.List;

public class Professor extends Pessoa {
    private String numeroIdentificacao;
    private String departamento;
    private List<String> disciplinas;

    // Construtor
    public Professor(String nomeCompleto, String dataNascimento, String numeroIdentificacao, String departamento, List<String> disciplinas) {
        super(nomeCompleto, dataNascimento);
        this.numeroIdentificacao = numeroIdentificacao;
        this.departamento = departamento;
        this.disciplinas = disciplinas;
    }

    // Getters e Setters
    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    // Implementação do método abstrato
    @Override
    public void exibirInformacoes() {
        System.out.println("Professor: " + getNomeCompleto());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Número de Identificação: " + numeroIdentificacao);
        System.out.println("Departamento: " + departamento);
        System.out.println("Disciplinas que pode ministrar: " + disciplinas);
    }
}

