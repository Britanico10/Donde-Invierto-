package com.grupo4.inversiones.entidades.condiciones;

import java.util.ArrayList;
import java.util.List;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class FiltroMayor extends CondicionFiltro {
	
	int comparador;
	
	public FiltroMayor(String _nombreCondicion, Indicador _indicador, int _periodo, int _comparador) {
		super(_nombreCondicion, 0, 0, _indicador, _periodo);
		comparador = _comparador;
	}
	
	@Override
	public List<Empresa> filtrar(List<Empresa> empresas){
		
		List<Empresa> filtradas = new ArrayList<Empresa>();
		
		for(int i = 0; i < empresas.size(); i++) {
			if (indicador.aplicarA(empresas.get(i),periodo) > comparador) {
				filtradas.add(empresas.get(i));
			}
		}
		return filtradas;
	}

}
