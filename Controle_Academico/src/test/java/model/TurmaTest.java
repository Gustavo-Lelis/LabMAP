package model;

import br.com.gus.entidades.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import java.time.LocalTime;

class TurmaTest {

    private Turma turma;
    private Disciplina disciplina;
    private Professor professor;
    private Horario horario;
    private Aluno aluno1;
    private Aluno aluno2;

    @BeforeEach
    void setUp() {
        // Criando instâncias reais das classes
        disciplina = new Disciplina("MAT101", "Matemática");
        professor = new Professor("12345", "João Silva", "joao@gmail.com");
        horario = new Horario("Segunda-feira", LocalTime.of(8, 0), LocalTime.of(10, 0));
        aluno1 = new Aluno("1", "Maria Santos", "2023001");
        aluno2 = new Aluno("2", "Pedro Oliveira", "2023002");
        
        turma = new Turma(disciplina, professor, horario);
    }

    @Test
    void testConstrutorComParametros() {
        // Verifica se o construtor inicializa corretamente os campos
        assertNotNull(turma);
        assertEquals(disciplina, turma.getDisciplina());
        assertEquals(professor, turma.getProfessor());
        assertEquals(horario, turma.getHorario());
        assertNotNull(turma.getAlunos());
        assertTrue(turma.getAlunos().isEmpty());
        assertEquals(0, turma.numeroAlunos());
    }

    @Test
    void testMatricularAlunoComAlunoValido() {
        // Testa matricular um aluno válido
        turma.matricularAluno(aluno1);
        
        assertEquals(1, turma.numeroAlunos());
        assertTrue(turma.getAlunos().contains(aluno1));
        assertEquals(aluno1, turma.getAlunos().get(0));
    }

    @Test
    void testMatricularAlunoDuplicado() {
        // Testa que não é possível matricular o mesmo aluno duas vezes
        turma.matricularAluno(aluno1);
        turma.matricularAluno(aluno1); // Tentativa de matrícula duplicada
        
        assertEquals(1, turma.numeroAlunos());
        assertEquals(1, turma.getAlunos().size());
    }

    @Test
    void testMatricularAlunoNulo() {
        // Testa que aluno nulo não é matriculado
        turma.matricularAluno(null);
        
        assertEquals(0, turma.numeroAlunos());
        assertTrue(turma.getAlunos().isEmpty());
    }

    @Test
    void testMatricularVariosAlunos() {
        // Testa matricular vários alunos diferentes
        turma.matricularAluno(aluno1);
        turma.matricularAluno(aluno2);
        
        assertEquals(2, turma.numeroAlunos());
        assertTrue(turma.getAlunos().contains(aluno1));
        assertTrue(turma.getAlunos().contains(aluno2));
        assertEquals(2, turma.getAlunos().size());
    }

    @Test
    void testNumeroAlunosComListaVazia() {
        // Testa o número de alunos quando a lista está vazia
        assertEquals(0, turma.numeroAlunos());
    }

    @Test
    void testNumeroAlunosComAlunosMatriculados() {
        // Testa o número de alunos após matrículas
        turma.matricularAluno(aluno1);
        assertEquals(1, turma.numeroAlunos());
        
        turma.matricularAluno(aluno2);
        assertEquals(2, turma.numeroAlunos());
    }

    @Test
    void testGetAlunosRetornaCopiaDefensiva() {
        // Testa que a lista retornada por getAlunos é uma cópia defensiva
        turma.matricularAluno(aluno1);
        
        List<Aluno> alunosExterna = turma.getAlunos();
        int tamanhoOriginal = alunosExterna.size();
        
        // A lista interna deve permanecer inalterada
        assertEquals(tamanhoOriginal, turma.numeroAlunos());
        assertEquals(1, turma.numeroAlunos());
    }

    @Test
    void testGetDisciplina() {
        assertEquals(disciplina, turma.getDisciplina());
        assertEquals("MAT101", turma.getDisciplina().getId());
        assertEquals("Matemática", turma.getDisciplina().getNome());
    }

    @Test
    void testGetProfessor() {
        assertEquals(professor, turma.getProfessor());
        assertEquals("João Silva", turma.getProfessor().getNome());
        assertEquals("12345", turma.getProfessor().getCodigo());
    }

    @Test
    void testGetHorario() {
        assertEquals(horario, turma.getHorario());
        assertEquals(LocalTime.of(8, 0), turma.getHorario().getHoraInicio());
        assertEquals(LocalTime.of(10, 0), turma.getHorario().getHoraFim());
    }

    @Test
    void testListaAlunosInicialmenteVazia() {
        assertTrue(turma.getAlunos().isEmpty());
        assertEquals(0, turma.getAlunos().size());
        assertEquals(0, turma.numeroAlunos());
    }

    @Test
    void testMatricularMultiplosAlunosEMostrarInformacoes() {
        // Teste mais complexo com múltiplas operações
        assertEquals(0, turma.numeroAlunos());
        
        turma.matricularAluno(aluno1);
        assertEquals(1, turma.numeroAlunos());
        assertEquals("Maria Santos", turma.getAlunos().get(0).getNome());
        
        turma.matricularAluno(aluno2);
        assertEquals(2, turma.numeroAlunos());
        assertEquals("Pedro Oliveira", turma.getAlunos().get(1).getNome());
        
        // Verifica se a disciplina e professor estão corretos
        assertEquals("Matemática", turma.getDisciplina().getNome());
        assertEquals("João Silva", turma.getProfessor().getNome());
    }
}
