package com.grupo4.inversiones.tools;

import java.util.List;

import com.grupo4.inversiones.entidades.Empresa;

public class PrintEmpresas {

	public static void mostrarEmpresas(List<Empresa> empresas){
		for (int i = 0; i <= empresas.size() - 1; i++){
			empresas.get(i).mostrarse();
		}
	}
	
	public static void imprimirResultado(List<Empresa> empresas){
		   for (int i = 0; i < empresas.size(); i++){
		    	System.out.println("Empresa: ");
		    	System.out.println(empresas.get(i).getNombre());
		    	System.out.println("Rentabilidad de Inversion: ");
			    System.out.println(empresas.get(i).getRentabilidad());
			    System.out.println( " " );
		    }
	     
	}
	
}
