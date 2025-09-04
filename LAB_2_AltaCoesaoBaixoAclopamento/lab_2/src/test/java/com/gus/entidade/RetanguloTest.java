package com.gus.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetanguloTest {
    
    private Retangulo retangulo;

    @BeforeEach
    void setUp(){
        retangulo = new Retangulo(8, 9);
    }

    @Test
    void testRetanguloArea(){
        assertEquals(72.00, retangulo.area(), 0.01);
    }

    @Test
    void testRetanguloPerimetro(){
        assertEquals(34.00, retangulo.perimetro(), 0.01);
    }
}
