package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

@Entity
public class OrdenMenor extends CondicionOrden {

	private static final long serialVersionUID = 1L;

	public OrdenMenor(String _nombreCondicion, String _nombreIndicador, int _periodo, int _importancia) {
		super(_nombreCondicion, 0, 0,_nombreIndicador, _periodo, _importancia);
		tipo = "OrdenMenor";
	}
	
	public OrdenMenor() {
	}
	
	@Override
	public void ordenarPorIndicador(List<Empresa> empresas) {
		
		String PERSISTENCE_UNIT_NAME = "db";
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
		
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombreIndicador);
		
		Empresa aux;
		for(int i = 0; i < empresas.size(); i++) {
			for(int j = 0; j < empresas.size(); j++) {
				if (indicador.aplicarA(empresas.get(i), periodo) >
						indicador.aplicarA(empresas.get(j), periodo)) {
					aux = empresas.get(i);
					empresas.set(i, empresas.get(j));
					empresas.set(j, aux);
				}
			}
		}
	}

}
