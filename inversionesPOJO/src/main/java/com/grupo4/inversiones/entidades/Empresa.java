package com.grupo4.inversiones.entidades;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Empresa {
	
	private String nombre;
	private int inicioActividad;
	private List<Balance> balances = new ArrayList<Balance>();
	private double rentabilidad= 0;
	
	public double getRentabilidad() {
		return rentabilidad;
	}

	public void setRentabilidad(double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	
	public int getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(int inicioActividad) {
		this.inicioActividad = inicioActividad;
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
	
	
}