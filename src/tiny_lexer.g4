lexer grammar tiny_lexer;

fragment DIGIT: [0-9];
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];

INTEGER: [+-]?([1-9]DIGIT*|'0');
REAL: '0'|[+-]?[1-9]DIGIT*('.'DIGIT*)?;

OPERATOR: '-'|'+'|'/'|'*';
AFFECTION: '=';
COMPARAISON: '<' | '>' | '<=' | '>=' | '<>' | '==';

IDF: (UPPERCASE|LOWERCASE)(UPPERCASE|LOWERCASE|DIGIT)*;
PROGRAMNAME: UPPERCASE('_'|UPPERCASE|LOWERCASE)*;

WHITESPACE: (' ' | '\t')+;
NEWLINE: ('\r'? '\n' | '\r')+;