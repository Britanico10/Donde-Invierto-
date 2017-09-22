package com.grupo4.inversiones.tools;
import com.grupo4.inversiones.repositorio.Repositorio;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;

public class CargadorDeBaseDeDatos {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	public static void guardarIndicador(List<Indicador> indicadores){
		repositorio.indicadores().persistir(indicadores.get(indicadores.size()-1));
	}
	
	public static void guardarCondicionOrden(List<CondicionOrden> condiciones){
		repositorio.condicionesOrden().persistir(condiciones.get(condiciones.size()-1));
	}
	
	public static void guardarCondicionFiltro(List<CondicionFiltro> condiciones){
		repositorio.condicionesFiltro().persistir(condiciones.get(condiciones.size()-1));
	}
}