package com.grupo4.inversiones.tools;

import com.grupo4.FormulasBaseListener;
import com.grupo4.FormulasParser.ExpresionContext;
import com.grupo4.FormulasParser.FactorContext;
import com.grupo4.FormulasParser.TerminoContext;
import com.grupo4.inversiones.operaciones.ExpresionCompuesta;
import com.grupo4.inversiones.operaciones.Factor;

public class Listener extends FormulasBaseListener {

	@Override
	public void enterExpresion(ExpresionContext ctx){
		ExpresionCompuesta expresion;
		
	}

	@Override
	public void enterTermino(TerminoContext ctx){
		ExpresionCompuesta termino;
	}
	
	@Override
	public void enterFactor(FactorContext ctx){
		Factor factor;
		
	}
	
}
