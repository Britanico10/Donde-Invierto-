package com.grupo4.inversiones.servicios;

import java.io.IOException;
import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.GestionIndicadores;
import com.grupo4.inversiones.tools.VerificadorUsuario;

public class IndicadorServicio {
	
	public List<Indicador> getIndicadores(long idUsuario){
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		List<Indicador> res = repositorio.indicadores().buscarTodas(idUsuario);
		repositorio.cerrar();
		return res;
	}
	
	public List<Indicador> eliminarIndicador(long idIndi, long idUsuario) {
		if (VerificadorUsuario.verificarUsuarioParaIndicador(idIndi, idUsuario)) {
			GestionIndicadores.eliminarIndicadorPorId(idIndi);
			try {
				AplicarIndicadores.precalculo();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getIndicadores(idUsuario);
		}
		return null;
	}
	
	public List<Indicador> agregarIndicador(String nombre, String formula, long idUsuario) {
		GestionIndicadores.crearIndicador(nombre, formula, idUsuario);
		try {
			AplicarIndicadores.precalculo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getIndicadores(idUsuario);
	}
	
	public List<Indicador> editarIndicador(String nombre, String formula, long idUsuario) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		long idIndi = repositorio.indicadores().buscarPorNombre(nombre).getId();
		repositorio.cerrar();
		if (VerificadorUsuario.verificarUsuarioParaIndicador(idIndi, idUsuario)) {
			GestionIndicadores.editarIndicador(idIndi, formula);
			try {
				AplicarIndicadores.precalculo();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getIndicadores(idUsuario);
		}
		return null;
	}
	
	public String aplicarIndicadoresA(String nombreEmpresa, int periodo, long idUsuario) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Empresa empresa = repositorio.empresas().buscarPorNombre(nombreEmpresa);
		repositorio.cerrar();
		return AplicarIndicadores.aplicarIndicadores(empresa, periodo, getIndicadores(idUsuario));
	}

	public String precalculoIndicadores(long userId) {
		try {
			AplicarIndicadores.precalculo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "OK";
	}

}
