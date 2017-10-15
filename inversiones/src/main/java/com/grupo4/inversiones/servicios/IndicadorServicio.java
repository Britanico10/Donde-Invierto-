package com.grupo4.inversiones.servicios;

import java.sql.SQLException;
import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.CreadorIndicadores;
import com.grupo4.inversiones.tools.EditarIndicador;
import com.grupo4.inversiones.tools.Listas;
import com.grupo4.inversiones.tools.inicializadorGlobal;

public class IndicadorServicio {
	
	public List<Indicador> getIndicadores(){
		return App.indicadores;
	}
	
	public void eliminarIndicador(long id) {
		EditarIndicador.eliminarIndicadorPorId(id);
		try {
			inicializadorGlobal.cargarIndicadores();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarIndicador(String nombre, String formula) {
		CreadorIndicadores.crearIndicador(App.indicadores, nombre, formula);
		try {
			inicializadorGlobal.cargarIndicadores();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarIndicador(String nombre, String formula) {
		EditarIndicador.editarIndicador(App.indicadores, nombre, formula);
		try {
			inicializadorGlobal.cargarIndicadores();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String aplicarIndicadoresA(String nombreEmpresa, int periodo) {
		Empresa empresa = Listas.buscarEmpresaEn(nombreEmpresa,App.empresas);
		return AplicarIndicadores.aplicarIndicadores(empresa, periodo, App.indicadores);
	}

}
