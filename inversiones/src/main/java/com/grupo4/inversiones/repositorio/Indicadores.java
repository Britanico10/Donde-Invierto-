package com.grupo4.inversiones.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grupo4.inversiones.entidades.Indicador;

public class Indicadores extends Repositorio {
	public Indicadores(EntityManager em) {
		super(em);
	}
	
	   public Indicador buscarPorId(Long id){   
		   return em.find(Indicador.class, id);
	   }
	   
	   public Indicador buscarPorNombre(String nombre){
		   Query query = em.createQuery("SELECT i FROM Indicador i WHERE i.idIndicador = :nombre").setParameter("nombre", nombre);
		   List<Indicador> resultados = query.getResultList();
		   if (resultados.size() == 0) return null;
		   return (Indicador) resultados.get(0);
	   }
	   
	   public void borrarPorId(Long id){   
		   em.getTransaction().begin();
		   em.remove(buscarPorId(id));
		   em.getTransaction().commit();
	   }
	   
	   public void modificarPorId(Long id, String nuevaFormula) {
		   em.getTransaction().begin();
		   Indicador indicador = buscarPorId(id);
		   indicador.setformula(nuevaFormula);
		   em.getTransaction().commit();
	   }
	   
	   public List<Indicador> buscarTodas(long idUsuario){
		   Query query = em.createQuery("SELECT i FROM Indicador i WHERE i.duenio = :idUsuario").setParameter("idUsuario", idUsuario);
		   List<Indicador> indicadores = query.getResultList();
		   return indicadores;
	   }
	   
	   public void persistir(Indicador indicador){
		   em.getTransaction().begin();
		   em.persist(indicador);
		   em.getTransaction().commit();
	   }

	   public long buscarDuenio(long id) {
		   return em.find(Indicador.class, id).getDuenio();
	   }
}
