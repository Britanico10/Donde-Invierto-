package com.grupo4.inversiones.entidades;

import java.io.IOException;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.tools.Analizador;

public class Indicador {
	private String formula;
	private String idIndicador;
	
	public Indicador(String _idIndicador, String _formula){
		formula = _formula;
		idIndicador = _idIndicador;
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
	
	public double aplicarA(Empresa empresa, int periodo){
		App.empresaActual = empresa;
		App.periodoActual = periodo;
		return Analizador.evaluar(formula);
	}

}
