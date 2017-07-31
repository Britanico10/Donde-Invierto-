package com.grupo4.inversiones.entidades;

public class Indicador {
	private String formula;
	private String idIndicador;
	
	public String getIdIndicador(){
		return idIndicador;
	}
	
	public String getformula(){
		return formula;
	}	
	
	public void setIdIndicador(String valor){
		idIndicador = valor;
	}
	
	public void setformula(String valor){
		formula = valor;
	}

}