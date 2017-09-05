package com.grupo4.inversiones.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.tools.Analizador;

@Entity
@Table(name = "INDICADOR")
public class Indicador {
	private String formula;
	private String idIndicador;
	
	public Indicador(String _idIndicador, String _formula){
		formula = _formula;
		idIndicador = _idIndicador;
	}
	
	@Column(name = "idIndicador")
	public String getIdIndicador(){
		return idIndicador;
	}
	
	public void setIdIndicador(String valor){
		idIndicador = valor;
	}
	
	@Column(name = "formula")
	public String getformula(){
		return formula;
	}
	
	public void setformula(String valor){
		formula = valor;
	}
	
	public double aplicarA(Empresa empresa, int periodo){
		App.empresaActual = empresa;
		App.periodoActual = periodo;
		return Analizador.evaluar(formula);
	}
	
	public List<Double> aplicarEnIntervalo(Empresa empresa, int inicio, int fin) {
		List<Double> indicadoresAplicados = new ArrayList<Double>();
		for(int i = inicio; i <= fin; i++) {
			indicadoresAplicados.add(this.aplicarA(empresa, i));
		}
		
		return indicadoresAplicados;
	}
	
	public Double promedioEnIntervalo(Empresa empresa, int inicio, int fin) {
		List<Double> aplicados = this.aplicarEnIntervalo(empresa, inicio, fin);
		double total = 0;
		for(int i = 0; i < aplicados.size(); i++) {
			total += aplicados.get(i);
		}
		return total / aplicados.size();
	}

}
