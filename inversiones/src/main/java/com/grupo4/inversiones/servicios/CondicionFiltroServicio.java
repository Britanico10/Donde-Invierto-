package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;

public class CondicionFiltroServicio {

	public List<CondicionFiltro> getCondicionesFiltro() {
		return App.condicionesFiltro;
	}

}
