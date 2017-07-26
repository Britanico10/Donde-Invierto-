package com.grupo4.inversiones.entidades;

public class Balance{
	
	private int periodo = 0;
	private int ebitda = 0;
	private int fds = 0;
	private int fCashFlow = 0;
	private int ingNetoOpCont = 0;
	private int ingNetoOpDiscont = 0;
	private int deuda = 0;
	private int capitalPropio = 0;
	
	public int getDeuda() {
		return deuda;
	}
	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}
	
	public int getCapitalPropio() {
		return capitalPropio;
	}
	
	public void setCapitalPropio(int capitalPropio) {
		this.capitalPropio = capitalPropio;
	}

	public int getEbitda() {
		return ebitda;
	}
	public void setEbitda(int ebitda) {
		this.ebitda = ebitda;
	}
	public int getFds() {
		return fds;
	}
	public void setFds(int fds) {
		this.fds = fds;
	}
	public int getfCashFlow() {
		return fCashFlow;
	}
	public void setfCashFlow(int fCashFlow) {
		this.fCashFlow = fCashFlow;
	}
	public int getIngNetoOpCont() {
		return ingNetoOpCont;
	}
	public void setIngNetoOpCont(int ingNetoOpCont) {
		this.ingNetoOpCont = ingNetoOpCont;
	}
	public int getIngNetoOpDiscont() {
		return ingNetoOpDiscont;
	}
	public void setIngNetoOpDiscont(int ingNetoOpDiscont) {
		this.ingNetoOpDiscont = ingNetoOpDiscont;
	}
	
	public Balance(int _periodo) {
		periodo = _periodo;
	}
	
	public int getPeriodo(){
		return periodo;
	}
	
	
	public void setPeriodo(int _periodo){
		periodo = _periodo;
	}
	
	public void mostrarse(){
		System.out.println("Deuda: " + this.deuda);
		System.out.println("Ebitda: " + this.ebitda);
		System.out.println("fCashFlow: " + this.fCashFlow);
		System.out.println("Fds: " + this.fds);
		System.out.println("IngNetoOpCont: " + this.ingNetoOpCont);
		System.out.println("IngNetOpDiscont: " + this.ingNetoOpDiscont);
		System.out.println("capitalPropio: " + this.capitalPropio);
		System.out.println(" ");
	}
	

}
