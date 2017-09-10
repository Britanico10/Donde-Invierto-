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


public class aplicarCondicionesFiltro {
	
	private Metodologia metodologia = new Metodologia();
	private List <Empresa> empresasEsperadas = new ArrayList<Empresa>();
	private List <Empresa> empresasFiltradas = new ArrayList<Empresa>();

	@Before
	public void setUp() throws Exception {
		inicializadorGlobal.inicializar();
		metodologia.setNombre("prueba");
		metodologia.agregarCondicionFiltro(App.condicionesFiltro.get(2)); //longevidad
		
		for (int i = 0; i < 6; i++) {
			empresasEsperadas.add(App.empresas.get(i));
		}
	}

	@Test
	public void test() throws Exception {
		empresasFiltradas = metodologia.aplicarCondicionesFiltro(App.empresas);
		assertEquals(empresasEsperadas,empresasFiltradas);
	}

}
