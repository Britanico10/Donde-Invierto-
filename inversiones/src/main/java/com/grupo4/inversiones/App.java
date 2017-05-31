package com.grupo4.inversiones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.grupo4.FormulasLexer;
import com.grupo4.FormulasParser;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.Analizador;
import com.grupo4.inversiones.tools.ParDeValores;
import com.grupo4.inversiones.tools.Visitor;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class App{

public static ParDeValores situacionActual = new ParDeValores(); //fst = empresaActual, snd = periodo
public static List<Indicador> indicadores;
public static List<Empresa> empresas;

    public static void main(String[] args) throws FileNotFoundException{
    	
    	Indicador nuevoIndicador;
    	
    	empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
    	
    	Scanner sc = new Scanner(System.in);
    	sc.useDelimiter("[:\\s]");
    	String cadena = sc.nextLine();
    	
    	System.out.println(Analizador.evaluar(cadena));
    	
    }
}
