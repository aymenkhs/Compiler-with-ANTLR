grammar tiny_parser;
import  tiny_lexer;

program: 'compil' PROGRAMNAME '(' ')' '{' declarations 'start' instructions '}';

// declaration
declarations: | declaration_type declarations| declaration_type;
declaration_type: type idf_dec ';';
type:'intCompil'|'floatCompil'|'StringCompil';
idf_dec: IDF | IDF ',' idf_dec;

// general instructions
instructions: | inst instructions| inst;
inst: assignment | print | scan | if_statement | do_while; // an instruction can be an affectation/ an if statement/ do-while/ print and scan (maybe conditions or

/*
we don't use operandes only with operations, but rather with al type of instruction that need an IDF, real or integer
like conditions, assignments, or print statements (or any other type of functions if we add them)
*/

// assignements
assignment: IDF AFFECTATION (operande|operation_mere|STRING) ';'; // or operation (there is no boolean type then there's no point to asign a comparaison)

// conditions
condition_mere: condition COMPARAISON condition;
condition: condition COMPARAISON condition | operande | operation_mere;

// operations
operation_mere: operation_mere PLUS operation_fils | operation_mere MINUS operation_fils | operation_fils;
operation_fils: operation_fils PRODUCT operation_gf |operation_fils DIV operation_gf |operation_gf;
operation_gf:'(' operation_mere ')' | operande;
operande: IDF | INTEGER | REAL;

// print statement
print: 'printCompil' '(' printcontent ')' ';';
printcontent: operande|STRING; // it may be a STRING, an idf ,an integer or a float

// scan statement
scan: 'scanCompil' '(' IDF ')' ';'; // we'll implement multiple idf's in a scan statement later

// if statement
if_statement: 'if' '(' condition_mere ')' then (else_if)* (else_statement)?;
else_if: 'else if' '(' condition_mere ')' then;
then: 'then' '{' instructions '}';
else_statement: 'else' '{' instructions '}';

// do while
do_while: 'do' '{' instructions '}' 'while' '(' condition_mere ')';