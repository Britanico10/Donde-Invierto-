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
		   return empresa;
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
//			long empresaID = empresa.getId();
//			Query queryBalance = em.createNamedQuery("buscarBalances").setParameter("empresaID", empresaID);
//			List<Balance> balances = queryBalance.getResultList();
//			empresa.setBalances(balances);
			return empresa;
		}

		public void modificarEmpresa(long id, String nuevoNombre, int año) {
			em.getTransaction().begin();
			Empresa empresa = buscarPorId(id);
			if (nuevoNombre != "nada") empresa.setNombre(nuevoNombre);
			if (año != 0) empresa.setInicioActividad(año);
			em.getTransaction().commit();
		}

		public void eliminarEmpresa(long id) {
			em.getTransaction().begin();
			Empresa empresa = buscarPorId(id);
			if(empresa == null) {
				em.getTransaction().commit();
				return;
			}
			Query queryBalance = em.createNamedQuery("buscarBalances").setParameter("empresaID", id);
			List<Balance> balances = queryBalance.getResultList();
			for(Balance b: balances) {
				em.remove(b);
			}
			em.getTransaction().commit();
			em.getTransaction().begin();
			em.remove(empresa);
			em.getTransaction().commit();
		}

}