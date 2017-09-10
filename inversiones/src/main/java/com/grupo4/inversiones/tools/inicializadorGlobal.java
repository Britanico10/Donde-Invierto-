package com.grupo4.inversiones.tools;

import java.io.FileNotFoundException;

import com.grupo4.inversiones.App;

public class inicializadorGlobal {
	
	public static void inicializar() throws FileNotFoundException {
		App.empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
		App.indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
		App.condicionesFiltro = cargadorDeArchivos.cargarArchivoCondicionesFiltro("src/main/condicionesFiltro.txt");
		App.condicionesOrden = cargadorDeArchivos.cargarArchivoCondicionesOrden("src/main/condicionesOrden.txt");
		App.metodologias = cargadorDeArchivos.cargarArchivoMetodologias("src/main/metodologias.txt");
		App.empresaActual = App.empresas.get(0);
		App.periodoActual = 2007;
	}
}
