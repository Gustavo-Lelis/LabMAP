package br.com.gus.entidades;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;
    private List<Aluno> alunos;

    public Turma (Disciplina disciplina, Professor professor, Horario horario){
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario = horario;
        alunos = new ArrayList<Aluno>();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Horario getHorario() {
        return horario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

   public void addAluno(Aluno aluno) {
    if (alunos.contains(aluno)) {
        throw new IllegalArgumentException("Aluno já está na turma");
    }
    alunos.add(aluno);
}


    public List<Aluno> listaAlunos(){
        return alunos; 
    }

    public int numeroAlunos(){
        return alunos.size();
    }
}
