package br.com.gus.service;

import br.com.gus.entidades.Turma;
import br.com.gus.entidades.Professor;
import br.com.gus.entidades.Disciplina;
import br.com.gus.entidades.Horario;
import br.com.gus.entidades.Aluno;
import br.com.gus.relacionamento.*;
import java.util.*;


public class SistemaAcademico {
    private List<Turma> turmas = new ArrayList<>();
    private List<AlunoDisciplina> alunoDisciplinas = new ArrayList<>();
    private List<ProfessorDisciplina> professorDisciplinas = new ArrayList<>();

    public Turma criarTurma(Disciplina disciplina, Professor professor, Horario horario) {
        Turma turma = new Turma(disciplina, professor, horario);
        turmas.add(turma);
        professorDisciplinas.add(new ProfessorDisciplina(professor, turma));
        return turma;
    }

    public void matricularAluno(Turma turma, Aluno aluno) {
        boolean jaMatriculado = false;
        for (AlunoDisciplina rel : alunoDisciplinas) {
            if (rel.getAluno().equals(aluno) && rel.getTurma().equals(turma)) {
                jaMatriculado = true;
                break;
            }
        }

        if (!jaMatriculado) {
            turma.getAlunos().add(aluno);
            alunoDisciplinas.add(new AlunoDisciplina(aluno, turma));
        }
    }

    public List<Turma> buscarTurmasDoAluno(Aluno aluno) {
        List<Turma> resultado = new ArrayList<>();
        for (AlunoDisciplina rel : alunoDisciplinas) {
            if (rel.getAluno().equals(aluno)) {
                resultado.add(rel.getTurma());
            }
        }
        return resultado;
    }

    public List<Turma> buscarTurmasDoProfessor(Professor professor) {
        List<Turma> resultado = new ArrayList<>();
        for (ProfessorDisciplina rel : professorDisciplinas) {
            if (rel.getProfessor().equals(professor)) {
                resultado.add(rel.getTurma());
            }
        }
        return resultado;
    }

    public List<Aluno> buscarAlunosDaTurma(Turma turma) {
        List<Aluno> resultado = new ArrayList<>();
        for (AlunoDisciplina rel : alunoDisciplinas) {
            if (rel.getTurma().equals(turma)) {
                resultado.add(rel.getAluno());
            }
        }
        return resultado;
    }

    public List<Turma> listarTodasTurmas() {
        return new ArrayList<>(turmas);
    }

}
