package com.grupo4.inversiones.entidades;

public class Condicion {
	
	private String nombre;
	private String condicion;
	
	public Condicion(String _condicion, String _nombre){
		condicion = _condicion;
		nombre = _nombre;
	}
	
	public Condicion(){
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getCondicion(){
		return nombre;
	}
	
	public void setNombre(String _nombre){
		nombre = _nombre;
	}
	
	public void setCondiciones(String _condicion){
		condicion = _condicion;
	}
	
	
}
