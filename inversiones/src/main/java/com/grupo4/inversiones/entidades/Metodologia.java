package com.grupo4.inversiones.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.persistencia.Persistible;
import com.grupo4.inversiones.tools.Listas;
import com.grupo4.inversiones.tools.PrintEmpresas;
import com.grupo4.inversiones.tools.Rentabilidad;
import edu.emory.mathcs.backport.java.util.Collections;

@Entity
@Table(name = "METODOLOGIA")
public class Metodologia extends Persistible{
	
	private String nombre; 
	
	@ElementCollection
	@CollectionTable(name="condicionesOrden", joinColumns=@JoinColumn(name = "idMetodologia", referencedColumnName = "id"))
	@Column(name="condicionOrden")
	private List<String> condicionesOrden = new ArrayList<String>();
	
	@ElementCollection
	@CollectionTable(name="condicionesFiltro", joinColumns=@JoinColumn(name = "idMetodologia", referencedColumnName = "id"))
	@Column(name="condicionFiltro")
	private List<String> condicionesFiltro = new ArrayList<String>();
	
	public List<String> getCondicionesOrden() {
		return condicionesOrden;
	}

	public void setCondicionesOrden(List<String> condicionesOrden) {
		this.condicionesOrden = condicionesOrden;
	}

	public List<String> getCondicionesFiltro() {
		return condicionesFiltro;
	}

	public void setCondicionesFiltro(List<String> condicionesFiltro) {
		this.condicionesFiltro = condicionesFiltro;
	}

	public String getNombre() {
		return nombre;
	}
	
	public List<Empresa> aplicarCondicionesFiltro(List<Empresa> empresas) throws Exception {
		List<Empresa> empresasFiltradas = empresas;
		for(int i = 0; i < condicionesFiltro.size(); i++) {
			CondicionFiltro condicionBuscada = Listas.buscarCondicionFiltroEn(App.condicionesFiltro, condicionesFiltro.get(i));
			if(condicionBuscada == null) {
				throw new Exception("No se pudo encontrar la condición " + condicionesFiltro.get(i));
			}
			empresasFiltradas = condicionBuscada.filtrar(empresasFiltradas);
		}
		return empresasFiltradas;
	}
	
	public void aplicarCondicionesDeOrden(List<Empresa> empresas) throws Exception {
		Rentabilidad.inicializarRentabilidad(empresas);
		for(int i = 0; i < condicionesOrden.size(); i++) {
			CondicionOrden condicionBuscada = Listas.buscarCondicionOrdenEn(App.condicionesOrden, condicionesOrden.get(i));
			if(condicionBuscada == null) {
				throw new Exception("No se pudo encontrar la condición " + condicionesFiltro.get(i));
			}
			condicionBuscada.evaluar(empresas);
		}
		Collections.sort(empresas);
	}
	
	public List<Empresa> aplicarMetodologiaATodas(List<Empresa> empresas) throws Exception{
		
		List<Empresa> empresasFiltradas = aplicarCondicionesFiltro(empresas);
		aplicarCondicionesDeOrden(empresasFiltradas);
		
		PrintEmpresas.imprimirResultado(empresasFiltradas);
		return empresasFiltradas;
		
	}
	
	public void agregarCondicionFiltro(CondicionFiltro condicion) {
		condicionesFiltro.add(condicion.getNombreCondicion());
	}
	
	public void agregarCondicionOrden(CondicionOrden condicion) {
		condicionesOrden.add(condicion.getNombreCondicion());
	}
	
	public void setNombre(String _nombre) {
		nombre = _nombre;
	}
	
	
}
