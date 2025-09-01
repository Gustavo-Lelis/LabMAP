package br.com.gus.relacionamento;

import br.com.gus.entidades.Professor;
import br.com.gus.entidades.Turma;

public class ProfessorLeciona {

    private Professor professor;
    private Turma turma;
    
    public ProfessorLeciona(Professor professor, Turma turma) {
        if (professor == null || turma == null) {
            throw new IllegalArgumentException("Professor e Turma não podem ser nulos");
        }

        this.professor = professor;
        this.turma = turma;
    }


    public Professor getProfessor() {
        return professor;
    }

    public Turma getTurma() {
        return turma;
    }  

    @Override
    public String toString() {
     return "ProfessorDisciplina{" +
            "professor=" + professor +
            ", turma=" + turma +
            '}';
    }

}
