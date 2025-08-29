package relacionamento;

import br.com.gus.relacionamento.ProfessorDisciplina;

import br.com.gus.entidades.Professor;
import br.com.gus.entidades.Turma;
import br.com.gus.entidades.Disciplina;
import br.com.gus.entidades.Horario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

class ProfessorDisciplinaTest {

    private Professor professor;
    private Turma turma;
    private Disciplina disciplina;
    private Horario horario;

    @BeforeEach
    void setUp() {
        // Preparando os objetos necessários
        disciplina = new Disciplina("MAT101", "Matemática");
        professor = new Professor("P123", "João Silva", "joao@gmail.com");
        horario = new Horario("Segunda-feira", LocalTime.of(8, 0), LocalTime.of(10, 0));
        turma = new Turma(disciplina, professor, horario);
    }

    @Test
    void testConstrutorComParametrosValidos() {
        // Testa o construtor com parâmetros válidos
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        
        assertNotNull(professorDisciplina);
        assertEquals(professor, professorDisciplina.getProfessor());
        assertEquals(turma, professorDisciplina.getTurma());
    }

    @Test
    void testConstrutorComProfessorNulo() {
        // Testa que exceção é lançada quando professor é nulo
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new ProfessorDisciplina(null, turma)
        );
        
        assertEquals("Professor e Turma não podem ser nulos", exception.getMessage());
    }

    @Test
    void testConstrutorComTurmaNula() {
        // Testa que exceção é lançada quando turma é nula
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new ProfessorDisciplina(professor, null)
        );
        
        assertEquals("Professor e Turma não podem ser nulos", exception.getMessage());
    }

    @Test
    void testConstrutorComAmbosNulos() {
        // Testa que exceção é lançada quando ambos são nulos
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new ProfessorDisciplina(null, null)
        );
        
        assertEquals("Professor e Turma não podem ser nulos", exception.getMessage());
    }

    @Test
    void testGetProfessor() {
        // Testa o método getProfessor
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        
        assertEquals(professor, professorDisciplina.getProfessor());
        assertEquals("João Silva", professorDisciplina.getProfessor().getNome());
        assertEquals("P123", professorDisciplina.getProfessor().getCodigo());
        assertEquals("joao@gmail.com", professorDisciplina.getProfessor().getEmail());
    }

    @Test
    void testGetTurma() {
        // Testa o método getTurma
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        
        assertEquals(turma, professorDisciplina.getTurma());
        assertEquals(disciplina, professorDisciplina.getTurma().getDisciplina());
        assertEquals(professor, professorDisciplina.getTurma().getProfessor());
        assertEquals(horario, professorDisciplina.getTurma().getHorario());
    }

    @Test
    void testToString() {
        // Testa o método toString
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        String resultadoToString = professorDisciplina.toString();
        
        assertNotNull(resultadoToString);
        assertTrue(resultadoToString.contains("ProfessorDisciplina"));
        assertTrue(resultadoToString.contains("professor="));
        assertTrue(resultadoToString.contains("turma="));
        assertTrue(resultadoToString.contains("João Silva"));
        assertTrue(resultadoToString.contains("MAT101"));
    }

    @Test
    void testIntegracaoComObjetosReais() {
        // Testa a integração com objetos reais e seus métodos
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        
        // Verifica os dados do professor
        assertEquals("João Silva", professorDisciplina.getProfessor().getNome());
        assertEquals("P123", professorDisciplina.getProfessor().getCodigo());
        assertEquals("joao@gmail.com", professorDisciplina.getProfessor().getEmail());
        
        // Verifica os dados da turma
        assertEquals("MAT101", professorDisciplina.getTurma().getDisciplina().getId());
        assertEquals("Matemática", professorDisciplina.getTurma().getDisciplina().getNome());
        assertEquals(LocalTime.of(8, 0), professorDisciplina.getTurma().getHorario().getHoraInicio());
    }

    @Test
    void testMultiplasInstanciasComDiferentesProfessores() {
        // Testa criar múltiplas instâncias com professores diferentes
        Professor professor2 = new Professor("P456", "Maria Santos", "Mestre");
        Turma turma2 = new Turma(disciplina, professor2, horario);
        
        ProfessorDisciplina relacao1 = new ProfessorDisciplina(professor, turma);
        ProfessorDisciplina relacao2 = new ProfessorDisciplina(professor2, turma2);
        
        assertEquals("João Silva", relacao1.getProfessor().getNome());
        assertEquals("Maria Santos", relacao2.getProfessor().getNome());
        assertEquals("P123", relacao1.getProfessor().getCodigo());
        assertEquals("P456", relacao2.getProfessor().getCodigo());
    }


    @Test
    void testImutabilidadeDosObjetos() {
        // Testa que os objetos internos não são modificados após a criação
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        
        // Os objetos retornados devem ser os mesmos que foram passados no construtor
        assertSame(professor, professorDisciplina.getProfessor());
        assertSame(turma, professorDisciplina.getTurma());
    }

    @Test
    void testConsistenciaDosDados() {
        // Testa a consistência dos dados após a criação
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, turma);
        
        // Verifica se todos os dados estão consistentes
        assertEquals(professor.getNome(), professorDisciplina.getProfessor().getNome());
        assertEquals(turma.getDisciplina().getNome(), professorDisciplina.getTurma().getDisciplina().getNome());
        assertEquals(turma.getHorario().getHoraInicio(), professorDisciplina.getTurma().getHorario().getHoraInicio());
    }
}
