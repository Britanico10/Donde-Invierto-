package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;

public class Empresas extends Repositorio {
	public Empresas(EntityManager em) {
		super(em);
	}
	
	   public Empresa buscarPorId(Long id){   
		   Empresa empresa = em.find(Empresa.class, id);
		   if (empresa != null) {
			   long empresaID = empresa.getId();
			   Query query = em.createNamedQuery("buscarBalances").setParameter("empresaID", empresaID);
			   List<Balance> balances = query.getResultList();
			   empresa.setBalances(balances);
		   }
		   return empresa;
	   }
	   
	   public void persistirLista(List<Empresa> empresas) {
		   for(Empresa emp: empresas) {
			   persistir(emp);
		   }
	   }
	   
	   public void borrarTodas() {
		   Query query2 = em.createQuery("SELECT b FROM Balance b");
		   List<Balance> balances = query2.getResultList();
		   em.getTransaction().begin();
		   for(Balance b: balances) {
			   em.remove(b);
		   }
		   em.getTransaction().commit();
		   em.getTransaction().begin();
		   Query query = em.createQuery("SELECT e FROM Empresa e");
		   List<Empresa> empresas = query.getResultList();
		   for(Empresa emp: empresas) {
			   em.remove(emp);
		   }
		   em.getTransaction().commit();

	   }
	   
	   public List<Empresa> buscarTodas(){
		   EntityManager em2 = App.EM_FACTORY.createEntityManager();
		   Query query = em2.createQuery("SELECT e FROM Empresa e");
		   List<Empresa> empresas = query.getResultList();
		   return empresas;
	   }
	   
	   public void persistir(Empresa empresa){
		   em.getTransaction().begin();
		   em.merge(empresa);
		   em.getTransaction().commit();
	   }

		public Empresa buscarPorNombre(String nombre) {
			Query query = em.createQuery("SELECT e FROM Empresa e WHERE e.nombre = :nombre").setParameter("nombre", nombre);
			List<Empresa> resultados = query.getResultList();
			if (resultados.size() == 0) return null;
			Empresa empresa = (Empresa) resultados.get(0);
			long empresaID = empresa.getId();
			Query queryBalance = em.createNamedQuery("buscarBalances").setParameter("empresaID", empresaID);
			List<Balance> balances = queryBalance.getResultList();
			empresa.setBalances(balances);
			return empresa;
		}
}