package model;

import br.com.gus.model.Aluno;
import br.com.gus.model.Disciplina;
import br.com.gus.model.Horario;
import br.com.gus.model.Professor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

public class HorarioTest {
    private Aluno aluno;
    private Disciplina disciplina;
    private Horario horario;
    private Professor professor;

    @BeforeEach
    void setUp() {
        // Executado ANTES de cada teste
        aluno = new Aluno("1", "Gustavo", "2025001");
        professor = new Professor ("1", "Sabrina", "sabrina@gmail.com");
        horario = new Horario("Quarta-Feira", LocalTime.of(9, 0), LocalTime.of(11, 0));
        disciplina = new Disciplina(1, "POO", professor,horario) ;
    }

    @AfterEach
    void tearDown() {
        // Executado DEPOIS de cada teste
        aluno = null;
        disciplina = null;
    }
    
    @Test
    void testHorarioAluno() {
    	String esperado = "Quarta-Feira 09:00 - 11:00";
    	assertEquals(esperado, horario);
    }
}
