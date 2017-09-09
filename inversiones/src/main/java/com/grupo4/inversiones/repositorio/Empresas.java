package com.grupo4.inversiones.repositorio;

import javax.persistence.EntityManager;

import com.grupo4.inversiones.entidades.Empresa;

public class Empresas extends Repositorio {
	public Empresas(EntityManager em) {
		super(em);
	}
	
	   public Empresa buscarPorId(Long id){   
		   return em.find(Empresa.class, id);
	   }
	   public void persistir(Empresa empresa){
		   em.getTransaction().begin();
		   em.persist(empresa);
		   em.getTransaction().commit();
	   }
}