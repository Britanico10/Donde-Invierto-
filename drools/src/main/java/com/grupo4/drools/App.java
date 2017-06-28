package com.grupo4.drools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.grupo4.inversiones.entidades.Empresa;

public class App {
	 public static void main(List<Empresa> empresas) {
	 List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	 Calendar cal = Calendar.getInstance(); 
     int anio = cal.get(Calendar.YEAR);
	 
	 System.out.println( "Bootstrapping the Rule Engine ..." );
	 KieServices ks = KieServices.Factory.get();
     KieContainer kContainer = ks.getKieClasspathContainer();
     KieSession kSession =  kContainer.newKieSession();
     
     for (int i = 0; i < empresas.size(); i++){
    	 kSession.insert(empresas.get(i));
     }
     
     kSession.setGlobal("listaEmpresas", listaEmpresas);
     kSession.setGlobal("anio", anio);
     
     int fired = kSession.fireAllRules();
     System.out.println( "Number of Rules executed = " + fired );
     
	 }
	}