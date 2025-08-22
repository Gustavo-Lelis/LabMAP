package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gus.model.Disciplina;
import br.com.gus.model.Professor;

public class ProfessorTest {
	
	private Disciplina disciplina;
    private Professor professor;

    @BeforeEach
    void setUp() {
        // Executado ANTES de cada teste
        professor = new Professor ("1", "Sabrina", "sabrina@gmail.com");
        disciplina = new Disciplina(1, "POO", professor, null);
    }

    @AfterEach
    void tearDown() {
        // Executado DEPOIS de cada teste
        professor = null;
        disciplina = null;
    }
    
    @Test
    void testGetEmail() {
        assertEquals("sabrina@gmail.com", professor.getEmail());
    }

    @Test
    void testSetEmail() {
        professor.setEmail("novoemail@teste.com");
        assertEquals("novoemail@teste.com", professor.getEmail());
    }

    @Test
    void testAdicionarDisciplina() {
        professor.adicionarDisciplina(disciplina);
        assertTrue(professor.getDisciplinas().contains(disciplina));
        
    }

    @Test
    void testGetDisciplinasInicialmenteVazio() {
        assertFalse(professor.getDisciplinas().isEmpty());
    }

    @Test
    void testAdicionarMultiplasDisciplinas() {
        Disciplina outra = new Disciplina(102, "Banco de Dados", professor, null);
        

        List<Disciplina> disciplinas = professor.getDisciplinas();
        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina));
        assertTrue(disciplinas.contains(outra));
    }

}
