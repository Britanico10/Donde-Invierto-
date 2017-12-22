package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.repositorio.Repositorio;

public class EmpresaServicio {

	public List<Empresa> getEmpresas() {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		List<Empresa> res = repositorio.empresas().buscarTodas();
		repositorio.cerrar();
		return res;
	}
	
	public List<Empresa> modificarEmpresa(long id, String nuevoNombre, int año){
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.empresas().modificarEmpresa(id, nuevoNombre, año);
		repositorio.cerrar();
		return getEmpresas();
	}

	public List<Empresa> eliminarEmpresa(long id) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.empresas().eliminarEmpresa(id);
		repositorio.cerrar();
		return getEmpresas();
	}
	
	public List<Empresa> agregarEmpresa(String nombre, int año) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Empresa empresa = new Empresa(nombre, año);  
		repositorio.empresas().persistir(empresa);
		repositorio.cerrar();
		return getEmpresas();
	}
	
	public void agregarEmpresaSinRetorno(String nombre, int año) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Empresa empresa = new Empresa(nombre, año);  
		repositorio.empresas().persistir(empresa);
		repositorio.cerrar();
	}
	
	public void borrarEmpresas() {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.empresas().borrarEmpresas();
		repositorio.cerrar();
	}
	
}