package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import br.com.gus.entidades.Disciplina;

class DisciplinaTest {

    private Disciplina disciplina;
    

    @BeforeEach
    void setUp() {
       
        disciplina = new Disciplina("14931","Estruturas de Dados");

    }

    @AfterEach
    void tearDown() {
        disciplina = null;
    } 

    public void TestGetDisciplina(){
        assertEquals("Estruturas de Dados", disciplina.getNome());
        assertNotEquals("Estruturas de Dados", disciplina.getNome());
    }
    @Test
    public void TesteGetCodigoDisciplina(){
        assertEquals("14931", disciplina.getId());
        assertNotEquals("14930", disciplina.getId());
    }

}
