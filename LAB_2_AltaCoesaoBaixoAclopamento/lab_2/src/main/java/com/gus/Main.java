package com.gus;

import com.gus.brincandoComAsFiguras.FiguraGeometrica;
import com.gus.entidade.Circulo;
import com.gus.entidade.Quadrado;
import com.gus.entidade.Retangulo;

public class Main {
    public static void main(String[] args) {
       
        System.out.println("=== Criando figuras geometricas ===");
        FiguraGeometrica figuras = new FiguraGeometrica(5.0, 8.0, 3.0);
            
            
        System.out.println(figuras.toString());
        System.out.println();
            
            
        System.out.println("=== Calculos das figuras ===");
            
        Quadrado quadrado = figuras.getQuadrado();
        System.out.println("Quadrado - Area: " + quadrado.area() + 
                         ", Perimetro: " + quadrado.perimetro());
        System.out.println();
           
        Retangulo retangulo = figuras.getRetangulo();
        System.out.println("Retangulo - Area: " + retangulo.area() + 
                          ", Perimetro: " + retangulo.perimetro());
        System.out.println();
            
        Circulo circulo = figuras.getCirculo();
        System.out.println("Circulo - Area: " + circulo.area() + 
                         ", Perimetro: " + circulo.perimetro());
        System.out.println();
            
            
        System.out.println("=== Modificando as figuras ===");
        figuras.setQuadrado(7.0, 7.0);
        figuras.setRetangulo(10.0, 15.0);
        figuras.setCirculo(5.5);
            
        System.out.println(figuras.toString());
        System.out.println();
    }
}