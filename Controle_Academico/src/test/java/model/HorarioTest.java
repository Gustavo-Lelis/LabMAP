package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gus.entidades.Horario;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

public class HorarioTest {
    private Horario horario;


    @BeforeEach
    void setUp() {
        // Executado ANTES de cada teste
        horario = new Horario("Quarta-Feira", LocalTime.of(9, 0), LocalTime.of(11, 0));
    }

    @Test
    void testHorarioAlunoString() {
        String esperado = "Quarta-Feira 09:00 - 11:00";
        assertEquals(esperado, horario.toString());
    }

    
   @Test
    void testHorarioAluno() {
        assertEquals("Quarta-Feira", horario.getDiaSemana());
        assertEquals(LocalTime.of(9, 0), horario.getHoraInicio());
        assertEquals(LocalTime.of(11, 0), horario.getHoraFim());
    }
}
