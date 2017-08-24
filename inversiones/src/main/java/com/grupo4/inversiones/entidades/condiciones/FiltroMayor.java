package com.grupo4.inversiones.entidades.condiciones;

import java.util.ArrayList;
import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Listas;

public class FiltroMayor extends CondicionFiltro {
	
	public FiltroMayor(String _nombreCondicion, String _nombreIndicador, int _periodo, int _comparador) {
		super(_nombreCondicion, 0, 0, _nombreIndicador, _periodo, _comparador);
		
	}
	
	@Override
	public List<Empresa> filtrar(List<Empresa> empresas){
		
		Indicador indicador = Listas.buscarIndicadorEn(App.indicadores,nombreIndicador);
		
		List<Empresa> filtradas = new ArrayList<Empresa>();
		
		for(int i = 0; i < empresas.size(); i++) {
			if (indicador.aplicarA(empresas.get(i),periodo) > comparador) {
				filtradas.add(empresas.get(i));
			}
		}
		return filtradas;
	}

}
