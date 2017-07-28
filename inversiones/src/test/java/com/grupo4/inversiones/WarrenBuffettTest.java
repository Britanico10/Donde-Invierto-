package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Reglas;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class WarrenBuffettTest {

	@Test
	public void test() {
		
			List<Empresa> empresas = new ArrayList<Empresa>();
			empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
			Reglas.inicializarMotor(empresas,"buffett");
			
			
			assertEquals("General Electric", outContent.toString());
			
	}

}
