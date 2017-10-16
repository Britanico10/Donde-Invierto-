package com.grupo4.inversiones.entidades.condiciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

@Entity
public class FiltroMayor extends CondicionFiltro {

	private static final long serialVersionUID = 1L;

	public FiltroMayor(String _nombreCondicion, String _nombreIndicador, int _periodo, int _comparador) {
		super(_nombreCondicion, 0, 0, _nombreIndicador, _periodo, _comparador);
		tipo = "FiltroMayor";
	}
	
	public FiltroMayor() {
	}
	
	@Override
	public List<Empresa> filtrar(List<Empresa> empresas){
		
		String PERSISTENCE_UNIT_NAME = "db";
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
		
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombreIndicador);
		
		List<Empresa> filtradas = new ArrayList<Empresa>();
		
		for(int i = 0; i < empresas.size(); i++) {
			if (indicador.aplicarA(empresas.get(i),periodo) > comparador) {
				filtradas.add(empresas.get(i));
			}
		}
		return filtradas;
	}

}
