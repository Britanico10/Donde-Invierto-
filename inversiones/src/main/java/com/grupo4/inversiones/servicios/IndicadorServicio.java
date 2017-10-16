package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.GestionIndicadores;
import com.grupo4.inversiones.tools.VerificadorUsuario;

public class IndicadorServicio {
	
	Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
	
	public List<Indicador> getIndicadores(long idUsuario){
		return repositorio.indicadores().buscarTodas(idUsuario);
	}
	
	public List<Indicador> eliminarIndicador(long idIndi, long idUsuario) {
		if (VerificadorUsuario.verificarUsuarioParaIndicador(idIndi, idUsuario)) {
			GestionIndicadores.eliminarIndicadorPorId(idIndi);
			return getIndicadores(idUsuario);
		}
		return null;
	}
	
	public List<Indicador> agregarIndicador(String nombre, String formula, long idUsuario) {
		GestionIndicadores.crearIndicador(nombre, formula, idUsuario);
		return getIndicadores(idUsuario);
	}
	
	public List<Indicador> editarIndicador(String nombre, String formula, long idUsuario) {
		long idIndi = repositorio.indicadores().buscarPorNombre(nombre).getId();
		if (VerificadorUsuario.verificarUsuarioParaIndicador(idIndi, idUsuario)) {
			GestionIndicadores.editarIndicador(idIndi, formula);
			return getIndicadores(idUsuario);
		}
		return null;
	}
	
	public String aplicarIndicadoresA(String nombreEmpresa, int periodo, long idUsuario) {
		Empresa empresa = repositorio.empresas().buscarPorNombre(nombreEmpresa);
		return AplicarIndicadores.aplicarIndicadores(empresa, periodo, getIndicadores(idUsuario));
	}

}
