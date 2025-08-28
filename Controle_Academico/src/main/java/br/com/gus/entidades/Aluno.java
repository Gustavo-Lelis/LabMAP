package br.com.gus.entidades;

public class Aluno extends User{
    private String matricula;


    public Aluno(String id, String nome, String matricula) {
        super(id, nome);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return "Aluno{" + "Nome: " + getNome() + "matricula: " + matricula + '}';
    }
}
