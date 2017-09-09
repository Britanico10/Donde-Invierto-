package com.grupo4.inversiones.repositorio;

import javax.persistence.EntityManager;

import com.grupo4.inversiones.entidades.Indicador;

public class Indicadores extends Repositorio {
	public Indicadores(EntityManager em) {
		super(em);
	}
	
	   public Indicador buscarPorId(Long id){   
		   return em.find(Indicador.class, id);
	   }
	   public void persistir(Indicador indicador){
		   em.getTransaction().begin();
		   em.persist(indicador);
		   em.getTransaction().commit();
	   }
}
