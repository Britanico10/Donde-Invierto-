package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class AplicarIndicadoresTest {

	@Test
	public void test() throws FileNotFoundException {
		List<Indicador> indicadores = new ArrayList<Indicador>();
		List<Empresa> empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	Indicador indicador = new Indicador("prueba","4+ebitda");
    	indicadores.add(indicador);
    	App.situacionActual.setFst(empresas.get(0));
		App.situacionActual.setSnd(2007);
		Empresa empresa = (Empresa) App.situacionActual.getFst();
    	
    	assertEquals(77695.0, indicador.aplicarA(empresa), 0.0);
	}

}
