// Generated from Formulas.g4 by ANTLR 4.4
package dondeinvierto.AnalizadorFormulas;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormulasParser}.
 */
public interface FormulasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormulasParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(@NotNull FormulasParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulasParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(@NotNull FormulasParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulasParser#masmenos}.
	 * @param ctx the parse tree
	 */
	void enterMasmenos(@NotNull FormulasParser.MasmenosContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulasParser#masmenos}.
	 * @param ctx the parse tree
	 */
	void exitMasmenos(@NotNull FormulasParser.MasmenosContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulasParser#multodiv}.
	 * @param ctx the parse tree
	 */
	void enterMultodiv(@NotNull FormulasParser.MultodivContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulasParser#multodiv}.
	 * @param ctx the parse tree
	 */
	void exitMultodiv(@NotNull FormulasParser.MultodivContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulasParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(@NotNull FormulasParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulasParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(@NotNull FormulasParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulasParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull FormulasParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulasParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull FormulasParser.FactorContext ctx);
}