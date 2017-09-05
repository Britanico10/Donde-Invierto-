package com.grupo4.inversiones.entidades.condiciones;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class CondicionFiltro extends Condicion {
	
	int comparador;
	
	public CondicionFiltro(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, String _indicador, int _periodo, int _comparador) {
		super(_nombreCondicion, _inicioIntervalo, _finalIntervalo, _indicador, _periodo);
		comparador = _comparador;
	}
	
	public List<Empresa> filtrar(List<Empresa> empresas){
		return empresas;
		}

	public int getComparador() {
		return comparador;
	}

	public void setComparador(int comparador) {
		this.comparador = comparador;
	}
	
}
