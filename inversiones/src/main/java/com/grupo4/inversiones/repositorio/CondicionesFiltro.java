package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;

public class CondicionesFiltro extends Repositorio {

	public CondicionesFiltro(EntityManager em) {
		super(em);
	}
	
	   public CondicionesFiltro buscarPorId(Long id){   
		   return em.find(CondicionesFiltro.class, id);
	   }
	   
	   public List<CondicionFiltro> buscarTodas(){
		   Query query = em.createQuery("SELECT c FROM CondicionFiltro c");
		   List<CondicionFiltro> condiciones = query.getResultList();
		   return condiciones;
	   }
	   
	   public void persistir(CondicionFiltro condicion){
		   em.getTransaction().begin();
		   em.persist(condicion);
		   em.getTransaction().commit();
	   }
	
}
