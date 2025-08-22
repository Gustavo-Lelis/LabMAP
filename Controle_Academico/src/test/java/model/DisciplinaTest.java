package model;

import static org.junit.jupiter.api.Assertions.*;

import br.com.gus.model.Aluno;
import br.com.gus.model.Disciplina;
import br.com.gus.model.Professor;
import org.junit.jupiter.api.*;

import java.util.List;

class DisciplinaTest {

    private Disciplina disciplina;
    private Professor professor;
    private Aluno aluno1;
    private Aluno aluno2;

    @BeforeEach
    void setUp() {
        professor = new Professor("1","João da Silva", "joao@teste.com");
        disciplina = new Disciplina(1,"Estruturas de Dados", professor, null);

        aluno1 = new Aluno("1","Maria", "2021001");
        aluno2 = new Aluno("2", "Carlos", "2021002");
    }

    @AfterEach
    void tearDown() {
        disciplina = null;
        professor = null;
        aluno1 = null;
        aluno2 = null;
    }

    @Test
    void testGetNome() {
        assertEquals("Estruturas de Dados", disciplina.getNome());
    }

    @Test
    void testGetCodigo() {
        assertEquals(1, disciplina.getId());
    }

    @Test
    void testGetProfessor() {
        assertEquals(professor, disciplina.getProfessor());
    }

    @Test
    void testAdicionarAluno() {
        disciplina.addAluno(aluno1);
        disciplina.addAluno(aluno2);

        List<Aluno> alunos = disciplina.getAlunos();

        assertTrue(alunos.contains(aluno1));
        assertTrue(alunos.contains(aluno2));
    }

    @Test
    void testNumeroDeAlunosNaDisciplina() {
        disciplina.addAluno(aluno1);
        disciplina.addAluno(aluno2);

        assertEquals(2, disciplina.getAlunos().size());
    }

}
