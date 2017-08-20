package com.grupo4.inversiones.entidades.condiciones;

import com.grupo4.inversiones.entidades.Indicador;

public class Condicion {
	
	String nombreCondicion;
	Indicador indicador;
	int periodo;
	int inicioIntervalo;
	int finalIntervalo;
	
	public Condicion(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, Indicador _indicador, int _periodo) {
		nombreCondicion = _nombreCondicion;
		inicioIntervalo = _inicioIntervalo;
		finalIntervalo = _finalIntervalo;
		indicador = _indicador;
		periodo = _periodo;
	}

}
