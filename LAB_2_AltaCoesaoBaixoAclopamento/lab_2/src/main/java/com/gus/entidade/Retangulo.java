package com.gus.entidade;

import com.gus.interfaces.IFiguraGerometrica;

public class Retangulo implements IFiguraGerometrica {

    private  double altura;
    private  double base;
    

    public Retangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
        
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura){
        if(altura < 0){
            throw new IllegalArgumentException("Valor negativo inválido.");
        }
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base){
        if(base < 0){
            throw new IllegalArgumentException("Valor negativo inválido.");
        }
        this.base = base;
    }


    @Override
    public double area(){
        return base * altura;
    }

    @Override
    public double perimetro(){
        return 2 * (altura + base);
    }

    @Override
    public String toStrings(){
        return ("O retangulo criado tem altura de tamanho: " + this.altura + 
			"e base de tamanho: " + this.base);
    }

}
