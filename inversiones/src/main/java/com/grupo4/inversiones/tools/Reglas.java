package com.grupo4.inversiones.tools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.grupo4.formulas.App;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class Reglas {

	public Reglas() {

	}
	
	public static void inicializarMotor(List<Empresa> empresas, String nombreMetodologia){
		
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		List<Indicador> indicadores = com.grupo4.inversiones.App.indicadores;
		Calendar cal = Calendar.getInstance(); 
	    int anio = cal.get(Calendar.YEAR);
		 
		System.out.println( "Bootstrapping the Rule Engine ..." );
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    KieSession kSession =  kContainer.newKieSession(nombreMetodologia);
	     
	    for (int i = 0; i < empresas.size(); i++){
	    	kSession.insert(empresas.get(i));
	    }
	     
	    kSession.setGlobal("listaEmpresas", listaEmpresas);
	    kSession.setGlobal("anio", anio);
	    kSession.setGlobal("indicadores", indicadores);
	     
	    int fired = kSession.fireAllRules();
	    System.out.println( "Number of Rules executed = " + fired );
	    System.out.println( " " );
	     
	    //System.out.println(listaEmpresas.get(0).getPoder());
	    //System.out.println(listaEmpresas.get(0).getNombre());
		
	    Collections.sort(listaEmpresas);
	     
	    for (int i = 0; i < listaEmpresas.size(); i++){
	    	System.out.println("Empresa: ");
	    	System.out.println(listaEmpresas.get(i).getNombre());
	    	System.out.println("Ranking: ");
		    System.out.println(listaEmpresas.get(i).getPoder());
		    System.out.println( " " );
	    }
     
	} 

}
