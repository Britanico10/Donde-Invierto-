package com.grupo4.inversiones.entidades;

public class Cuenta {
	private int valor;
	private String nombre;
	
	public Cuenta(String _nombre, int _valor) {
		valor = _valor;
		nombre = _nombre;
	}
	
	public Cuenta(String _nombre){
		nombre = _nombre;
	}
	
	//getters
	
	public int getValor() {
		return valor;
	}
	public String getNombre(){
		return nombre;
	}
}
