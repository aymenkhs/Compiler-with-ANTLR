lexer grammar tiny_lexer;

fragment DIGIT: [0-9];
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];

INTEGER: ([1-9]DIGIT*|'0');
REAL: '0'('.'DIGIT*)|[1-9]DIGIT*('.'DIGIT*);

// operators
PRODUCT: '*';
DIV: '/';
PLUS: '+';
MINUS: '-';
// affectation
AFFECTATION: '=';
// comparaison
COMPARAISON: '<' | '>' | '<=' | '>=' | '<>' | '!=' | '==';

IDF: (LOWERCASE|UPPERCASE)(UPPERCASE|LOWERCASE|DIGIT)*;
PROGRAMNAME: UPPERCASE('_'?(UPPERCASE|LOWERCASE))*;

// ignoring spaces and new lines
WHITESPACE: (' ' | '\t')+ -> skip;
NEWLINE: ('\r'? '\n' | '\r')+ -> skip;

STRING: '"'~["]*'"';

// comments
INLINECOMMENT: '//'~[\n\r]* -> skip;
BLOCKCOMMENT: '/*'~[*/]* '*/' -> skip;