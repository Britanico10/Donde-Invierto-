package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.PrintEmpresas;
import com.grupo4.inversiones.tools.Reglas;
import com.grupo4.inversiones.tools.Rentabilidad;
import com.grupo4.inversiones.tools.cargadorDeArchivos;


public class WarrenBuffettTest {

	@Test
	public void test() throws FileNotFoundException {
		List<Empresa> empresasOrdenadas;
		List<Indicador> indicadores;
		List<Empresa> empresas;
		empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	App.indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
    	empresasOrdenadas = Reglas.inicializarMotor(empresas,"buffett"); 
    	PrintEmpresas.imprimirResultado(empresasOrdenadas); 
		assertEquals((empresasOrdenadas.get(0).getNombre()),"General Electric");
		
	}

}
