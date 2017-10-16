package com.grupo4.inversiones.tools;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

public class GestionIndicadores {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	public static void editarIndicador(String nombre, String nuevaFormula){
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombre);
		if (Analizador.evaluar(nuevaFormula, new Empresa("nombre",1990),2007) != null){
			indicador.setformula(nuevaFormula);
			repositorio.indicadores().modificarPorId(indicador.getId(), nuevaFormula);
		}
		else {
			System.out.println("Formula no válida.");
		}
	}
	
	public static void eliminarIndicador(String nombre) {
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombre);
		long id = indicador.getId();
		repositorio.indicadores().borrarPorId(id);
	}
	
	public static void eliminarIndicadorPorId(long id) {
		repositorio.indicadores().borrarPorId(id);
	}
	
	public static void crearIndicador(String nombre, String formula) {
		
		Empresa empresa = new Empresa("nombre",1990);
		
		if (Analizador.evaluar(formula,empresa,2007) != null){
    		Indicador nuevoIndicador = new Indicador(nombre,formula);
    		CargadorDeBaseDeDatos.guardarIndicador(nuevoIndicador);
    	}
	}


}
