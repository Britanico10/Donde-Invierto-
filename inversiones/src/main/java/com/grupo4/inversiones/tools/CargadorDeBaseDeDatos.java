package com.grupo4.inversiones.tools;
import com.grupo4.inversiones.repositorio.Repositorio;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;

public class CargadorDeBaseDeDatos {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	public static void guardarIndicador(Indicador indicador){
		repositorio.indicadores().persistir(indicador);
	}
	
	public static void guardarCondicionOrden(CondicionOrden condicion){
		repositorio.condicionesOrden().persistir(condicion);
	}
	
	public static void guardarCondicionFiltro(CondicionFiltro condicion){
		repositorio.condicionesFiltro().persistir(condicion);
	}
	
	public static void guardarMetodologia(Metodologia metodologia){
		repositorio.metodologias().persistir(metodologia);
	}
}