package com.grupo4.inversiones;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.CargadorDeArchivos;

public class CargadorDeArchivosTest {

	@Test
	public void test() throws FileNotFoundException {
		List<Indicador> indicadores;
		List<Empresa> empresas;
		empresas = CargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	indicadores = CargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
    	//PrintEmpresas.mostrarEmpresas(empresas);
    	assertEquals(empresas.size(), 7);
    	
	}

}
