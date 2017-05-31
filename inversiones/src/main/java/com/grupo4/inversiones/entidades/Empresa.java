package com.grupo4.inversiones.entidades;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.grupo4.inversiones.tools.BuscadorDeListas;

public class Empresa {
	
	private String nombre;
	private int inicioActividad;
	private List<Balance> balances = new ArrayList<Balance>();
	
	public Empresa(String _nombre) {
		this.nombre = _nombre;
	}
	
	public int getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(int inicoActividad) {
		inicioActividad = inicoActividad;
	}
	
	public void agregarElemento(Balance balance){
		balances.add(balance);
	}
	
	public String getNombre() {
		return nombre;
	}
	public List<Balance> getBalances(){
		return balances;
	}
	
	public void mostrarBalances(int periodo){
		Balance balance = BuscadorDeListas.buscarCuentaEn(balances,periodo);
		System.out.println("BALANCES PARA EL PERIODO " + periodo + ":");
		balance.mostrarse();
	}
	
	public void mostrarBalances(){
		
		System.out.println("BALANCES:");
		
		for (int i = 0; i <= balances.size() - 1; i++){
			
			System.out.println("Periodo: " + balances.get(i).getPeriodo());
			balances.get(i).mostrarse();
			
			System.out.println(" ");
		}
	}
	
	public void mostrarse(){
		System.out.println("Nombre de la empresa: " + this.getNombre());
		System.out.println("Inicio  de actividad: " + this.getInicioActividad());;
		this.mostrarBalances();
	}
	
}
