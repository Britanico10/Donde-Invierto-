package com.grupo4.inversiones.tools;

import java.util.List;

import com.grupo4.FormulasBaseVisitor;
import com.grupo4.FormulasParser.ExpresionContext;
import com.grupo4.FormulasParser.FactorComunContext;
import com.grupo4.FormulasParser.FactorCuentaContext;
import com.grupo4.FormulasParser.FactorExpresionContext;
import com.grupo4.FormulasParser.IndicadorContext;
import com.grupo4.FormulasParser.TerminoContext;
import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Cuenta;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.operaciones.Expresion;
import com.grupo4.inversiones.operaciones.Factor;

public class Visitor extends FormulasBaseVisitor {
	
	@Override
	public Double visitIndicador(IndicadorContext ctx){
		System.out.print(ctx.value);
		return ctx.value;
	}
	
	@Override
	public Factor visitFactorExpresion(FactorExpresionContext ctx){
		Factor fac = new Factor((Double) visit(ctx.expresion()));
		return fac;
	}
	
	@Override
	public Factor visitFactorComun(FactorComunContext ctx){
		Factor fac = new Factor((Double) ctx.value);
		return fac;
	}
	
	@Override
	public Cuenta visitFactorCuenta(FactorCuentaContext ctx){
		List<Balance> balances = App.empresaActual.getBalances();
		return cuenta;
	}
	
	@Override
	public Expresion visitTermino(TerminoContext ctx){
		Expresion term = new Expresion(ctx.value);
		return term;
	}
	
	@Override
	public Expresion visitExpresion(ExpresionContext ctx){
		Expresion e1 = new Expresion(ctx.value);
		System.out.print(ctx.value);
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