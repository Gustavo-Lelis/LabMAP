package model;

import br.com.gus.model.Aluno;
import br.com.gus.model.Disciplina;
import br.com.gus.model.Professor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;
    private Disciplina disciplina;
    private Professor professor;

    @BeforeEach
    void setUp() {
        // Executado ANTES de cada teste
        aluno = new Aluno("1", "Gustavo", "2025001");
        professor = new Professor ("1", "Sabrina", "sabrina@gmail.com");
        disciplina = new Disciplina(1, "POO", professor, null);
    }

    @AfterEach
    void tearDown() {
        // Executado DEPOIS de cada teste
        aluno = null;
        disciplina = null;
    }

    @Test
    void testCriacaoAluno() {
        assertEquals("Gustavo", aluno.getNome());
        assertEquals("2025001", aluno.getMatricula());
        assertTrue(aluno.getDisciplinas().isEmpty());
    }

    @Test
    void testAdicionarDisciplina() {
        aluno.adicionarDisciplina(disciplina);
        assertEquals(1, aluno.getDisciplinas().size());
        assertEquals("POO", aluno.getDisciplinas().getFirst().getNome());
    }

    @Test
    void testToString() {
        String texto = aluno.toString();
        assertTrue(texto.contains("Gustavo"));
        assertTrue(texto.contains("2025001"));
    }
}
