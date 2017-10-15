package com.grupo4.inversiones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.CargadorDeBaseDeDatos;
import com.grupo4.inversiones.tools.CreadorCondicionesFiltro;
import com.grupo4.inversiones.tools.CreadorCondicionesOrden;
import com.grupo4.inversiones.tools.CreadorIndicadores;
import com.grupo4.inversiones.tools.CreadorMetodologias;
import com.grupo4.inversiones.tools.EditarIndicador;
import com.grupo4.inversiones.tools.PrintEmpresas;
import com.grupo4.inversiones.tools.cargadorDeArchivos;
import com.grupo4.inversiones.tools.inicializadorGlobal;

public class App{

public static Empresa empresaActual;
public static int periodoActual;
public static List<Indicador> indicadores;
public static List<Empresa> empresas;
public static List<CondicionFiltro> condicionesFiltro;
public static List<CondicionOrden> condicionesOrden;
public static List<Metodologia> metodologias;


    public static void main(String[] args) throws Exception {
    	
    	inicializadorGlobal.inicializar();
    	
    	while(true){
    		int opcionElegida;
    		System.out.println("Seleccione una opción: ");
    		System.out.println("1. Crear un indicador.");
    		System.out.println("2. Aplicar indicadores.");
    		System.out.println("3. Mostrar empresas.");
    		System.out.println("4. Mostrar balances para cierto periodo.");
    		System.out.println("5. Mostrar indicadores.");
    		System.out.println("6. Modificar indicador.");
    		System.out.println("7. Crear condición de filtro.");
    		System.out.println("8. Crear condición de orden.");
    		System.out.println("9. Crear metodología.");
    		System.out.println("10. Aplicar metodología.");
    		System.out.println("11. Cerrar aplicación.");
        	Scanner sc = new Scanner(System.in);
        	sc.useDelimiter("[:\\s]");
        	opcionElegida = Integer.parseInt(sc.nextLine());
        	switch(opcionElegida){
        	case 1: 
        		CreadorIndicadores.crearIndicadorPasoAPaso(indicadores);
        		break;
        	case 2: 
        		System.out.println("Seleccione una empresa");
        		Empresa empresa = empresas.get(Integer.parseInt(sc.nextLine()));
        		System.out.println("Seleccione un periodo");
        		int periodo = Integer.parseInt(sc.nextLine());
        		AplicarIndicadores.aplicarIndicadoresVoid(empresa, periodo, indicadores);
        		break;
        	case 3: 
        		PrintEmpresas.mostrarEmpresas(empresas);
        		break;
        	case 4: 
        		System.out.println("Seleccione una empresa");
        		empresaActual = empresas.get(Integer.parseInt(sc.nextLine()));
        		System.out.println("Seleccione un periodo");
        		periodoActual = Integer.parseInt(sc.nextLine());
        		empresaActual.mostrarBalances(periodoActual);
        		break;
        	case 5:
        		for (int i = 0; i <= indicadores.size() - 1; i++){
        			
        			System.out.println("Indicador: " 
        			+ indicadores.get(i).getIdIndicador());
        			System.out.println("Formula: " 
        			+ indicadores.get(i).getformula());
        			System.out.println(" ");
        		}
        		break;
        	case 6: 
        		System.out.println("Seleccione un indicador.");
        		String indicadorAModificar = (sc.nextLine());
        		System.out.println("Ingrese la nueva formula.");
        		String nuevaFormula = (sc.nextLine());
        		EditarIndicador.editarIndicador(indicadores,indicadorAModificar,nuevaFormula);
        		cargadorDeArchivos.guardarIndicadores("src/main/indicadores.txt", indicadores);
        		break;
        	case 7:
        		CreadorCondicionesFiltro.crearCondicionFiltro(condicionesFiltro);
        		cargadorDeArchivos.guardarCondicionesFiltro("src/main/condicionesFiltro.txt", condicionesFiltro);
        		break;
        	case 8:
        		CreadorCondicionesOrden.crearCondicionOrden(condicionesOrden);
        		cargadorDeArchivos.guardarCondicionesOrden("src/main/condicionesOrden.txt", condicionesOrden);
        		break;
        	case 9:
        		CreadorMetodologias.crearMetodologia(metodologias);
        		cargadorDeArchivos.guardarMetodologias("src/main/metodologias.txt", metodologias);
        		break;
        	case 10:
        		System.out.println("Seleccione una metodología.");
        		Metodologia metodologiaAAplicar = metodologias.get(Integer.parseInt(sc.nextLine()));
        		metodologiaAAplicar.aplicarMetodologiaATodas(empresas);
        		break;
        	case 11: System.exit(0);
        		break;
        	}
        	
        	//EditarIndicador.eliminarIndicador(indicadores, "asd");
    	}
    	
    	
    }
    
}