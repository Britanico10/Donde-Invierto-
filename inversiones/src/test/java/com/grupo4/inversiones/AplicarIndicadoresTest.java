package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class AplicarIndicadoresTest {

	@Test
	public void test() throws FileNotFoundException {
		List<Indicador> indicadores;
		List<Empresa> empresas;
		empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
    	App.situacionActual.set
	}

}
