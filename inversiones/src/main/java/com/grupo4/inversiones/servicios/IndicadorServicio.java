package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Indicador;

public class IndicadorServicio {
	
	public List<Indicador> getIndicadores(){
		return App.indicadores;
	}

}
