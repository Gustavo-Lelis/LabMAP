package br.com.gus.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends User{
    private String matricula;
    private List<Disciplina> disciplinas = new ArrayList<>();


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

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }


    public String toString() {
        return "Aluno{" + "Nome: " + getNome() + "matricula: " + matricula + '}';
    }
}
