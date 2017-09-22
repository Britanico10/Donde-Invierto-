package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.Metodologia;

public class Metodologias extends Repositorio{
	
	public Metodologias(EntityManager em) {
		super(em);
	}
	
	   public Metodologia buscarPorId(Long id){   
		   return em.find(Metodologia.class, id);
	   }
	   
	   public List<Metodologia> buscarTodas(){
		   Query query = em.createQuery("SELECT m FROM Metodologia m");
		   List<Metodologia> metodologias = query.getResultList();
		   return metodologias;
	   }
	   
	   public void persistir(Metodologia metodologia){
		   em.getTransaction().begin();
		   em.persist(metodologia);
		   em.getTransaction().commit();
	   }
}
