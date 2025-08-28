package br.com.gus.relacionamento;

import br.com.gus.entidades.Professor;
import br.com.gus.entidades.Disciplina;


public class ProfessorDisciplina {

    private Professor professor;
    private Disciplina disciplina;

    
    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }


    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }  
}
