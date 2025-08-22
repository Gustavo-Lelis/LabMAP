package br.com.gus.model;

public class User {
    private String id;
    private String nome;


    public User(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getCodigo() {
        return id;
    }

    public void setCodigo(String codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
