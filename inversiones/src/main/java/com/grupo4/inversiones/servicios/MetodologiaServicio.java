package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.GestionMetodologias;
import com.grupo4.inversiones.tools.VerificadorUsuario;

public class MetodologiaServicio {

	Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());

	public List<Metodologia> getMetodologias(long idUsuario) {
		return repositorio.metodologias().buscarTodas(idUsuario);
	}
	
	public String aplicarMetodologia(String nombreMetodologia, long idUsuario) throws Exception {
		Metodologia metodologia = repositorio.metodologias().buscarPorNombre(nombreMetodologia);
		long idMetodologia = metodologia.getDuenio();
		if (VerificadorUsuario.verificarUsuarioParaMetodologias(idMetodologia, idUsuario)) {
			return metodologia.aplicarMetodologiaATodas(repositorio.empresas().buscarTodas());
		}
		return null;
	}
	
	public List<Metodologia> eliminarMetodologia(long idMeto, long idUsuario) {
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
	
	public List<Metodologia> editarNombreMetodologia(long idMetodologia, String nuevoNombre, long idUsuario) {
		if (VerificadorUsuario.verificarUsuarioParaMetodologias(idMetodologia, idUsuario)) {
			GestionMetodologias.editarNombre(idMetodologia, nuevoNombre);
			return getMetodologias(idUsuario);
		}
		return null;
	}

}
