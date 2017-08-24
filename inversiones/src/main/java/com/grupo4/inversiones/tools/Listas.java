package com.grupo4.inversiones.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.condiciones.Condicion;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;

public class Listas {
	
	public static Indicador buscarIndicadorEn(List<Indicador> indicadores, String nombreIndicador){
		    Optional<Indicador> indicador = indicadores.stream()
		        .filter(p -> p.getIdIndicador().equals(nombreIndicador))
		        .findFirst();
		    return indicador.isPresent() ? indicador.get() : null;
	}
	
	public static Balance buscarCuentaEn(List<Balance> balances,int periodo){
	    Optional<Balance> balance = balances.stream()
	        .filter(p -> p.getPeriodo() == periodo)
	        .findFirst();
	    return balance.isPresent() ? balance.get() : null;
	}
	
	public static CondicionFiltro buscarCondicionFiltroEn(List<CondicionFiltro> condiciones,String nombre){
	    Optional<CondicionFiltro> condicion = condiciones.stream()
	        .filter(p -> p.getNombreCondicion() == nombre)
	        .findFirst();
	    return condicion.isPresent() ? condicion.get() : null;
	}
	
	public static CondicionOrden buscarCondicionOrdenEn(List<CondicionOrden> condiciones,String nombre){
	    Optional<CondicionOrden> condicion = condiciones.stream()
	        .filter(p -> p.getNombreCondicion() == nombre)
	        .findFirst();
	    return condicion.isPresent() ? condicion.get() : null;
	}
	
	public static void sacarDeLista(Object obj, List<Object> lista){
		int pos = lista.indexOf(obj);
		lista.remove(pos);
	}
	
	public static List copiarLista(List lista){
		List nuevaLista = new ArrayList();
		for(int i = 0; i < lista.size(); i++) {
			nuevaLista.add(lista.get(i));
		}
		return nuevaLista;
	}

}
