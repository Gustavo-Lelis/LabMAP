package br.com.gus.entidades;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;
    private List<Aluno> matriculados;

    public Turma (Disciplina disciplina, Professor professor, Horario horario){
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario = horario;
        matriculados = new ArrayList<Aluno>();
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
        return matriculados;
    }

    public void matricularAluno(Aluno aluno) {
        if (aluno != null && !matriculados.contains(aluno)) {
            matriculados.add(aluno);
        }
    }
    public int numeroAlunos(){
        return matriculados.size();
    }
}
