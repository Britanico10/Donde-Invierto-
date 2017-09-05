package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Listas;

@Entity
@Table(name = "Maximizar")
public class Maximizar extends CondicionOrden {
	
	public Maximizar(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, String _nombreIndicador, int _importancia) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _nombreIndicador, 0, _importancia);
		tipo = "Maximizar";
	}
	
	@Override
	public void ordenarPorIndicador(List<Empresa> empresas) {
		
		Indicador indicador = Listas.buscarIndicadorEn(App.indicadores,nombreIndicador);
		
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
