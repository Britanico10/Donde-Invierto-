package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.CargadorDeArchivos;

public class CargarIndicadorPredefinidoTest {

	@Test
	public void test() throws FileNotFoundException {
		List<Indicador> indicadores = new ArrayList<Indicador>();
		indicadores = CargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
		Indicador ingresoNetoCargado = indicadores.get(0);
		Indicador ingresoNetoEsperado = new Indicador("ingresoNeto","ingNetoOpCont + ingNetoOpDiscont", 0);
		assertEquals(ingresoNetoCargado.getformula(), ingresoNetoEsperado.getformula());
		assertEquals(ingresoNetoCargado.getIdIndicador(), ingresoNetoEsperado.getIdIndicador());
	}

}
