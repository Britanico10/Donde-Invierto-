package com.grupo4.inversiones.tools;

import java.util.List;

import com.grupo4.inversiones.entidades.Indicador;

public class EditarIndicador {
	
	public static void editarIndicador(List<Indicador> indicadores,String nombre, String nuevaFormula){
		Indicador indicador = Listas.buscarIndicadorEn(indicadores,nombre);
		if (Analizador.evaluar(nuevaFormula) != null){
			indicador.setformula(nuevaFormula);
		}
		else {
			System.out.println("Formula no válida.");
		}
	}

}
