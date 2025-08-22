package br.com.gus;

import br.com.gus.model.Aluno;
import br.com.gus.model.Disciplina;
import br.com.gus.model.Horario;
import br.com.gus.model.Professor;

import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Professor p1 = new Professor("1", "Sabrina", "GT7U97");
        Professor p2 = new Professor("2", "Isabella", "GT7U96");


        Aluno a1 = new Aluno("1", "João", "GT7U99");
        Aluno a2 = new Aluno("2", "George", "GT7U98");


        Horario h1 = new Horario("Segunda-feira", LocalTime.of(9, 0), LocalTime.of(11, 0));
        Horario h2 = new Horario("Terça-feira", LocalTime.of(14, 0), LocalTime.of(16, 0));
        Horario h3 = new Horario("Quarta-feira", LocalTime.of(10, 0), LocalTime.of(12, 0));
        Horario h4 = new Horario("Quinta-feira", LocalTime.of(19, 0), LocalTime.of(21, 0));
        Horario h5 = new Horario("Sexta-feira", LocalTime.of(8, 0), LocalTime.of(10, 0));


        Disciplina d1 = new Disciplina(1, "Map", p1, h1);
        Disciplina d2 = new Disciplina(2, "Eletiva", p1, h2);
        Disciplina d3 = new Disciplina(3, "Gerencia", p1, h3);
        Disciplina d4 = new Disciplina(4, "APS", p2, h4);
        Disciplina d5 = new Disciplina(5, "Engenharia de Software", p2, h5);


        System.out.println("Disciplinas da professora " + p1.getNome() + ":");
        listarDisciplinas(p1.getDisciplinas());

        System.out.println("\nDisciplinas da professora " + p2.getNome() + ":");
        listarDisciplinas(p2.getDisciplinas());


        a1.adicionarDisciplina(d1);
        a1.adicionarDisciplina(d2);
        a1.adicionarDisciplina(d4);

        a2.adicionarDisciplina(d1);
        a2.adicionarDisciplina(d5);

        d1.addAluno(a1);
        d1.addAluno(a2);


        System.out.println("\nDisciplinas do aluno " + a1.getNome() + ":");
        listarDisciplinas(a1.getDisciplinas());

        System.out.println("\nDisciplinas do aluno " + a2.getNome() + ":");
        listarDisciplinas(a2.getDisciplinas());


        System.out.println("\nAlunos matriculados em " + d1.getNome() + ":");
        d1.listarAlunos();
        System.out.println("Número de alunos: " + d1.numeroDeAlunos());
    }


    private static void listarDisciplinas(List<Disciplina> disciplinas) {
        for (Disciplina d : disciplinas) {
            System.out.println(" - " + d.getNome() + " (" + d.getHorario() + ")");
        }
    }
}

