package com.grupo4.inversiones.tools;

import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Analizador;

public class CreadorIndicadores {
	
	public static void crearIndicador(List<Indicador> indicadores){
		
		Indicador nuevoIndicador;
		
		System.out.println("Ingrese el nombre del indicador.");
    	Scanner scc = new Scanner(System.in);
    	scc.useDelimiter("[:\\s]");
    	String nombreIndicador = scc.nextLine();
    	
    	System.out.println("Ingrese la formula del indicador.");
    	Scanner sc = new Scanner(System.in);
    	sc.useDelimiter("[:\\s]");
    	String formula = sc.nextLine();
    	
    	if (Analizador.evaluar(formula) != null){
    		nuevoIndicador = new Indicador(nombreIndicador,formula);
    		indicadores.add(nuevoIndicador);
    		System.out.println("Indicador guardado.");
    	}
		
	}

}
