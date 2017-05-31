package com.grupo4.inversiones.tools;

public class ParDeValores {
	Object x;
	Object y;
	
	public ParDeValores(){
	}
	
	public ParDeValores(Object x, Object y){
		this.x = x;
		this.y = y;
	}
	
	public Object getFst(){
		return x;
	}
	
	public Object getSnd(){
		return y;
	}
	
	public void setFst(Object x){
		this.x = x;
	}
	
	public void setSnd(Object y){
		this.y = y;
	}

}
