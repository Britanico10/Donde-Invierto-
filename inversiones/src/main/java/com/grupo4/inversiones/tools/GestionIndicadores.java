package com.grupo4.inversiones.tools;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

public class GestionIndicadores {
	
	public static void editarIndicador(long idIndi, String nuevaFormula){
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Indicador indicador = repositorio.indicadores().buscarPorId(idIndi);
		if (Analizador.evaluar(nuevaFormula, new Empresa("nombre",1990),2007) != null){
			indicador.setformula(nuevaFormula);
			repositorio.indicadores().modificarPorId(indicador.getId(), nuevaFormula);
		}
		else {
			System.out.println("Formula no válida.");
		}
		repositorio.cerrar();
	}
	
	public static void eliminarIndicador(String nombre) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombre);
		long id = indicador.getId();
		repositorio.indicadores().borrarPorId(id);
		repositorio.cerrar();
	}
	
	public static void eliminarIndicadorPorId(long id) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.indicadores().borrarPorId(id);
		repositorio.cerrar();
	}
	
	public static void crearIndicador(String nombre, String formula, long idUsuario) {
		
		Empresa empresa = new Empresa("nombre",1990);
		
		if (Analizador.evaluar(formula,empresa,2007) != null){
    		Indicador nuevoIndicador = new Indicador(nombre,formula, idUsuario);
    		CargadorDeBaseDeDatos.guardarIndicador(nuevoIndicador);
    	}
	}


}
