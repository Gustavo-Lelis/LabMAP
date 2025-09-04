package com.gus.entidade;

import com.gus.interfaces.IFiguraGerometrica;

public class Circulo implements IFiguraGerometrica {

    private  double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio){
        if(raio < 0){
            throw new IllegalArgumentException("Valor negativo inválido.");
        }
        this.raio = raio;
    }

    @Override
    public double area(){
        return 2 * 3.14 * raio;
    }

    @Override
    public double perimetro(){
        return 3.14 * raio;
    }

    @Override
    public String toStrings(){
        return ("O retangulo criado tem raio de tamanho: " + this.raio);
    }

}
