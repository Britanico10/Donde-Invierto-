package com.grupo4.inversiones.tools;
import com.grupo4.inversiones.repositorio.Repositorio;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Indicador;

public class CargadorDeBaseDeDatos {
	public static void guardarIndicador(List<Indicador> indicadores){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
    	Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
		repositorio.indicadores().persistir(indicadores.get(indicadores.size()-1));
}
}