package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Listas;

//@Entity
//@Table(name = "OrdenMenor")
public class OrdenMenor extends CondicionOrden {
	
	public OrdenMenor(String _nombreCondicion, String _nombreIndicador, int _periodo, int _importancia) {
		super(_nombreCondicion, 0, 0,_nombreIndicador, _periodo, _importancia);
		tipo = "OrdenMenor";
	}
	
	@Override
	public void ordenarPorIndicador(List<Empresa> empresas) {
		
		Indicador indicador = Listas.buscarIndicadorEn(App.indicadores,nombreIndicador);
		
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
