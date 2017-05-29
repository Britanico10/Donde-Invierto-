grammar Formulas;

//Reglas
expresion: expresion MAS termino | expresion MENOS termino | termino;
termino: termino POR factor | termino DIV factor | factor;
factor: CUENTA | INDICADOR | NUMERO | PA expresion PC;


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