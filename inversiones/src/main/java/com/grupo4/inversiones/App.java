package com.grupo4.inversiones;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.grupo4.FormulasLexer;
import com.grupo4.FormulasParser;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.tools.Visitor;

public class App{

public static Empresa empresaActual;

    public static void main(String[] args){
    	
    	String formula = "ebitda";
    	CharStream charStream = new ANTLRInputStream(formula);
		FormulasLexer lexer = new FormulasLexer(charStream);
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	FormulasParser parser = new FormulasParser(tokens);
    	ParseTree tree = parser.indicador(); // parse
    	
    	Visitor visitor = new Visitor();
    	visitor.visit(tree);
    }
}
