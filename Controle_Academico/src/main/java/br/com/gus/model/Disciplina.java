package br.com.gus.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private Professor professor;
    private List<Aluno> alunos;
    private Horario horario;


    public Disciplina(int id, String nome, Professor professor, Horario horario) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        professor.adicionarDisciplina(this);
        this.alunos = new ArrayList<>();
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Horario getHorario() {
        return horario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public int numeroDeAlunos() {
        return alunos.size();
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
    public void listarAlunos(){
        for(Aluno aluno : alunos){
            System.out.println(aluno.getNome());
        }
    }



}
