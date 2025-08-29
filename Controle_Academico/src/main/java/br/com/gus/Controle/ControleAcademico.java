package br.com.gus.controle;

import java.time.LocalTime;
import java.util.List;

import br.com.gus.entidades.*;
import br.com.gus.service.SistemaAcademico;

public class ControleAcademico {

    public void executarSimulacao() {

        SistemaAcademico sistema = new SistemaAcademico();

        // Professores
        Professor p1 = new Professor("1", "Sabrina", "GT7U97");
        Professor p2 = new Professor("2", "Isabella", "GT7U96");

        // Alunos
        Aluno[] alunos = {
            new Aluno("1", "João", "GT7U99"),
            new Aluno("2", "George", "GT7U98"),
            new Aluno("3", "Davi", "GT7U96"),
            new Aluno("4", "Gustavo", "GT7U94"),
            new Aluno("5", "Victor", "GT7U97"),
            new Aluno("6", "Arthur", "GT7U88"),
            new Aluno("7", "Marcio", "GT7U91"),
            new Aluno("8", "Valerio", "GT7U92"),
            new Aluno("9", "Marcelo", "GT7U93"),
            new Aluno("0", "Raiff", "GT7U90")
        };

        // Horários
        Horario h1 = new Horario("Segunda-feira", LocalTime.of(9, 0), LocalTime.of(11, 0));
        Horario h2 = new Horario("Terça-feira", LocalTime.of(14, 0), LocalTime.of(16, 0));
        Horario h3 = new Horario("Quarta-feira", LocalTime.of(10, 0), LocalTime.of(12, 0));
        Horario h4 = new Horario("Quinta-feira", LocalTime.of(19, 0), LocalTime.of(21, 0));
        Horario h5 = new Horario("Sexta-feira", LocalTime.of(8, 0), LocalTime.of(10, 0));

        // Disciplinas
        Disciplina d1 = new Disciplina("023087", "Map");
        Disciplina d2 = new Disciplina("024098", "Eletiva");
        Disciplina d3 = new Disciplina("023701", "Gerencia");
        Disciplina d4 = new Disciplina("034870", "APS");
        Disciplina d5 = new Disciplina("085632", "Engenharia de Software");

        // Turmas
        Turma t1 = sistema.criarTurma(d1, p1, h1);
        Turma t2 = sistema.criarTurma(d2, p1, h5);
        Turma t3 = sistema.criarTurma(d3, p2, h4);
        Turma t4 = sistema.criarTurma(d4, p2, h3);
        Turma t5 = sistema.criarTurma(d5, p2, h2);

        // Matrículas
        sistema.matricularAluno(t1, alunos[0]); // João
        sistema.matricularAluno(t1, alunos[4]); // Victor
        sistema.matricularAluno(t1, alunos[9]); // Raiff
        sistema.matricularAluno(t2, alunos[1]); // George
        sistema.matricularAluno(t3, alunos[2]); // Davi
        sistema.matricularAluno(t4, alunos[3]); // Gustavo
        sistema.matricularAluno(t5, alunos[5]); // Arthur

        System.out.println("Disciplinas da professora " + p1.getNome() + ":");
        exibirTurmas(sistema.buscarTurmasDoProfessor(p1));

        System.out.println("\nDisciplinas da professora " + p2.getNome() + ":");
        exibirTurmas(sistema.buscarTurmasDoProfessor(p2));

        System.out.println("\nDisciplinas do aluno " + alunos[0].getNome() + ":");
        exibirTurmas(sistema.buscarTurmasDoAluno(alunos[0]));

        System.out.println("\nDisciplinas do aluno " + alunos[9].getNome() + ":");
        exibirTurmas(sistema.buscarTurmasDoAluno(alunos[9]));

        System.out.println("\nAlunos matriculados em " + t1.getDisciplina().getNome() + ":");
        exibirAlunos(sistema.buscarAlunosDaTurma(t1));
        System.out.println("Total: " + t1.numeroAlunos());
    }

    private void exibirTurmas(List<Turma> turmas) {
        for (Turma turma : turmas) {
            System.out.println(turma.getDisciplina().getNome() + " - " + turma.getHorario());
        }
    }

    private void exibirAlunos(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome());
        }
    }


}