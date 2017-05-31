package com.grupo4.inversiones;

import java.io.FileNotFoundException;
import java.util.List;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.tools.CreadorIndicadores;
import com.grupo4.inversiones.tools.ParDeValores;
import com.grupo4.inversiones.tools.PrintEmpresas;
import com.grupo4.inversiones.tools.cargadorDeArchivos;

public class App{

public static ParDeValores situacionActual = new ParDeValores(); //fst = empresaActual, snd = periodo
public static List<Indicador> indicadores;
public static List<Empresa> empresas;

    public static void main(String[] args) throws FileNotFoundException{
    	
    	empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
    	indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
    	
    	PrintEmpresas.mostrarEmpresas(empresas);
    	
    	CreadorIndicadores.crearIndicador(indicadores);
    	
    }
}

/*
Recuperación de indicadores definidos por el usuario
Test de la gramática definida
Test de Indicadores generados a partir de la gramática (objetos)
Test de manejo de errores (Exceptions)
A partir del output del parser, generar los objetos (instancias)
correspondientes según el modelo definido en el paso 3.
*/