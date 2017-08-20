package com.grupo4.inversiones.entidades.condiciones;

import java.util.ArrayList;
import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class ConsistenciaDecreciente extends CondicionFiltro {
	
	public ConsistenciaDecreciente(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, Indicador _indicador) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _indicador, 0);
	}
	
	@Override
	public List<Empresa> filtrar(List<Empresa> empresas){
		
		List<Empresa> filtradas = new ArrayList<Empresa>();
		Boolean tieneDesnivel = false;
		
		for(int i = 0; i < empresas.size(); i++) {
			
			List<Double> indicadoresAplicados = indicador.aplicarEnIntervalo(empresas.get(i), inicioIntervalo, finalIntervalo);
			for (int j = 0; j < indicadoresAplicados.size(); j++) {
				if(j >= j-1) tieneDesnivel = true;
			}
			
			
			if (!tieneDesnivel) {
				filtradas.add(empresas.get(i));
			}
		}
		
		return filtradas;
		
	}

}
