// Generated from Formulas.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CUENTA=1, INDICADOR=2, NUMERO=3, MAS=4, MENOS=5, POR=6, DIV=7, IGUAL=8, 
		MAYOR=9, MENOR=10, MAYOROIGUAL=11, MENOROIGUAL=12, PA=13, PC=14, WS=15;
	public static final String[] tokenNames = {
		"<INVALID>", "CUENTA", "INDICADOR", "NUMERO", "'+'", "'-'", "'*'", "'/'", 
		"'='", "'>'", "'<'", "'>='", "'<='", "'('", "')'", "WS"
	};
	public static final int
		RULE_expresion = 0, RULE_termino = 1, RULE_factor = 2, RULE_masmenos = 3, 
		RULE_multodiv = 4;
	public static final String[] ruleNames = {
		"expresion", "termino", "factor", "masmenos", "multodiv"
	};

	@Override
	public String getGrammarFileName() { return "Formulas.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormulasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public MasmenosContext masmenos() {
			return getRuleContext(MasmenosContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).exitExpresion(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(11); termino(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(19);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpresionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expresion);
					setState(13);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(14); masmenos();
					setState(15); termino(0);
					}
					} 
				}
				setState(21);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TerminoContext extends ParserRuleContext {
		public MultodivContext multodiv() {
			return getRuleContext(MultodivContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).exitTermino(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		return termino(0);
	}

	private TerminoContext termino(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TerminoContext _localctx = new TerminoContext(_ctx, _parentState);
		TerminoContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_termino, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(23); factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TerminoContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termino);
					setState(25);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(26); multodiv();
					setState(27); factor();
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(FormulasParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(FormulasParser.PC, 0); }
		public TerminalNode NUMERO() { return getToken(FormulasParser.NUMERO, 0); }
		public TerminalNode INDICADOR() { return getToken(FormulasParser.INDICADOR, 0); }
		public TerminalNode CUENTA() { return getToken(FormulasParser.CUENTA, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_factor);
		try {
			setState(41);
			switch (_input.LA(1)) {
			case CUENTA:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); match(CUENTA);
				}
				break;
			case INDICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); match(INDICADOR);
				}
				break;
			case NUMERO:
				enterOuterAlt(_localctx, 3);
				{
				setState(36); match(NUMERO);
				}
				break;
			case PA:
				enterOuterAlt(_localctx, 4);
				{
				setState(37); match(PA);
				setState(38); expresion(0);
				setState(39); match(PC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MasmenosContext extends ParserRuleContext {
		public TerminalNode MENOS() { return getToken(FormulasParser.MENOS, 0); }
		public TerminalNode MAS() { return getToken(FormulasParser.MAS, 0); }
		public MasmenosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_masmenos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).enterMasmenos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).exitMasmenos(this);
		}
	}

	public final MasmenosContext masmenos() throws RecognitionException {
		MasmenosContext _localctx = new MasmenosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_masmenos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !(_la==MAS || _la==MENOS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultodivContext extends ParserRuleContext {
		public TerminalNode POR() { return getToken(FormulasParser.POR, 0); }
		public TerminalNode DIV() { return getToken(FormulasParser.DIV, 0); }
		public MultodivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multodiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).enterMultodiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulasListener ) ((FormulasListener)listener).exitMultodiv(this);
		}
	}

	public final MultodivContext multodiv() throws RecognitionException {
		MultodivContext _localctx = new MultodivContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multodiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !(_la==POR || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return expresion_sempred((ExpresionContext)_localctx, predIndex);
		case 1: return termino_sempred((TerminoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termino_sempred(TerminoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\24\n\2\f"+
		"\2\16\2\27\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4,\n\4\3\5\3\5\3\6\3\6\3\6\2\4\2\4\7\2\4"+
		"\6\b\n\2\4\3\2\6\7\3\2\b\t\61\2\f\3\2\2\2\4\30\3\2\2\2\6+\3\2\2\2\b-\3"+
		"\2\2\2\n/\3\2\2\2\f\r\b\2\1\2\r\16\5\4\3\2\16\25\3\2\2\2\17\20\f\4\2\2"+
		"\20\21\5\b\5\2\21\22\5\4\3\2\22\24\3\2\2\2\23\17\3\2\2\2\24\27\3\2\2\2"+
		"\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\25\3\2\2\2\30\31\b\3\1\2"+
		"\31\32\5\6\4\2\32!\3\2\2\2\33\34\f\4\2\2\34\35\5\n\6\2\35\36\5\6\4\2\36"+
		" \3\2\2\2\37\33\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\5\3\2\2\2#"+
		"!\3\2\2\2$,\7\3\2\2%,\7\4\2\2&,\7\5\2\2\'(\7\17\2\2()\5\2\2\2)*\7\20\2"+
		"\2*,\3\2\2\2+$\3\2\2\2+%\3\2\2\2+&\3\2\2\2+\'\3\2\2\2,\7\3\2\2\2-.\t\2"+
		"\2\2.\t\3\2\2\2/\60\t\3\2\2\60\13\3\2\2\2\5\25!+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}