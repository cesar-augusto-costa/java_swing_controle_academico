package dev.model;

public class Aluno extends Pessoa {
    private String numeroMatricula;
    private String cursoMatriculado;
    private boolean statusAtivo;

    // Construtor
    public Aluno(String nomeCompleto, String dataNascimento, String numeroMatricula, String cursoMatriculado, boolean statusAtivo) {
        super(nomeCompleto, dataNascimento);
        this.numeroMatricula = numeroMatricula;
        this.cursoMatriculado = cursoMatriculado;
        this.statusAtivo = statusAtivo;
    }

    // Getters e Setters
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    public boolean isStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    // Implementação do método abstrato
    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno: " + getNomeCompleto());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Número de Matrícula: " + numeroMatricula);
        System.out.println("Curso Matriculado: " + cursoMatriculado);
        System.out.println("Status: " + (statusAtivo ? "Ativo" : "Inativo"));
    }
}
