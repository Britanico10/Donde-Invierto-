package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Metodologia;

public class MetodologiaServicio {

	public List<Metodologia> getMetodologias() {
		return App.metodologias;
	}

}
