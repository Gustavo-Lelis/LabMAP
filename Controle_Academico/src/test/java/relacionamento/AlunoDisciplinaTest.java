package relacionamento;

import br.com.gus.entidades.Aluno;
import br.com.gus.entidades.Turma;
import br.com.gus.entidades.Disciplina;
import br.com.gus.entidades.Professor;
import br.com.gus.entidades.Horario;

import br.com.gus.relacionamento.AlunoCursa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

class AlunoDisciplinaTest {

    private Aluno aluno;
    private Turma turma;
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;

    @BeforeEach
    void setUp() {
        // Preparando os objetos necessários
        disciplina = new Disciplina("MAT101", "Matemática");
        professor = new Professor("P123", "João Silva", "joao@gmail.com");
        horario = new Horario("Segunda-feira", LocalTime.of(8, 0), LocalTime.of(10, 0));
        turma = new Turma(disciplina, professor, horario);
        aluno = new Aluno("1", "Maria Santos", "A2023001");
    }

    @Test
    void testConstrutorComParametrosValidos() {
        // Testa o construtor com parâmetros válidos
        AlunoCursa alunoDisciplina = new AlunoCursa(aluno, turma);
        
        assertNotNull(alunoDisciplina);
        assertEquals(aluno, alunoDisciplina.getAluno());
        assertEquals(turma, alunoDisciplina.getTurma());
    }

    @Test
    void testConstrutorComAlunoNulo() {
        // Testa que exceção é lançada quando aluno é nulo
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new AlunoCursa(null, turma)
        );
        
        assertEquals("Aluno e Turma não podem ser nulos", exception.getMessage());
    }

    @Test
    void testConstrutorComTurmaNula() {
        // Testa que exceção é lançada quando turma é nula
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new AlunoCursa(aluno, null)
        );
        
        assertEquals("Aluno e Turma não podem ser nulos", exception.getMessage());
    }

    @Test
    void testConstrutorComAmbosNulos() {
        // Testa que exceção é lançada quando ambos são nulos
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new AlunoCursa(null, null)
        );
        
        assertEquals("Aluno e Turma não podem ser nulos", exception.getMessage());
    }

    @Test
    void testGetAluno() {
        // Testa o método getAluno
        AlunoCursa alunoDisciplina = new AlunoCursa(aluno, turma);
        
        assertEquals(aluno, alunoDisciplina.getAluno());
        assertEquals("Maria Santos", alunoDisciplina.getAluno().getNome());
        assertEquals("A2023001", alunoDisciplina.getAluno().getMatricula());
    }

    @Test
    void testGetTurma() {
        // Testa o método getTurma
        AlunoCursa alunoDisciplina = new AlunoCursa(aluno, turma);
        
        assertEquals(turma, alunoDisciplina.getTurma());
        assertEquals(disciplina, alunoDisciplina.getTurma().getDisciplina());
        assertEquals(professor, alunoDisciplina.getTurma().getProfessor());
        assertEquals(horario, alunoDisciplina.getTurma().getHorario());
    }

    @Test
    void testIntegracaoComObjetosReais() {
        // Testa a integração com objetos reais e seus métodos
        AlunoCursa alunoDisciplina = new AlunoCursa(aluno, turma);
        
        // Verifica os dados do aluno
        assertEquals("Maria Santos", alunoDisciplina.getAluno().getNome());
        assertEquals("A2023001", alunoDisciplina.getAluno().getMatricula());
        
        // Verifica os dados da turma
        assertEquals("MAT101", alunoDisciplina.getTurma().getDisciplina().getId());
        assertEquals("Matemática", alunoDisciplina.getTurma().getDisciplina().getNome());
        assertEquals("João Silva", alunoDisciplina.getTurma().getProfessor().getNome());
        assertEquals(LocalTime.of(8, 0), alunoDisciplina.getTurma().getHorario().getHoraInicio());
    }

    @Test
    void testMultiplasInstanciasComDiferentesAlunos() {
        // Testa criar múltiplas instâncias com alunos diferentes
        Aluno aluno2 = new Aluno("2","Pedro Oliveira", "A2023002");
        
        AlunoCursa relacao1 = new AlunoCursa(aluno, turma);
        AlunoCursa relacao2 = new AlunoCursa(aluno2, turma);
        
        assertEquals("Maria Santos", relacao1.getAluno().getNome());
        assertEquals("Pedro Oliveira", relacao2.getAluno().getNome());
        // Ambas referenciam a mesma turma
        assertEquals(turma, relacao1.getTurma());
        assertEquals(turma, relacao2.getTurma());
    }

    @Test
    void testMultiplasInstanciasComDiferentesTurmas() {
        // Testa criar múltiplas instâncias com turmas diferentes
        Disciplina disciplina2 = new Disciplina("FIS101", "Física");
        Professor professor2 = new Professor("P456", "Carlos Souza", "carlos@gmail.com");
        Horario horario2 = new Horario("Terça-feira", LocalTime.of(14, 0), LocalTime.of(16, 0));
        Turma turma2 = new Turma(disciplina2, professor2, horario2);
        
        AlunoCursa relacao1 = new AlunoCursa(aluno, turma);
        AlunoCursa relacao2 = new AlunoCursa(aluno, turma2);
        
        // Mesmo aluno em turmas diferentes
        assertEquals(aluno, relacao1.getAluno());
        assertEquals(aluno, relacao2.getAluno());
        
        // Turmas diferentes
        assertEquals("Matemática", relacao1.getTurma().getDisciplina().getNome());
        assertEquals("Física", relacao2.getTurma().getDisciplina().getNome());
    }

    @Test
    void testImutabilidadeDosObjetos() {
        // Testa que os objetos internos não são modificados após a criação
        AlunoCursa alunoDisciplina = new AlunoCursa(aluno, turma);
        
        // Os objetos retornados devem ser os mesmos que foram passados no construtor
        assertSame(aluno, alunoDisciplina.getAluno());
        assertSame(turma, alunoDisciplina.getTurma());
    }
}
