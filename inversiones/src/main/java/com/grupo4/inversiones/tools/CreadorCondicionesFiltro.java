package com.grupo4.inversiones.tools;

import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.ConsistenciaCreciente;
import com.grupo4.inversiones.entidades.condiciones.ConsistenciaDecreciente;
import com.grupo4.inversiones.entidades.condiciones.FiltroMayor;
import com.grupo4.inversiones.entidades.condiciones.FiltroMenor;

public class CreadorCondicionesFiltro {
	
	public static void crearCondicionFiltro(List<CondicionFiltro> condiciones){
		
		CondicionFiltro nuevaCondicionFiltro = null;
		int inicioIntervalo;
    	int finalIntervalo;
    	int periodo;
    	int comparador;
		
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
    	
    	System.out.println("Indique que tipo de condición desea.");
    	System.out.println("1. Consistencia creciente.");
    	System.out.println("2. Consistencia decreciente.");
    	System.out.println("3. Mayor que.");
    	System.out.println("4. Menor que.");
    	
    	int opcionElegida = Integer.parseInt(sc.nextLine());
    	switch(opcionElegida){
    	case 1:
    		System.out.println("Indique inicio del intervalo.");
    		inicioIntervalo = Integer.parseInt(sc.nextLine());
    		System.out.println("Indique final del intervalo");
    		finalIntervalo = Integer.parseInt(sc.nextLine());
    		nuevaCondicionFiltro = new ConsistenciaCreciente(nombreCondicion, inicioIntervalo, finalIntervalo, nombreIndicador);
    		break;
    	case 2:
    		System.out.println("Indique inicio del intervalo.");
    		inicioIntervalo = Integer.parseInt(sc.nextLine());
    		System.out.println("Indique final del intervalo");
    		finalIntervalo = Integer.parseInt(sc.nextLine());
    		nuevaCondicionFiltro = new ConsistenciaDecreciente(nombreCondicion, inicioIntervalo, finalIntervalo, nombreIndicador);
    		break;
    	case 3:
    		System.out.println("Indique el periodo.");
    		periodo = Integer.parseInt(sc.nextLine());
    		System.out.println("Ingrese a que numero desea comparar.");
    		comparador = Integer.parseInt(sc.nextLine());
    		nuevaCondicionFiltro = new FiltroMayor(nombreCondicion, nombreIndicador, periodo, comparador);
    		break;
    	case 4:
    		System.out.println("Indique el periodo.");
    		periodo = Integer.parseInt(sc.nextLine());
    		System.out.println("Ingrese a que numero desea comparar.");
    		comparador = Integer.parseInt(sc.nextLine());
    		nuevaCondicionFiltro = new FiltroMenor(nombreCondicion, nombreIndicador, periodo, comparador);
    		break;
    	default:
    		System.out.println("Opción no válida.");
    		return;
    	
    	}
    	
    	condiciones.add(nuevaCondicionFiltro);
    	CargadorDeBaseDeDatos.guardarCondicionFiltro(nuevaCondicionFiltro);
    	
	}

}
