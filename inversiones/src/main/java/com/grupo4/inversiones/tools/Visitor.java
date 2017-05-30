package com.grupo4.inversiones.tools;

import com.grupo4.FormulasBaseVisitor;
import com.grupo4.FormulasParser.ExpresionContext;
import com.grupo4.FormulasParser.FactorComunContext;
import com.grupo4.FormulasParser.FactorExpresionContext;
import com.grupo4.FormulasParser.TerminoContext;
import com.grupo4.inversiones.operaciones.Expresion;
import com.grupo4.inversiones.operaciones.Factor;

public class Visitor extends FormulasBaseVisitor {
	
	@Override
	public Factor visitFactorExpresion(FactorExpresionContext ctx){
		Factor fac = new Factor((Double) visit(ctx.expresion()));
		return fac;
	}
	
	@Override
	public Factor visitFactorComun(FactorComunContext ctx){
		Factor fac = new Factor(ctx.value);
		return fac;
	}
	
	@Override
	public Expresion visitTermino(TerminoContext ctx){
		Expresion term = new Expresion(ctx.f1.value,ctx.f2.value,ctx.);
	}
	
	@Override
	public Expresion visitExpresion(ExpresionContext ctx){
		Expresion e1 = new Expresion();
		return e1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public void enterFactor(FactorContext ctx){
		Factor = new Factor();
	}
	
	@Override
	public void exitFactor(FactorContext ctx){
		if (ctx.getChild(1).getText() == "(") {
			Factor.setResultado(Double.parseDouble(ctx.getChild(2).getText()));
		}
		else{
			Factor.setResultado(Double.parseDouble(ctx.getText()));
			}
		
	}
	
	public void enterExpresion(ExpresionContext ctx){
		Expresion = new Expresion();
	}
	
	public void exitExpresion(ExpresionContext ctx){
		if (ctx.getChildCount() == 3){
			Expresion.setExpresion1(ctx.expresion().);
			
		}
	}
	
	*/
	
}