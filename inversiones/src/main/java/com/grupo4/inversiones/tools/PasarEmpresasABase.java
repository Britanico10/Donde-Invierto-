package com.grupo4.inversiones.tools;

import java.io.FileNotFoundException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.repositorio.Repositorio;

public class PasarEmpresasABase {
	
	private static final String PERSISTENCE_UNIT_NAME = "db";
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public void pasarDeTxtABase() throws FileNotFoundException {
		App.empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
		for(Empresa emp: App.empresas) {
			repositorio.empresas().persistir(emp);
		}
	}
	
}
