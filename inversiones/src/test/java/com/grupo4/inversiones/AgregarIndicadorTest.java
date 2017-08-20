package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Analizador;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class AgregarIndicadorTest {

	@Test
	public void test() throws FileNotFoundException{
		
		int tamañoAnterior;
	
		List<Indicador> indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
		List<Empresa> empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
		
    	App.empresaActual = empresas.get(0);
		App.periodoActual = 2007;
		
		tamañoAnterior = indicadores.size();
	
		Indicador nuevoIndicador;
		
    	String nombreIndicador = "prueba";
    	
    	String formula = "4*ebitda";
    	
    		if (Analizador.evaluar(formula) != null){
        		nuevoIndicador = new Indicador(nombreIndicador,formula);
        		indicadores.add(nuevoIndicador);
        		System.out.println("Indicador guardado.");
    		}
    	
    	assertEquals(indicadores.size(), tamañoAnterior + 1);
	
	}

}
