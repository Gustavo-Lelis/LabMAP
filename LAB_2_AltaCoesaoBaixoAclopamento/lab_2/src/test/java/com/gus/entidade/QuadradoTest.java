package com.gus.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuadradoTest {

    private Quadrado quadrado;

    @BeforeEach
    void setUp(){
        quadrado = new Quadrado(10, 5);
    }

    @Test
    void testQuadradoArea(){
        assertEquals(50.00, quadrado.area(), 0.01);
    }

    @Test
    void testQuadradoPerimetro(){
        assertEquals(30.00, quadrado.perimetro(), 0.01);
    }
    
}
