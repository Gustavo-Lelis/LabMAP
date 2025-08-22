package br.com.gus.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
    private String email;
    private List<Disciplina> disciplinas = new ArrayList<>();


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

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }


}
