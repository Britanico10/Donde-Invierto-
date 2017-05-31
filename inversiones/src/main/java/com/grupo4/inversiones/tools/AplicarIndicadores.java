package com.grupo4.inversiones.tools;

import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class AplicarIndicadores {
	
	public static void aplicarIndicadores(Empresa empresa, List<Indicador> indicadores){
		for (int i = 0; i <= indicadores.size() - 1; i++){
			System.out.println(indicadores.get(i).getIdIndicador()
					+": "
					+ indicadores.get(i).getformula()
					+ " = "
					+ indicadores.get(i).aplicarA(empresa));
		}
		System.out.println(" ");
	}

}
