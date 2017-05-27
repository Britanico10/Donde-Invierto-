grammar Formulas;

//Reglas
expresion: expresion masmenos termino | termino;
termino: termino multodiv factor | factor;
factor: CUENTA | INDICADOR | NUMERO | PA expresion PC;
masmenos: MAS | MENOS;
multodiv: POR | DIV;


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