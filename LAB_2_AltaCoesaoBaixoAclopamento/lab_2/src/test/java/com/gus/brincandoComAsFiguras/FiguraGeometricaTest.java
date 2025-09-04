package com.gus.brincandoComAsFiguras;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FiguraGeometricaTest {

    private FiguraGeometrica figura;
    

    @BeforeEach
    void setUp(){
        figura = new FiguraGeometrica(10, 5, 2);
    }

    @Test
    void testFiguras() {

        assertEquals(10, figura.getQuadrado().getAltura());
        assertEquals(5, figura.getQuadrado().getBase());
        assertEquals(10, figura.getRetangulo().getAltura());
        assertEquals(5, figura.getRetangulo().getBase());
        assertEquals(2, figura.getCirculo().getRaio());
        
    }

    @Test
    void testFigurasNovosValoresCirculo() {
        figura.setCirculo(8);

        assertEquals(8, figura.getCirculo().getRaio());
        
    }

    @Test
    void testFigurasNovosValoresRetangulo() {
        figura.setRetangulo(4, 6);

        assertEquals(4, figura.getRetangulo().getAltura());
        assertEquals(6, figura.getRetangulo().getBase());
        
    }

    @Test
    void testFigurasNovosValoresQuadrado() {
        figura.setQuadrado(5, 5);

        assertEquals(5, figura.getQuadrado().getAltura());
        assertEquals(5, figura.getQuadrado().getBase());
    }


    @Test
    void testSetQuadradoComBaseNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            figura.setQuadrado(2.0, -2.0);
        });
        assertEquals("Valore negativo inválido.", exception.getMessage());
    }

    @Test
    void testSetRetanguloComAlturaNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            figura.setRetangulo(2.0,-2.0);
        });
        assertEquals("Valore negativo inválido.", exception.getMessage());
    }

    @Test
    void testSetRetanguloComAlturaNegativa2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            figura.setRetangulo(-1.0,2.0);
        });
        assertEquals("Valore negativo inválido.", exception.getMessage());
    }
     
    @Test
    void testSetCirculoComRaioNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            figura.setCirculo(-2.0);
        });
        assertEquals("Valore negativo inválido.", exception.getMessage());
    }
}


