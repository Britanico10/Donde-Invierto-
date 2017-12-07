package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.GestionMetodologias;
import com.grupo4.inversiones.tools.VerificadorUsuario;

public class MetodologiaServicio {

	public List<Metodologia> getMetodologias(long idUsuario) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		List<Metodologia> res = repositorio.metodologias().buscarTodas(idUsuario);
		repositorio.cerrar();
		return res;
	}
	
	public String aplicarMetodologia(String nombreMetodologia, long idUsuario) throws Exception {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Metodologia metodologia = repositorio.metodologias().buscarPorNombre(nombreMetodologia);
		repositorio.cerrar();
		long idDuenioMetodologia = metodologia.getDuenio();
		if (VerificadorUsuario.verificarUsuarioParaMetodologias(idDuenioMetodologia, idUsuario)) {
			return metodologia.aplicarMetodologiaATodas(repositorio.empresas().buscarTodas());
		}
		return null;
	}
	
	public List<Metodologia> eliminarMetodologia(String nombreMetodologia, long idUsuario) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		long idMeto = repositorio.metodologias().buscarPorNombre(nombreMetodologia).getId();
		repositorio.cerrar();
		if (VerificadorUsuario.verificarUsuarioParaMetodologias(idMeto, idUsuario)) {
			GestionMetodologias.eliminarMetodologiaPorId(idMeto);
			return getMetodologias(idUsuario);
		}
		return null;
	}
	
	public List<Metodologia> agregarMetodologia(long idUsuario, String nombre, List<String> condicionesFiltro, List<String> condicionesOrden) {
		GestionMetodologias.agregarMetodologia(idUsuario, nombre, condicionesFiltro, condicionesOrden);
		return getMetodologias(idUsuario);
	}
	
	public List<Metodologia> editarNombreMetodologia(String nombreMetodologia, String nuevoNombre, long idUsuario) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		long idMetodologia = repositorio.metodologias().buscarPorNombre(nombreMetodologia).getId();
		repositorio.cerrar();
		if (VerificadorUsuario.verificarUsuarioParaMetodologias(idMetodologia, idUsuario)) {
			GestionMetodologias.editarNombre(idMetodologia, nuevoNombre);
			return getMetodologias(idUsuario);
		}
		return null;
	}

}
