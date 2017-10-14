package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;

public class EmpresaServicio {

	public List<Empresa> getEmpresas() {
		return App.empresas;
	}
}
