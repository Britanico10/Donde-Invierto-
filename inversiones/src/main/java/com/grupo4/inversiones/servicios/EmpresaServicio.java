package com.grupo4.inversiones.servicios;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.repositorio.Repositorio;

public class EmpresaServicio {
	
	String PERSISTENCE_UNIT_NAME = "db";
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public List<Empresa> getEmpresas() {		
		return repositorio.empresas().buscarTodas();
	}
}