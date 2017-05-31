package com.grupo4.inversiones.tools;

import java.util.List;
import com.grupo4.FormulasBaseVisitor;
import com.grupo4.FormulasParser;
import com.grupo4.FormulasParser.CuentaContext;
import com.grupo4.FormulasParser.DoubleContext;
import com.grupo4.FormulasParser.ExpresionContext;
import com.grupo4.FormulasParser.IndiContext;
import com.grupo4.FormulasParser.IndicadorContext;
import com.grupo4.FormulasParser.MuldivContext;
import com.grupo4.FormulasParser.ParenContext;
import com.grupo4.FormulasParser.PrintExprContext;
import com.grupo4.FormulasParser.SumresContext;
import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Cuenta;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.operaciones.Expresion;
import com.grupo4.inversiones.operaciones.Factor;

public class Visitor extends FormulasBaseVisitor {
	
	@Override
	public Double visitPrintExpr(PrintExprContext ctx){
		double value = (Double) visit(ctx.expresion());
		System.out.println(value);
		return value;
	}
	
	@Override
	public Double visitMuldiv(MuldivContext ctx){
		double left = (Double) visit(ctx.expresion(0));
		double right = (Double) visit(ctx.expresion(1));

		switch (ctx.op.getType()){
		case FormulasParser.MUL: return left * right;
		case FormulasParser.DIV: return left / right;
		default: throw new IllegalArgumentException("Operador no válido");
		}
	}
	
	@Override
	public Double visitSumres(SumresContext ctx){
		double left = (Double) visit(ctx.expresion(0));
		double right = (Double) visit(ctx.expresion(1));
		switch (ctx.op.getType()){
		case FormulasParser.MAS: return left + right;
		case FormulasParser.MENOS: return left - right;
		default: throw new IllegalArgumentException("Operador no válido");
		}
	}
	
	@Override
	public Double visitDouble(DoubleContext ctx){
		return Double.parseDouble(ctx.NUMERO().getText());
	}
	
	@Override
	public Double visitIndi(IndiContext ctx){
		Indicador indicador = BuscadorDeListas.buscarIndicadorEn(App.indicadores,ctx.getText());
		if (indicador == null) throw new IllegalArgumentException("Indicador no válido.");
		return indicador.aplicarA((Empresa) App.situacionActual.getFst());
	}
	
	@Override
	public Double visitCuenta(CuentaContext ctx){
		Balance balance;
		List<Balance> balancesActuales = ((Empresa) App.situacionActual.getFst()).getBalances();
		balance = BuscadorDeListas.buscarCuentaEn(balancesActuales,(int) App.situacionActual.getSnd());
		switch(ctx.getText()){
		case "ebitda": return 1.0*balance.getEbitda(); //1.0* para pasar a double
		case "fds": return 1.0*balance.getFds();
		case "fCashFlow": return 1.0*balance.getfCashFlow();
		case "ingNetoOpCont": return 1.0*balance.getIngNetoOpCont();
		case "ingNetoOpDiscont": return 1.0*balance.getIngNetoOpDiscont();
		case "deuda": return 1.0*balance.getDeuda();
		default: throw new IllegalArgumentException("Cuenta no válida");
		
		}
	}
	
	@Override
	public Double visitParen(ParenContext ctx){		
		return (Double)visit(ctx.expresion());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
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
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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