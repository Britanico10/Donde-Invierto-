package com.grupo4.inversiones.servicios;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.GestionIndicadores;

public class IndicadorServicio {
	
	String PERSISTENCE_UNIT_NAME = "db";
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	public List<Indicador> getIndicadores(long idUsuario){
		return repositorio.indicadores().buscarTodas(idUsuario);
	}
	
	public void eliminarIndicador(long id) {
		GestionIndicadores.eliminarIndicadorPorId(id);
	}
	
	public void agregarIndicador(String nombre, String formula) {
		GestionIndicadores.crearIndicador(nombre, formula);
	}
	
	public void editarIndicador(String nombre, String formula) {
		GestionIndicadores.editarIndicador(nombre, formula);
	}
	
	public String aplicarIndicadoresA(String nombreEmpresa, int periodo, long idUsuario) {
		Empresa empresa = repositorio.empresas().buscarPorNombre(nombreEmpresa);
		return AplicarIndicadores.aplicarIndicadores(empresa, periodo, getIndicadores(idUsuario));
	}

}
