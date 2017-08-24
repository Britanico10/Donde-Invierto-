package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class CondicionOrden extends Condicion {
	
	int importancia;
	
	public int getImportancia() {
		return importancia;
	}

	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}

	public CondicionOrden(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, String _indicador, int _periodo, int _importancia) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _indicador, _periodo);
		importancia = _importancia;
	}
	
	public void evaluar(List<Empresa> empresas) {
		ordenarPorIndicador(empresas);
		calcularRentabilidad(empresas);
	}
	
	public void ordenarPorIndicador(List<Empresa> empresas) {}
	
	public void calcularRentabilidad(List<Empresa> empresas) {
		for(int i = 0; i < empresas.size(); i++) {
			empresas.get(i).setRentabilidad(i*importancia);
		}
	}

}
