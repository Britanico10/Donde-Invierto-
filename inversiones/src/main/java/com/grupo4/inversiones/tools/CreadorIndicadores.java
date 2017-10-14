package com.grupo4.inversiones.tools;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Analizador;

public class CreadorIndicadores {
	
	public static void crearIndicador(List<Indicador> indicadores) throws IOException{
		
		Indicador nuevoIndicador;
		
		System.out.println("Ingrese el nombre del indicador.");
    	Scanner sc = new Scanner(System.in);
    	sc.useDelimiter("[:\\s]");
    	String nombreIndicador = sc.nextLine();
    	
    	System.out.println("Ingrese la formula del indicador.");
    	String formula = sc.nextLine();
    	
    	if (Analizador.evaluar(formula) != null){
    		nuevoIndicador = new Indicador(nombreIndicador,formula);
    		indicadores.add(nuevoIndicador);
    		System.out.println("Indicador guardado.");
    		//System.out.println(Analizador.evaluar(formula));
    		Analizador.evaluar(formula);
    	}
    	
    	CargadorDeBaseDeDatos.guardarIndicador(indicadores);
		//cargadorDeArchivos.guardarIndicadores("src/main/indicadores.txt", indicadores);

	}

}
