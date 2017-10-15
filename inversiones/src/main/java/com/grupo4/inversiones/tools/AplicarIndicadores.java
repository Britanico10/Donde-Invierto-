package com.grupo4.inversiones.tools;

import java.util.Calendar;
import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class AplicarIndicadores {
	
	static Calendar cal = Calendar.getInstance(); 
	static int anio = cal.get(Calendar.YEAR);
	
	public static String aplicarIndicadores(Empresa empresa, int periodo, List<Indicador> indicadores){
		final String nuevalinea = System.getProperty("line.separator");
		String resultado = "";
		for (int i = 0; i <= indicadores.size() - 1; i++){
			resultado = resultado + indicadores.get(i).getIdIndicador()
					+": "
					+ indicadores.get(i).getformula()
					+ " = "
					+ indicadores.get(i).aplicarA(empresa, periodo)
					+ nuevalinea;
		}
		return resultado;
	
	}
	
	public static void aplicarIndicadoresVoid(Empresa empresa, int periodo, List<Indicador> indicadores){
		for (int i = 0; i <= indicadores.size() - 1; i++){
			System.out.println(indicadores.get(i).getIdIndicador()
					+": "
					+ indicadores.get(i).getformula()
					+ " = "
					+ indicadores.get(i).aplicarA(empresa, periodo));
		}
		System.out.println(" ");
	}
	
	public static double aplicarIndicador(String nombre, Empresa empresa, int periodo){
		return Listas.buscarIndicadorEn(App.indicadores, nombre).aplicarA(empresa,periodo);
	}
	
	public static double promedioIndicadorEnLapso(String nombre, Empresa empresa, int lapso){
		double n = 0;
		for (int i = anio-1; i > (anio-1 - lapso); i--){
			n = aplicarIndicador(nombre,empresa,i);
	    	}
		return n/lapso;
	}
	
	public static Boolean indicadorEsConsistente(String nombre, Empresa empresa, int lapso){
		double val = 1;
		for (int i = anio-1; i > (anio-1 - lapso); i--){
			val = val * aplicarIndicador(nombre, empresa, i);
	    	}
		return val > 0;
	}

}
