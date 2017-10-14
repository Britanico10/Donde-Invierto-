package com.grupo4.inversiones.servicios;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.grupo4.inversiones.tools.inicializadorGlobal;

public class Servicios {
	
	private static Servicios instancia = null;
	private EmpresaServicio empresaServicio;
	private IndicadorServicio indicadorServicio;
	private MetodologiaServicio metodologiaServicio;
	private CondicionOrdenServicio condicionOrdenServicio;
	private CondicionFiltroServicio condicionFiltroServicio;
	
	private Servicios() {
	}
	
	public static Servicios getInstance(){
		if (instancia == null) {
			instancia = new Servicios();
			
			try {
				inicializadorGlobal.inicializar();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return instancia;
	}
	
	public void crearEmpresaServicio() {
		empresaServicio = new EmpresaServicio();
	}
	
	public EmpresaServicio getEmpresaServicio() {
		
		if (empresaServicio == null) {
			crearEmpresaServicio();
		}
		
		return empresaServicio;
	}
	
	public void crearIndicadorServicio() {
		indicadorServicio = new IndicadorServicio();
	}
	
	public IndicadorServicio getIndicadorServicio() {
		
		if (indicadorServicio == null) {
			crearIndicadorServicio();
		}
		
		return indicadorServicio;
	}

	public void crearMetodologiaServicio() {
		metodologiaServicio = new MetodologiaServicio();
	}
	
	public MetodologiaServicio getMetodologiaServicio() {
		
		if (metodologiaServicio == null) {
			crearMetodologiaServicio();
		}
		
		return metodologiaServicio;
	}
	
	public void crearCondicionOrdenServicio() {
		condicionOrdenServicio = new CondicionOrdenServicio();
	}
	
	public CondicionOrdenServicio getCondicionOrdenServicio() {
		
		if (condicionOrdenServicio == null) {
			crearCondicionOrdenServicio();
		}
		
		return condicionOrdenServicio;
	}
	
	public void crearCondicionFiltroServicio() {
		condicionFiltroServicio = new CondicionFiltroServicio();
	}
	
	public CondicionFiltroServicio getCondicionFiltroServicio() {
		
		if (condicionFiltroServicio == null) {
			crearCondicionFiltroServicio();
		}
		
		return condicionFiltroServicio;
	}
	
	
}
