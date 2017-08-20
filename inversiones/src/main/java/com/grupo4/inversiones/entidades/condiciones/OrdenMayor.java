package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class OrdenMayor extends CondicionOrden {
	
	public OrdenMayor(String _nombreCondicion, Indicador _indicador, int _periodo, int _importancia) {
		super(_nombreCondicion, 0, 0, _indicador, _periodo, _importancia);
	}

	@Override
	public void ordenarPorIndicador(List<Empresa> empresas) {
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
