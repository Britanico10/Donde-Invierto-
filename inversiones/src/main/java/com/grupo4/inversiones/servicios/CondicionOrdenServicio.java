package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;

public class CondicionOrdenServicio {

	public List<CondicionOrden> getCondicionesOrden() {
		return App.condicionesOrden;
	}
	
}
