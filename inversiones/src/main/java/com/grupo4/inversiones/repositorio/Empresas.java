package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;

public class Empresas extends Repositorio {
	public Empresas(EntityManager em) {
		super(em);
	}
	
	   public Empresa buscarPorId(Long id){   
		   Empresa empresa = em.find(Empresa.class, id);
		   long empresaID = empresa.getId();
		   Query query = em.createNamedQuery("buscarBalances").setParameter("empresaID", empresaID);
		   List<Balance> balances = query.getResultList();
		   empresa.setBalances(balances);
		   return empresa;
	   }
	   
	   public List<Empresa> buscarTodas(){
		   Query query = em.createQuery("SELECT e FROM Empresa e");
		   List<Empresa> empresas = query.getResultList();
		   for(Empresa emp: empresas) {
			   long empresaID = emp.getId();
			   Query queryBalances = em.createNamedQuery("buscarBalances").setParameter("empresaID", empresaID);
			   List<Balance> balances = queryBalances.getResultList();
			   emp.setBalances(balances);
		   }
		   return empresas;
	   }
	   
	   public void persistir(Empresa empresa){
		   em.getTransaction().begin();
		   em.persist(empresa);
		   em.getTransaction().commit();
	   }
}