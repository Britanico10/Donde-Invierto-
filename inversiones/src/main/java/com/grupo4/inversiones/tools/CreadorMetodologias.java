package com.grupo4.inversiones.tools;

import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Metodologia;

public class CreadorMetodologias {

	public static void crearMetodologia(List<Metodologia> metodologias) {
		
		Metodologia metodologia = new Metodologia();
		
    	Scanner sc = new Scanner(System.in);
    	sc.useDelimiter("[:\\s]");
    	
		System.out.println("Ingrese el nombre de la Metodología.");
		
    	metodologia.setNombre(sc.nextLine());
    	
    	System.out.println("Ingrese las condiciones de filtrado. Ingrese -1 para terminar.");
    	
    	int opcion = Integer.parseInt(sc.nextLine());
    	
    	while(opcion != -1) {
    		metodologia.agregarCondicionFiltro(App.condicionesFiltro.get(opcion));
    		opcion = Integer.parseInt(sc.nextLine());
    	}
    	
    	
    	System.out.println("Ingrese las condiciones de ordenamiento. Ingrese -1 para terminar.");
    	opcion = Integer.parseInt(sc.nextLine());
    	
    	while(opcion != -1) {
    		metodologia.agregarCondicionOrden(App.condicionesOrden.get(opcion));
    		opcion = Integer.parseInt(sc.nextLine());
    	}
    	
    	System.out.println("Metodología creada.");
    	
	}
	
}
