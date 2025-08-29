package br.com.gus.entidades;

public class Professor extends User {
    private String email;
    
    public Professor(String id, String nome, String email) {
        super(id, nome);
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
