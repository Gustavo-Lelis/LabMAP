package com.gus.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CirculoTest {

    private Circulo circulo;

    @BeforeEach
    void setUp(){
        circulo = new Circulo(2);
    }

    @Test
    void testCirculoArea(){
        assertEquals(12.56, circulo.area(), 0.01);
    }

    @Test
    void testCirculoPerimetro(){
        assertEquals(6.28, circulo.perimetro(), 0.01);
    }
    
}
