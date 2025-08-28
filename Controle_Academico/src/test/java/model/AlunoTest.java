package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gus.entidades.Aluno;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;


    @BeforeEach
    void setUp() {
        // Executado ANTES de cada teste
        aluno = new Aluno("1", "Gustavo", "2025001");
    }

    @AfterEach
    void tearDown() {
        // Executado DEPOIS de cada teste
        aluno = null;
    }

    @Test
    public void TestGetNome(){
        assertEquals("Gustavo", aluno.getNome());
    }
    @Test
    public void TestGetMatricula(){
        assertEquals("2025001", aluno.getMatricula());
    }
}
