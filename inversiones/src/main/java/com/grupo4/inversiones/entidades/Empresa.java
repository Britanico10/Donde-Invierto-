package com.grupo4.inversiones.entidades;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public void mostrarBalances(){
		
		System.out.println("BALANCES:");
		
		for (int i = 0; i <= balances.size() - 1; i++){
			
			System.out.println("Periodo: " + balances.get(i).getPeriodo());
			
			System.out.println("Deuda: " + balances.get(i).getDeuda());
			
			System.out.println("Ebitda: " + balances.get(i).getEbitda());
			
			System.out.println("fCashFlow: " + balances.get(i).getfCashFlow());
			
			System.out.println("Fds: " + balances.get(i).getFds());
			
			System.out.println("IngNetoOpCont: " + balances.get(i).getIngNetoOpCont());
			
			System.out.println("IngNetOpDiscont: " + balances.get(i).getIngNetoOpDiscont());
			System.out.println(" ");
		}
	}
	
	public void mostrarse(){
		System.out.println("Nombre de la empresa: " + this.getNombre());
		System.out.println("Inicio  de actividad: " + this.getInicioActividad());;
		this.mostrarBalances();
	}
	
}
