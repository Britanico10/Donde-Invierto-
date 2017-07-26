package com.grupo4.inversiones.tools;

import java.util.List;
import com.grupo4.FormulasBaseVisitor;
import com.grupo4.FormulasParser;
import com.grupo4.FormulasParser.CuentaContext;
import com.grupo4.FormulasParser.DoubleContext;
import com.grupo4.FormulasParser.IndiContext;
import com.grupo4.FormulasParser.MuldivContext;
import com.grupo4.FormulasParser.ParenContext;
import com.grupo4.FormulasParser.PrintExprContext;
import com.grupo4.FormulasParser.SumresContext;
import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

public class Visitor extends FormulasBaseVisitor<Double> {
	
	@Override
	public Double visitPrintExpr(PrintExprContext ctx){
		Double value = visit(ctx.expresion());
		//System.out.println(value);
		return value;
	}
	
	@Override
	public Double visitMuldiv(MuldivContext ctx){
		Double left = visit(ctx.expresion(0));
		Double right = visit(ctx.expresion(1));

		switch (ctx.op.getType()){
		case FormulasParser.MUL: return left * right;
		case FormulasParser.DIV: return left / right;
		default: throw new IllegalArgumentException("Operador no válido");
		}
	}
	
	@Override
	public Double visitSumres(SumresContext ctx){
		Double left = visit(ctx.expresion(0));
		Double right = visit(ctx.expresion(1));
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
		Indicador indicador = Listas.buscarIndicadorEn(App.indicadores,ctx.getText());
		if (indicador == null) throw new IllegalArgumentException("Indicador no válido.");
		return indicador.aplicarA(App.empresaActual, App.periodoActual);
	}
	
	@Override
	public Double visitCuenta(CuentaContext ctx){
		Balance balance;
		List<Balance> balancesActuales = App.empresaActual.getBalances();
		balance = Listas.buscarCuentaEn(balancesActuales,App.periodoActual);
		if (balance != null){
			switch(ctx.getText()){
			case "ebitda": return 1.0*balance.getEbitda(); //1.0* para pasar a double
			case "fds": return 1.0*balance.getFds();
			case "fCashFlow": return 1.0*balance.getfCashFlow();
			case "ingNetoOpCont": return 1.0*balance.getIngNetoOpCont();
			case "ingNetoOpDiscont": return 1.0*balance.getIngNetoOpDiscont();
			case "deuda": return 1.0*balance.getDeuda();
			case "capitalPropio": return 1.0*balance.getCapitalPropio();
			default: throw new IllegalArgumentException("Cuenta no válida");
			}
		} 
		else{
			return 0.0;
			}
	}
	
	@Override
	public Double visitParen(ParenContext ctx){		
		return visit(ctx.expresion());
	}
	
}