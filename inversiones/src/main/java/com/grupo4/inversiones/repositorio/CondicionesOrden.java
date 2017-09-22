package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;

public class CondicionesOrden extends Repositorio {

	public CondicionesOrden(EntityManager em) {
		super(em);
	}
	
	   public CondicionOrden buscarPorId(Long id){   
		   return em.find(CondicionOrden.class, id);
	   }
	   
	   public List<CondicionOrden> buscarTodas(){
		   Query query = em.createQuery("SELECT c FROM CondicionOrden c");
		   List<CondicionOrden> condiciones = query.getResultList();
		   return condiciones;
	   }
	   
	   public void persistir(CondicionOrden condicion){
		   em.getTransaction().begin();
		   em.persist(condicion);
		   em.getTransaction().commit();
	   }
	
}
