package br.com.gus.relacionamento;

import br.com.gus.entidades.Aluno;
import br.com.gus.entidades.Disciplina;


public class AlunoDisciplina {

    private Aluno aluno;
    private Disciplina disciplina;

    public AlunoDisciplina(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }  
}
