package com.grupo4.inversiones.tools;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.repositorio.Repositorio;

public class GestionMetodologias {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	public static void eliminarMetodologiaPorId(long id) {
		repositorio.metodologias().borrarPorId(id);
	}

	public static void agregarMetodologia(long idUsuario, String nombre, List<String> condicionesFiltro,
			List<String> condicionesOrden) {
		Metodologia metodologia = new Metodologia(nombre, idUsuario, condicionesOrden, condicionesFiltro);
		repositorio.metodologias().persistir(metodologia);
	}

	public static void editarNombre(long id, String nuevoNombre) {
		repositorio.metodologias().editarNombreMetodologia(id, nuevoNombre);
	}
	
	public static void editarCondicionesFiltro(long id, List<String> condicionesFiltro) {
		repositorio.metodologias().editarCondicionesFiltroMetodologia(id, condicionesFiltro);
	}
	
	public static void editarCondicionesOrden(long id, List<String> condicionesOrden) {
		repositorio.metodologias().editarCondicionesOrdenMetodologia(id, condicionesOrden);
	}

}
