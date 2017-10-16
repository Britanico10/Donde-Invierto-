package com.grupo4.inversiones.servicios;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.GestionMetodologias;

public class MetodologiaServicio {
	
	String PERSISTENCE_UNIT_NAME = "db";
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public List<Metodologia> getMetodologias(long idUsuario) {
		return repositorio.metodologias().buscarTodas(idUsuario);
	}
	
	public String aplicarMetodologia(String nombreMetodologia) throws Exception {
		Metodologia metodologia = repositorio.metodologias().buscarPorNombre(nombreMetodologia);
		return metodologia.aplicarMetodologiaATodas(repositorio.empresas().buscarTodas());
	}
	
	public void eliminarMetodologia(long id) {
		GestionMetodologias.eliminarMetodologiaPorId(id);
	}
	
	public void agregarMetodologia(long idUsuario, String nombre, List<String> condicionesFiltro, List<String> condicionesOrden) {
		GestionMetodologias.agregarMetodologia(idUsuario, nombre, condicionesFiltro, condicionesOrden);
	}
	
	public void editarNombreMetodologia(long idMetodologia, String nombre) {
		GestionMetodologias.editarNombre(idMetodologia, nombre);
	}

}
