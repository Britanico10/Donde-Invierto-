package com.grupo4.inversiones.tools;

import java.io.FileNotFoundException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.repositorio.Repositorio;

public class PasarCosasABaseDeDatos {
	
	private static final String PERSISTENCE_UNIT_NAME = "db";
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public static void pasarEmpresasDeTxtABase() throws FileNotFoundException {
		App.empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
		
		for(Empresa emp: App.empresas) {
			repositorio.empresas().persistir(emp);
		}
	}
	
	public static void pasarCondicionesDeTxtABase() throws FileNotFoundException {
		App.condicionesFiltro = cargadorDeArchivos.cargarArchivoCondicionesFiltro("src/main/condicionesFiltro.txt");
		App.condicionesOrden = cargadorDeArchivos.cargarArchivoCondicionesOrden("src/main/condicionesOrden.txt");
		
		for(CondicionFiltro cond: App.condicionesFiltro) {
			repositorio.condicionesFiltro().persistir(cond);
		}
		
		for(CondicionOrden cond: App.condicionesOrden) {
			repositorio.condicionesOrden().persistir(cond);
		}
	}
	
	public static void pasarMetodologiasDeTxtABase() throws FileNotFoundException {
		
		App.metodologias = cargadorDeArchivos.cargarArchivoMetodologias("src/main/metodologias.txt");
		
		for(Metodologia cond: App.metodologias) {
			repositorio.metodologias().persistir(cond);
		}
	}
	
}
