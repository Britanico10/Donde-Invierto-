package com.grupo4.inversiones.tools;

import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.entidades.Metodologia;

public class CreadorMetodologias {

	public static void crearMetodologia(List<Metodologia> metodologias) {
    	Scanner sc = new Scanner(System.in);
    	sc.useDelimiter("[:\\s]");
		System.out.println("Ingrese el nombre de la Metodología.");
    	String nombreMetodologia = sc.nextLine();

	}
	
}
