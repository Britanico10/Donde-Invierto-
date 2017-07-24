package com.grupo4.inversiones.tools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.grupo4.formulas.App;
import com.grupo4.inversiones.entidades.Empresa;

public class Reglas {

	public Reglas() {

	}
	
	public static void inicializarMotor(List<Empresa> empresas){
		
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		Calendar cal = Calendar.getInstance(); 
	    int anio = cal.get(Calendar.YEAR);
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.newKieClasspathContainer();
		KieSession kieSession = kContainer.newKieSession();
		
		for (int i = 0; i < empresas.size(); i++){
			kieSession.insert(empresas.get(i));
	    }
	     
	    kieSession.setGlobal("listaEmpresas", listaEmpresas);
	    kieSession.setGlobal("anio", anio);
	     
	    int fired = kieSession.fireAllRules();
	    System.out.println( "Number of Rules executed = " + fired );
		
	}

}
