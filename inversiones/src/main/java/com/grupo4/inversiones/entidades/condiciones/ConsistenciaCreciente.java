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
public class ConsistenciaCreciente extends CondicionFiltro {

	private static final long serialVersionUID = 1L;

	public ConsistenciaCreciente(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, String _nombreIndicador) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _nombreIndicador, 0, 0);
		tipo = "ConsistenciaCreciente";
	}
	
	public ConsistenciaCreciente() {
	}
	
	@Override
	public List<Empresa> filtrar(List<Empresa> empresas){
		
		String PERSISTENCE_UNIT_NAME = "db";
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
		
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombreIndicador);
		
		List<Empresa> filtradas = new ArrayList<Empresa>();
		Boolean tieneDesnivel = false;
		
		for(int i = 0; i < empresas.size(); i++) {
			
			List<Double> indicadoresAplicados = indicador.aplicarEnIntervalo(empresas.get(i), inicioIntervalo, finalIntervalo);
			for (int j = 0; j < indicadoresAplicados.size(); j++) {
				if(j <= j-1) tieneDesnivel = true;
			}
			
			
			if (!tieneDesnivel) {
				filtradas.add(empresas.get(i));
			}
		}
		
		return filtradas;
		
	}

}
