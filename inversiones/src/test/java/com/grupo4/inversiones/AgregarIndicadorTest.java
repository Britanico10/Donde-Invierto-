package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.CreadorIndicadores;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class AgregarIndicadorTest {

	@Test
	public void test() throws FileNotFoundException{
		
		int tamañoAnterior;
	
		List<Indicador> indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
		
		tamañoAnterior = indicadores.size();
	
    	CreadorIndicadores.crearIndicador(indicadores);
    	
    	assertEquals(indicadores.size(), tamañoAnterior + 1);
	
	}

}
