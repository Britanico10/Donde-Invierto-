package com.grupo4.inversiones.servicios;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.repositorio.Repositorio;

public class CondicionOrdenServicio {
	
	String PERSISTENCE_UNIT_NAME = "db";
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public List<CondicionOrden> getCondicionesOrden(long idUsuario) {
		return repositorio.condicionesOrden().buscarTodas(idUsuario);
	}
	
	public void borrarCondicion(long id) {
		repositorio.condicionesFiltro().borrarPorId(id);
	}
	
}
