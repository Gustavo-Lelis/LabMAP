package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gus.entidades.Professor;

public class ProfessorTest {
	
	
    private Professor professor;

    @BeforeEach
    void setUp() {
        // Executado ANTES de cada teste
        professor = new Professor ("1", "Sabrina", "sabrina@gmail.com");
    }

    @AfterEach
    void tearDown() {
        // Executado DEPOIS de cada teste
        professor = null;
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

}
