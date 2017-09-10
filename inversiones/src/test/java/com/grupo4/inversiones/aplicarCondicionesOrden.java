package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.tools.cargadorDeArchivos;
import com.grupo4.inversiones.tools.inicializadorGlobal;

public class aplicarCondicionesOrden {
	
	private List<Empresa> empresasPrueba = new ArrayList<Empresa>(), empresasEsperado = new ArrayList<Empresa>();
	private Metodologia metodologia = new Metodologia();

	@Before
	public void setUp() throws Exception {
		inicializadorGlobal.inicializar();
		metodologia.setNombre("prueba");
		metodologia.agregarCondicionOrden(App.condicionesOrden.get(0)); //maximizar ROE
		
		for(int i = 0; i < 3; i++) {
			empresasPrueba.add(App.empresas.get(i));
		}
		
		empresasEsperado.add(App.empresas.get(1));
		empresasEsperado.add(App.empresas.get(2));
		empresasEsperado.add(App.empresas.get(0));
		
	}

	@Test
	public void test() throws Exception {
		metodologia.aplicarCondicionesDeOrden(empresasPrueba);
		assertEquals(empresasEsperado, empresasPrueba);
	}

}
