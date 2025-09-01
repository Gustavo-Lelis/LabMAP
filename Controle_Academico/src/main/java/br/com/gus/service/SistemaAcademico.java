package br.com.gus.service;

import br.com.gus.entidades.*;
import br.com.gus.relacionamento.*;
import java.time.LocalTime;
import java.util.*;


public class SistemaAcademico {
    private List<Turma> turmas = new ArrayList<>();
    private List<AlunoCursa> alunoCursa = new ArrayList<>();
    private List<ProfessorLeciona> professorLeciona = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    public Professor criarProfessor(String id, String nome, String matricula) {
        Professor professor = new Professor(id, nome, matricula);
        professores.add(professor);
        return professor;
    }

    public Aluno criarAluno(String id, String nome, String matricula) {
        Aluno aluno = new Aluno(id, nome, matricula);
        alunos.add(aluno);
        return aluno;
    }

    public Disciplina criarDisciplina(String codigo, String nome) {
        Disciplina disciplina = new Disciplina(codigo, nome);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public Horario criarHorario(String dia, int horaInicio, int minutoInicio, int horaFim, int minutoFim) {
        Horario horario = new Horario(dia, LocalTime.of(horaInicio, minutoInicio), LocalTime.of(horaFim, minutoFim));
        horarios.add(horario);
        return horario;
    }

    public Turma criarTurma(Disciplina disciplina, Professor professor, Horario horario) {
        Turma turma = new Turma(disciplina, professor, horario);
        turmas.add(turma);
        professorLeciona.add(new ProfessorLeciona(professor, turma));
        return turma;
    }


    public void matricularAluno(Turma turma, Aluno aluno) {
        boolean jaMatriculado = false;
        for (AlunoCursa rel : alunoCursa) {
            if (rel.getAluno().equals(aluno) && rel.getTurma().equals(turma)) {
                jaMatriculado = true;
                break;
            }
        }

        if (!jaMatriculado) {
            turma.getAlunos().add(aluno);
            alunoCursa.add(new AlunoCursa(aluno, turma));
        }
    }

    public List<Turma> buscarTurmasDoAluno(Aluno aluno) {
        List<Turma> resultado = new ArrayList<>();
        for (AlunoCursa rel : alunoCursa) {
            if (rel.getAluno().equals(aluno)) {
                resultado.add(rel.getTurma());
            }
        }
        return resultado;
    }

    public List<Turma> buscarTurmasDoProfessor(Professor professor) {
        List<Turma> resultado = new ArrayList<>();
        for (ProfessorLeciona rel : professorLeciona) {
            if (rel.getProfessor().equals(professor)) {
                resultado.add(rel.getTurma());
            }
        }
        return resultado;
    }

    public List<Aluno> buscarAlunosDaTurma(Turma turma) {
        List<Aluno> resultado = new ArrayList<>();
        for (AlunoCursa rel : alunoCursa) {
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
