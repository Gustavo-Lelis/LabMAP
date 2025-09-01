package br.com.gus.controle;

import java.util.List;
import br.com.gus.entidades.*;
import br.com.gus.service.SistemaAcademico;

public class ControleAcademico {

    public void executarSimulacao() {

        SistemaAcademico sistema = new SistemaAcademico();

        Professor p1 = sistema.criarProfessor("1", "Sabrina", "GT7U97");
        Professor p2 = sistema.criarProfessor("2", "Isabella", "GT7U96");

        Aluno[] alunos = {
            sistema.criarAluno("1", "João", "GT7U99"),
            sistema.criarAluno("2", "George", "GT7U98"),
            sistema.criarAluno("3", "Davi", "GT7U96"),
            sistema.criarAluno("4", "Gustavo", "GT7U94"),
            sistema.criarAluno("5", "Victor", "GT7U97"),
            sistema.criarAluno("6", "Arthur", "GT7U88"),
            sistema.criarAluno("7", "Marcio", "GT7U91"),
            sistema.criarAluno("8", "Valerio", "GT7U92"),
            sistema.criarAluno("9", "Marcelo", "GT7U93"),
            sistema.criarAluno("0", "Raiff", "GT7U90")
        };

        Horario h1 = sistema.criarHorario("Segunda-feira", 9, 0, 11, 0);
        Horario h2 = sistema.criarHorario("Terça-feira", 14, 0, 16, 0);
        Horario h3 = sistema.criarHorario("Quarta-feira", 10, 0, 12, 0);
        Horario h4 = sistema.criarHorario("Quinta-feira", 19, 0, 21, 0);
        Horario h5 = sistema.criarHorario("Sexta-feira", 8, 0, 10, 0);

        Disciplina d1 = sistema.criarDisciplina("023087", "Map");
        Disciplina d2 = sistema.criarDisciplina("024098", "Eletiva");
        Disciplina d3 = sistema.criarDisciplina("023701", "Gerencia");
        Disciplina d4 = sistema.criarDisciplina("034870", "APS");
        Disciplina d5 = sistema.criarDisciplina("085632", "Engenharia de Software");
       
        Turma t1 = sistema.criarTurma(d1, p1, h1);
        Turma t2 = sistema.criarTurma(d2, p1, h5);
        Turma t3 = sistema.criarTurma(d3, p2, h4);
        Turma t4 = sistema.criarTurma(d4, p2, h3);
        Turma t5 = sistema.criarTurma(d5, p2, h2);

        sistema.matricularAluno(t1, alunos[0]); 
        sistema.matricularAluno(t1, alunos[4]); 
        sistema.matricularAluno(t1, alunos[9]); 
        sistema.matricularAluno(t2, alunos[1]); 
        sistema.matricularAluno(t3, alunos[2]); 
        sistema.matricularAluno(t4, alunos[3]); 
        sistema.matricularAluno(t5, alunos[5]); 

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
