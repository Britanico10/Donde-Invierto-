package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class Maximizar extends CondicionOrden {
	
	public Maximizar(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, Indicador _indicador, int _importancia) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _indicador, 0, _importancia);
	}
	
	@Override
	public void ordenarPorIndicador(List<Empresa> empresas) {
		Empresa aux;
		for(int i = 0; i < empresas.size(); i++) {
			for(int j = 0; j < empresas.size(); j++) {
				if (indicador.promedioEnIntervalo(empresas.get(i), inicioIntervalo, finalIntervalo) <
					indicador.promedioEnIntervalo(empresas.get(j), inicioIntervalo, finalIntervalo)) {
					aux = empresas.get(i);
					empresas.set(i, empresas.get(j));
					empresas.set(j, aux);
				}
			}
		}
	}
	
}
