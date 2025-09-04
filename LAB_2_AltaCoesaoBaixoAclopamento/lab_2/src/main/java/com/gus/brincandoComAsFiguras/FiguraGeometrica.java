package com.gus.brincandoComAsFiguras;

import com.gus.entidade.Circulo;
import com.gus.entidade.Quadrado;
import com.gus.entidade.Retangulo;

public class FiguraGeometrica {

    private Quadrado quadrado;
    private Retangulo retangulo;
    private Circulo circulo;

    public FiguraGeometrica(double altura, double base, double raio){
        if(altura < 0 || base < 0 || raio < 0){
            throw new IllegalArgumentException("Valores negativos inválidos.");
        }
        quadrado = new Quadrado(altura, base);
        retangulo = new Retangulo(altura, base);
        circulo = new Circulo(raio);
    }

    public Quadrado getQuadrado() {
        return quadrado;
    }

    public void setQuadrado(double altura, double base) {
        if(altura < 0 || base < 0){
            throw new IllegalArgumentException("Valore negativo inválido.");
        }
        quadrado = new Quadrado(altura, base);
    }

    public Retangulo getRetangulo() {
        return retangulo;
    }

    public void setRetangulo(double altura, double base) {
        if(altura < 0 || base < 0){
            throw new IllegalArgumentException("Valore negativo inválido.");
        }
        retangulo = new Retangulo(altura, base);
    }

    public Circulo getCirculo() {
        return circulo;
    }

    public void setCirculo(double raio) {
        if(raio < 0){
            throw new IllegalArgumentException("Valore negativo inválido.");
        }
        circulo = new Circulo(raio);
    }

    @Override
    public String toString(){
		return ("O retângulo criado tem altura: " + this.retangulo.getAltura() + " e base de: " + this.retangulo.getBase() + ".\n" +
		"O quadrado criado tem altura de: " + this.quadrado.getAltura() + " e base de: " + this.retangulo.getBase() + ".\n" +
		"O circulo criado tem raio de: " + this.circulo.getRaio()) + ".";
	}

}
