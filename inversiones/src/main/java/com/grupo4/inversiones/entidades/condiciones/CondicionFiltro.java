package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class CondicionFiltro extends Condicion {
	
	public CondicionFiltro(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, Indicador _indicador, int _periodo) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _indicador, _periodo);
		
	}
	
	public List<Empresa> filtrar(List<Empresa> empresas){
		return empresas;
		}
	
}
