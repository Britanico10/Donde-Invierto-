package com.grupo4.inversiones.entidades.condiciones;

import java.util.ArrayList;
import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Listas;

public class ConsistenciaCreciente extends CondicionFiltro {
	
	public ConsistenciaCreciente(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, String _nombreIndicador) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _nombreIndicador, 0, 0);
		tipo = "ConsistenciaCreciente";
	}
	
	@Override
	public List<Empresa> filtrar(List<Empresa> empresas){
		
		Indicador indicador = Listas.buscarIndicadorEn(App.indicadores,nombreIndicador);
		
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
