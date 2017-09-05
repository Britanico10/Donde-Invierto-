package com.grupo4.inversiones.entidades.condiciones;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import javax.persistence.InheritanceType;

import com.grupo4.inversiones.persistencia.Persistible;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Condicion extends Persistible{
	
	String nombreCondicion;
	String nombreIndicador;
	int periodo;
	int inicioIntervalo;
	int finalIntervalo;
	public String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNombreCondicion() {
		return nombreCondicion;
	}

	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}

	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getInicioIntervalo() {
		return inicioIntervalo;
	}

	public void setInicioIntervalo(int inicioIntervalo) {
		this.inicioIntervalo = inicioIntervalo;
	}

	public int getFinalIntervalo() {
		return finalIntervalo;
	}

	public void setFinalIntervalo(int finalIntervalo) {
		this.finalIntervalo = finalIntervalo;
	}

	public Condicion(String _nombreCondicion, int _inicioIntervalo, int _finalIntervalo, String _nombreIndicador, int _periodo) {
		nombreCondicion = _nombreCondicion;
		inicioIntervalo = _inicioIntervalo;
		finalIntervalo = _finalIntervalo;
		nombreIndicador = _nombreIndicador;
		periodo = _periodo;
	}

}
