package dev.model;

public abstract class Pessoa {
    private String nomeCompleto;
    private String dataNascimento;

    // Construtor
    public Pessoa(String nomeCompleto, String dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }
    // Construtor vazio deixa os atributos nulo na instancia
    public Pessoa() {

    }

    // Getters e Setters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método abstrato para exibir informações (deve ser implementado pelas classes filhas)
    public abstract void exibirInformacoes();
}
