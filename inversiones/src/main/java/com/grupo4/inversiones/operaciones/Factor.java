package com.grupo4.inversiones.operaciones;

public class Factor implements IExpresion {

    private double valor;

    public Factor(double valor) {
        this.valor = valor;
    }

    public double getResultado() {
        return valor;
    }
    
}