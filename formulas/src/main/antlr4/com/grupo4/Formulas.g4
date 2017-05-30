grammar Formulas;

//Reglas

indicador returns [double value]: e1 = expresion {$value = $e1.value;};

expresion returns [double value]: 
t1 = termino {$value = (double)$t1.value;}	
(MAS t2 = termino {$value = (double)$value + (double)$t2.value;} 
| MENOS t3 = termino {$value = (double)$value - (double)$t3.value;}
)*;

termino returns [double value]: 
f1 = factor {$value = (double)$f1.value;} 
(POR f2 = factor {$value = (double)$value * (double)$f2.value;}
| DIV f3 = factor {$value = (double)$value / (double)$f3.value;})*;


factor returns [Object value]: 
CUENTA {$value = $CUENTA.text;} #FactorCuenta
| INDICADOR {$value = Double.parseDouble($INDICADOR.text);} #FactorComun
| NUMERO {$value = Double.parseDouble($NUMERO.text);} #FactorComun
| PA e1 = expresion PC {$value = $e1.value;} #FactorExpresion
; 


//Lexemas
CUENTA: 'ebitda' | 'fds' | 'fCashFlow' | 'ingNetoOpCont' | 'ingNetoOpDiscont' | 'deuda';
MAS: '+';
MENOS: '-';
POR: '*';
DIV: '/';
IGUAL: '=';
MAYOR: '>';
MENOR: '<';
MAYOROIGUAL: '>=';
MENOROIGUAL: '<=';
PA: '(';
PC: ')';
INDICADOR: [a-z]+ ;
NUMERO: [0-9]+;


//Salteo espacios
WS : [ \t\r\n]+ -> skip ;