package com.grupo4.inversiones.entidades;

import java.util.ArrayList;
import java.util.List;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.tools.PrintEmpresas;
import com.grupo4.inversiones.tools.Rentabilidad;
import edu.emory.mathcs.backport.java.util.Collections;

public class Metodologia {
	
	private String nombre;
	private List<CondicionOrden> condicionesOrden = new ArrayList<CondicionOrden>();
	private List<CondicionFiltro> condicionesFiltro = new ArrayList<CondicionFiltro>();
	
	public List<Empresa> aplicarCondicionesFiltro(List<Empresa> empresas) {
		List<Empresa> empresasFiltradas = empresas;
		for(int i = 0; i < condicionesFiltro.size(); i++) {
			empresasFiltradas = condicionesFiltro.get(i).filtrar(empresas);
		}
		return empresasFiltradas;
	}
	
	public void aplicarCondicionesDeOrden(List<Empresa> empresas) {
		Rentabilidad.inicializarRentabilidad(empresas);
		for(int i = 0; i < condicionesOrden.size(); i++) {
			condicionesOrden.get(i).evaluar(empresas);
		}
	}
	
	public List<Empresa> aplicarMetodologiaATodas(List<Empresa> empresas){
		
		List<Empresa> empresasFiltradas = aplicarCondicionesFiltro(empresas);
		aplicarCondicionesDeOrden(empresasFiltradas);
		
		
		Collections.sort(empresasFiltradas);
		//PrintEmpresas.mostrarEmpresas(empresasFiltradas);
		return empresasFiltradas;
		
	}
	
	
	
	
}
