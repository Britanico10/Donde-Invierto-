package com.grupo4.inversiones.repositorio;

import javax.persistence.EntityManager;

public class Repositorio {
	private Indicadores indicadores;
	private Balances balances;
	private Empresas empresas;
	protected EntityManager em; 
	  
	    public Repositorio(EntityManager em){
	    	this.em = em;
	    
	    }
	    
	    public Indicadores indicadores() {
	    	if (indicadores == null) {
	    		indicadores = new Indicadores(em);
	    	}
	    	return indicadores;
	    }
	    
	    public Balances balances() {
	    	if (balances == null) {
	    		balances = new Balances(em);
	    	}
	    	return balances;
	    }
	    
	    public Empresas empresas() {
	    	if (empresas == null) {
	    		empresas = new Empresas(em);
	    	}
	    	return empresas;
	    }
	    
	    public void cerrar() {
	    	em.close();
	    }
	    
}