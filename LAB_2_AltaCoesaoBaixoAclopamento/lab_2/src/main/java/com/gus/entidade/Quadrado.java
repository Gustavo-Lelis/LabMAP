package com.gus.entidade;



public class Quadrado extends Retangulo {
    
    public Quadrado(double altura, double base) {
        super(altura, base);
    }

    @Override
    public String toStrings(){
        return ("O quadrado criado tem altura de tamanho: " + this.getAltura()  + 
			"e base de tamanho: " + this.getBase());
    }
}
