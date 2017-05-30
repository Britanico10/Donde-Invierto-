package com.grupo4.inversiones.operaciones;

public class Factor{

    private double valor; 
    //factor puede tener una expresion entre parentesis, por eso no pongo valor

    public Factor(Double valor) {
        this.valor = valor;
    }
    
    public Factor(){
    }

	public void setResultado(double valor){
    	this.valor = valor;
    }

    public double getResultado() {
        return valor;
    }
    
}