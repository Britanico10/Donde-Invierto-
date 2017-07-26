package com.grupo4.inversiones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.AplicarIndicadores;
import com.grupo4.inversiones.tools.CreadorIndicadores;
import com.grupo4.inversiones.tools.EditarIndicador;
import com.grupo4.inversiones.tools.ParDeValores;
import com.grupo4.inversiones.tools.PrintEmpresas;
import com.grupo4.inversiones.tools.cargadorDeArchivos;
import com.grupo4.inversiones.tools.Reglas;

public class App{

public static Empresa empresaActual;
public static int periodoActual;
public static List<Indicador> indicadores;
public static List<Empresa> empresas;

    public static void main(String[] args) throws IOException {
    	
    	empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
    	
    	empresaActual = empresas.get(0);
    	periodoActual = 2007;
    	
    	while(true){
    		int opcionElegida;
    		System.out.println("Seleccione una opción: ");
    		System.out.println("1. Crear un indicador.");
    		System.out.println("2. Aplicar indicadores.");
    		System.out.println("3. Mostrar empresas.");
    		System.out.println("4. Mostrar balances para cierto periodo.");
    		System.out.println("5. Mostrar indicadores.");
    		System.out.println("6. Modificar indicador.");
    		System.out.println("7. Inicializar motor de reglas.");
    		System.out.println("8. Cerrar aplicación.");
        	Scanner sc = new Scanner(System.in);
        	sc.useDelimiter("[:\\s]");
        	opcionElegida = Integer.parseInt(sc.nextLine());
        	switch(opcionElegida){
        	case 1: 
        		CreadorIndicadores.crearIndicador(indicadores);
        		cargadorDeArchivos.guardarIndicadores("src/main/indicadores.txt", indicadores);
        		break;
        	case 2: 
        		System.out.println("Seleccione una empresa");
        		//situacionActual.setFst(empresas.get(Integer.parseInt(sc.nextLine())));
        		Empresa empresa = empresas.get(Integer.parseInt(sc.nextLine()));
        		System.out.println("Seleccione un periodo");
        		int periodo = Integer.parseInt(sc.nextLine());
        		AplicarIndicadores.aplicarIndicadores(empresa, periodo, indicadores);
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
        	//case 7: Reglas.inicializarMotor(empresas,"asdasdasd");
        	case 7: com.grupo4.drools.App.main(empresas);
    			break;
        	case 8: System.exit(0);
        		break;
        	}
    	}
    	
    	
    }
}