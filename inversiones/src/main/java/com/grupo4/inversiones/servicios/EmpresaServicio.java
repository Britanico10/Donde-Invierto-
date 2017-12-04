package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.repositorio.Repositorio;

public class EmpresaServicio {

	Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());

	public List<Empresa> getEmpresas() {
		return repositorio.empresas().buscarTodas();
	}
	
	public List<Empresa> modificarEmpresa(long id, String nuevoNombre, int año){
		repositorio.empresas().modificarEmpresa(id, nuevoNombre, año);
		return getEmpresas();
	}

	public List<Empresa> eliminarEmpresa(long id) {
		repositorio.empresas().eliminarEmpresa(id);
		return getEmpresas();
	}
	
	public List<Empresa> agregarEmpresa(String nombre, int año) {
		Empresa empresa = new Empresa(nombre, año);  
		repositorio.empresas().persistir(empresa);
		return getEmpresas();
	}
	
}