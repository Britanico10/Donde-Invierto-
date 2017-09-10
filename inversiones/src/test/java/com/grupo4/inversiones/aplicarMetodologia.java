package com.grupo4.inversiones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.tools.inicializadorGlobal;

public class aplicarMetodologia {
	
	Metodologia metodologia;
	List<Empresa> empresasEsperado = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		inicializadorGlobal.inicializar();
		metodologia = App.metodologias.get(0);
		empresasEsperado.add(App.empresas.get(2)); //general electric
		empresasEsperado.add(App.empresas.get(4)); //IBM
		empresasEsperado.add(App.empresas.get(3)); //HP
		empresasEsperado.add(App.empresas.get(1)); //berkshire hathaway
		empresasEsperado.add(App.empresas.get(5)); //netflix
		empresasEsperado.add(App.empresas.get(0)); //america movil
	}



	@Test
	public void test() throws Exception {
		
		List<Empresa> empresasPrueba = metodologia.aplicarMetodologiaATodas(App.empresas);
		assertEquals(empresasEsperado,empresasPrueba);
		
	}

}
