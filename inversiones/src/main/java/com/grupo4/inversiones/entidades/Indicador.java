package com.grupo4.inversiones.entidades;

import java.io.IOException;

import com.grupo4.inversiones.tools.Analizador;

public class Indicador {
	private String idIndicador;
	private String formula;
	
	public Indicador(String _idIndicador, String _formula){
		idIndicador = _idIndicador;
		formula = _formula;
	}
	
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
	
	public double aplicarA(Empresa empresa){
		return Analizador.evaluar(formula);
	}

}
