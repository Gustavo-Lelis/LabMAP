package br.com.gus.relacionamento;

import br.com.gus.entidades.Aluno;
import br.com.gus.entidades.Turma;


public class AlunoCursa {

    private Aluno aluno;
    private Turma turma;

    public AlunoCursa(Aluno aluno, Turma turma) {
        if (aluno == null || turma == null) {
            throw new IllegalArgumentException("Aluno e Turma não podem ser nulos");
        }

        this.aluno = aluno;
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }  
}
