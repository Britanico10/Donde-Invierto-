package com.grupo4.inversiones.tools;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.repositorio.Repositorio;

public class GestionMetodologias {
	
	public static void eliminarMetodologiaPorId(long id) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.metodologias().borrarPorId(id);
		repositorio.cerrar();
	}

	public static void agregarMetodologia(long idUsuario, String nombre, List<String> condicionesFiltro,
			List<String> condicionesOrden) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Metodologia metodologia = new Metodologia(nombre, idUsuario, condicionesOrden, condicionesFiltro);
		repositorio.metodologias().persistir(metodologia);
		repositorio.cerrar();
	}

	public static void editarNombre(long id, String nuevoNombre) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.metodologias().editarNombreMetodologia(id, nuevoNombre);
		repositorio.cerrar();
	}
	
	public static void editarCondicionesFiltro(long id, List<String> condicionesFiltro) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.metodologias().editarCondicionesFiltroMetodologia(id, condicionesFiltro);
		repositorio.cerrar();
	}
	
	public static void editarCondicionesOrden(long id, List<String> condicionesOrden) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.metodologias().editarCondicionesOrdenMetodologia(id, condicionesOrden);
		repositorio.cerrar();
	}

}
