package com.grupo4.inversiones.tools;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

public class EditarIndicador {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	public static void editarIndicador(List<Indicador> indicadores,String nombre, String nuevaFormula){
		Indicador indicador = Listas.buscarIndicadorEn(indicadores,nombre);
		if (Analizador.evaluar(nuevaFormula) != null){
			indicador.setformula(nuevaFormula);
			repositorio.indicadores().modificarPorId(indicador.getId(), nuevaFormula);
		}
		else {
			System.out.println("Formula no válida.");
		}
	}
	
	public static void eliminarIndicador(List<Indicador> indicadores, String nombre) {
		Indicador indicador = Listas.buscarIndicadorEn(indicadores,nombre);
		long id = indicador.getId();
		repositorio.indicadores().borrarPorId(id);
		App.indicadores.remove(indicador);
	}
	
	public static void eliminarIndicadorPorId(long id) {
		repositorio.indicadores().borrarPorId(id);
	}

}
