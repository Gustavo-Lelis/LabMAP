package br.com.gus.Controle;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gus.entidades.Aluno;
import br.com.gus.entidades.Disciplina;
import br.com.gus.entidades.Horario;
import br.com.gus.entidades.Professor;
import br.com.gus.entidades.Turma;

public class ControleAcademico {

    public void controleAcadem() {


        Professor p1 = new Professor("1", "Sabrina", "GT7U97");
        Professor p2 = new Professor("2", "Isabella", "GT7U96");


        Aluno a1 = new Aluno("1", "João", "GT7U99");
        Aluno a2 = new Aluno("2", "George", "GT7U98");
        Aluno a3 = new Aluno("3", "Davi", "GT7U96");
        Aluno a4 = new Aluno("4", "Gustavo", "GT7U94");
        Aluno a5 = new Aluno("5", "Victor", "GT7U97");
        Aluno a6 = new Aluno("6", "Arthur", "GT7U88");
        Aluno a7 = new Aluno("7", "Marcio", "GT7U91");
        Aluno a8 = new Aluno("8", "Valerio", "GT7U92");
        Aluno a9 = new Aluno("9", "Marcelo", "GT7U93");
        Aluno a0 = new Aluno("0", "Raiff", "GT7U90");


        Horario h1 = new Horario("Segunda-feira", LocalTime.of(9, 0), LocalTime.of(11, 0));
        Horario h2 = new Horario("Terça-feira", LocalTime.of(14, 0), LocalTime.of(16, 0));
        Horario h3 = new Horario("Quarta-feira", LocalTime.of(10, 0), LocalTime.of(12, 0));
        Horario h4 = new Horario("Quinta-feira", LocalTime.of(19, 0), LocalTime.of(21, 0));
        Horario h5 = new Horario("Sexta-feira", LocalTime.of(8, 0), LocalTime.of(10, 0));


        Disciplina d1 = new Disciplina("023087", "Map");
        Disciplina d2 = new Disciplina("024098", "Eletiva");
        Disciplina d3 = new Disciplina("023701", "Gerencia");
        Disciplina d4 = new Disciplina("034870", "APS");
        Disciplina d5 = new Disciplina("085632", "Engenharia de Software");

        List<Turma> turmas = new ArrayList<Turma>();
        Turma Map = new Turma(d1, p1, h1);
        Turma Eletiva = new Turma(d2, p1, h5);
        Turma Gerencia = new Turma(d3, p2, h4);
        Turma APS = new Turma(d4, p2, h3);
        Turma Engenharia = new Turma(d5, p2, h2);
    
        turmas.add(Eletiva);
        turmas.add(Map);
        turmas.add(Gerencia);
        turmas.add(APS);
        turmas.add(Engenharia);

        Map.addAluno(a1);
        Map.addAluno(a2);
        Map.addAluno(a3);
        Map.addAluno(a4);
        Map.addAluno(a5);
        Map.addAluno(a6);
        Map.addAluno(a7);
        Map.addAluno(a8);
        Map.addAluno(a9);
        Map.addAluno(a0);

        Eletiva.addAluno(a1);
        Eletiva.addAluno(a2);
        Eletiva.addAluno(a3);
        Eletiva.addAluno(a4);
        Eletiva.addAluno(a5);

        APS.addAluno(a4);
        APS.addAluno(a5);
        APS.addAluno(a6);
        APS.addAluno(a7);
        APS.addAluno(a8);

        Gerencia.addAluno(a7);
        Gerencia.addAluno(a8);
        Gerencia.addAluno(a9);
        Gerencia.addAluno(a0);

        Engenharia.addAluno(a1);
        Engenharia.addAluno(a2);
        Engenharia.addAluno(a3);
        Engenharia.addAluno(a4);
        Engenharia.addAluno(a8);
        Engenharia.addAluno(a9);
        Engenharia.addAluno(a0);

        System.out.println("Disciplinas da professora " + p1.getNome() + ":");
        listarTurmasProfessor(turmas, p1);

        System.out.println("\nDisciplinas da professora " + p2.getNome() + ":");
        listarTurmasProfessor(turmas, p2);

        System.out.println("\nDisciplinas do aluno " + a1.getNome() + ":");
        listarTurmasAluno(turmas, a1);
        System.out.println("\nDisciplinas do aluno " + a0.getNome() + ":");
        listarTurmasAluno(turmas, a0);

        System.out.println("\nAlunos matriculados em " + Map.getDisciplina() + ":");
        System.out.println(Map.numeroAlunos());
        
    }

     
    private static void listarTurmasProfessor(List<Turma> turmas, Professor professor) {
        for (Turma turma : turmas) {
            if(turma.getProfessor().equals(professor)){
                System.out.println(turma.getDisciplina().getNome() + " - " + turma.getHorario());
            }
        }
        
    }

    private static void listarTurmasAluno(List<Turma> turmas, Aluno aluno) {
        for (Turma turma : turmas) {
            if(turma.getAlunos().contains(aluno)){
                System.out.println(turma.getDisciplina().getNome() + " - " + turma.getHorario());
            }
        }
        
    }
    
}
