package com.grupo4.inversiones.tools;

import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.entidades.condiciones.Maximizar;
import com.grupo4.inversiones.entidades.condiciones.Minimizar;
import com.grupo4.inversiones.entidades.condiciones.OrdenMayor;
import com.grupo4.inversiones.entidades.condiciones.OrdenMenor;

public class CreadorCondicionesOrden {
	
	public static void crearCondicionOrden(List<CondicionOrden> condiciones){
			
			CondicionOrden nuevaCondicionOrden = null;
			int inicioIntervalo;
	    	int finalIntervalo;
	    	int periodo;
	    	int importancia;
			
	    	Scanner sc = new Scanner(System.in);
	    	sc.useDelimiter("[:\\s]");
	    	System.out.println("Ingrese el nombre de la condición.");
	    	String nombreCondicion = sc.nextLine();
	    	
	    	Indicador indicador = null;
	    	String nombreIndicador = null;
	    	
	    	while (indicador == null) {
	        	System.out.println("Ingrese el indicador utilizado en la condición.");
	        	nombreIndicador = sc.nextLine();
	    		indicador = Listas.buscarIndicadorEn(App.indicadores,nombreIndicador);
	    		if (indicador == null) {
	    			System.out.println("Indicador no válido.");
	    		}
	    	}
	    	
			System.out.println("Ingrese importancia de la condicion para ponderar.");
			importancia = Integer.parseInt(sc.nextLine());
	    	
	    	System.out.println("Indique que tipo de condición desea.");
	    	System.out.println("1. Maximizar.");
	    	System.out.println("2. Minimizar.");
	    	System.out.println("3. Mayor que.");
	    	System.out.println("4. Menor que.");
	    	
	    	int opcionElegida = Integer.parseInt(sc.nextLine());
	    	switch(opcionElegida){
	    	case 1:
	    		System.out.println("Indique inicio del intervalo.");
	    		inicioIntervalo = Integer.parseInt(sc.nextLine());
	    		System.out.println("Indique final del intervalo");
	    		finalIntervalo = Integer.parseInt(sc.nextLine());
	    		nuevaCondicionOrden = new Maximizar(nombreCondicion, inicioIntervalo, finalIntervalo, nombreIndicador, importancia);
	    		break;
	    	case 2:
	    		System.out.println("Indique inicio del intervalo.");
	    		inicioIntervalo = Integer.parseInt(sc.nextLine());
	    		System.out.println("Indique final del intervalo");
	    		finalIntervalo = Integer.parseInt(sc.nextLine());
	    		nuevaCondicionOrden = new Minimizar(nombreCondicion, inicioIntervalo, finalIntervalo, nombreIndicador, importancia);
	    		break;
	    	case 3:
	    		System.out.println("Indique el periodo.");
	    		periodo = Integer.parseInt(sc.nextLine());
	    		nuevaCondicionOrden = new OrdenMayor(nombreCondicion, nombreIndicador, periodo, importancia);
	    		break;
	    	case 4:
	    		System.out.println("Indique el periodo.");
	    		periodo = Integer.parseInt(sc.nextLine());
	    		nuevaCondicionOrden = new OrdenMenor(nombreCondicion, nombreIndicador, periodo, importancia);
	    		break;
	    	default:
	    		System.out.println("Opción no válida.");
	    		return;
	    	
	    	}
	    	
	    	condiciones.add(nuevaCondicionOrden);
	    	CargadorDeBaseDeDatos.guardarCondicionOrden(nuevaCondicionOrden);
	    	
		}

}
