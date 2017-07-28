package com.grupo4.drools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class App {
	 
	public static void main(List<Empresa> empresas) {
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		List<Indicador> indicadores = com.grupo4.inversiones.App.indicadores;
		Calendar cal = Calendar.getInstance(); 
	    int anio = cal.get(Calendar.YEAR);
		 
		System.out.println( "Bootstrapping the Rule Engine ..." );
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    KieSession kSession =  kContainer.newKieSession("buffett");
	     
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
		    System.out.println(listaEmpresas.get(i).getRentabilidad());
		    System.out.println( " " );
	    }
     
	} 
}