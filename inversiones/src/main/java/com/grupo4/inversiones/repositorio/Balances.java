package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;

public class Balances extends Repositorio {
	public Balances(EntityManager em) {
		super(em);
	}
	
	   public Balance buscarPorId(Long id){   
		   return em.find(Balance.class, id);
	   }
	   public void persistir(Balance balance){
		   em.getTransaction().begin();
		   em.persist(balance);
		   em.getTransaction().commit();
	   }

	public List<Balance> getBalances(long idEmpresa) {
		Query queryBalance = em.createNamedQuery("buscarBalances").setParameter("empresaID", idEmpresa);
		return queryBalance.getResultList();
	}

	public List<Balance> eliminarBalance(long id) {
		em.getTransaction().begin();
		Balance balance = buscarPorId(id);
		if(balance == null) {
			em.getTransaction().commit();
			return null;
		}
		long idEmpresa = balance.getIdEmpresa();
		em.remove(balance);
		em.getTransaction().commit();
		return getBalances(idEmpresa);
	}

	public void modificarBalance(long id, int capitalPropio, int deuda, int ebitda, int fCashFlow, int fds,
			int ingNetoOpCont, int ingNetoOpDiscont, int periodo, long idEmpresa) {
		em.getTransaction().begin();
		Balance balance = buscarPorId(id);
		if(capitalPropio != -1) balance.setCapitalPropio(capitalPropio);
		if(deuda != -1) balance.setDeuda(deuda);
		if(ebitda != -1) balance.setEbitda(ebitda);
		if(fCashFlow != -1) balance.setfCashFlow(fCashFlow);
		if(fds != -1) balance.setFds(fds);
		if(ingNetoOpCont != -1) balance.setIngNetoOpCont(ingNetoOpCont);
		if(ingNetoOpDiscont != -1) balance.setIngNetoOpDiscont(ingNetoOpDiscont);
		em.getTransaction().commit();
	}
}