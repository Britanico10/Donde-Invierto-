package com.grupo4.inversiones.entidades;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.grupo4.inversiones.persistencia.Persistible;
import com.grupo4.inversiones.tools.Listas;

@Entity
@Table(name = "EMPRESA")
public class Empresa extends Persistible implements Comparable<Empresa>{
	
	private String nombre;
	private int inicioActividad;
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "idEmpresa", referencedColumnName = "id") 
	private List<Balance> balances = new ArrayList<Balance>();
	private double rentabilidad= 0;
	
	public Empresa() {
	}
	
	public Empresa(String _nombre) {
		this.nombre = _nombre;
	}
	
	public Empresa(String _nombre,int _inicioActividad, double _rentabilidad) {
		nombre = _nombre;
		inicioActividad = _inicioActividad;
		rentabilidad = _rentabilidad;
	}
	
	@Column(name = "rentabilidad")
	public double getRentabilidad() {
		return rentabilidad;
	}

	public void setRentabilidad(double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	
	@Column(name = "inicioActividad")
	public int getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(int inicioActividad) {
		this.inicioActividad = inicioActividad;
	}
	
	public void agregarElemento(Balance balance){
		balances.add(balance);
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	
	public List<Balance> getBalances(){
		return balances;
	}
	
	public void mostrarBalances(int periodo){
		Balance balance = Listas.buscarCuentaEn(balances,periodo);
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
	
	public int compareTo(Empresa empresa) {

		double rentabilidadDeComparacion = empresa.getRentabilidad();

		return (int)(rentabilidadDeComparacion - this.rentabilidad);

	}
	
}
