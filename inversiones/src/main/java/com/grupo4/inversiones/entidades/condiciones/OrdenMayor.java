package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import javax.persistence.Entity;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

@Entity
public class OrdenMayor extends CondicionOrden {

	private static final long serialVersionUID = 1L;

	public OrdenMayor(String _nombreCondicion, String _nombreIndicador, int _periodo, int _importancia) {
		super(_nombreCondicion, 0, 0, _nombreIndicador, _periodo, _importancia);
		tipo = "OrdenMayor";
	}
	
	public OrdenMayor() {
	}

	@Override
	public void ordenarPorIndicador(List<Empresa> empresas) {

		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		
		Indicador indicador = repositorio.indicadores().buscarPorNombre(nombreIndicador);
		
		repositorio.cerrar();
		
		Empresa aux;
		for(int i = 0; i < empresas.size(); i++) {
			for(int j = 0; j < empresas.size(); j++) {
				if (indicador.aplicarA(empresas.get(i), periodo) <
						indicador.aplicarA(empresas.get(j), periodo)) {
					aux = empresas.get(i);
					empresas.set(i, empresas.get(j));
					empresas.set(j, aux);
				}
			}
		}
	}
		
}
