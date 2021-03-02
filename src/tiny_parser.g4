grammar tiny_parser;
import  tiny_lexer;

program: 'compil' PROGRAMNAME '(' ')' '{' declarations 'start' instructions '}';

// declaration
declarations: | declaration_type declarations| declaration_type;
declaration_type: type idf_dec ';';
type:'intCompil'|'floatCompil';
idf_dec: IDF | IDF ',' idf_dec;

// general instructions
instructions: | inst instructions| inst;
inst: assignment | print | scan | if_statement | do_while; // an instruction can be an affectation/ an if statement/ do-while/ print and scan (maybe conditions or

/*
we don't use operandes only with operations, but rather with al type of instruction that need an IDF, real or integer
like conditions, assignments, or print statements (or any other type of functions if we add them)
*/

// assignements
assignment: IDF AFFECTATION (operande|operation) ';'; // or operation (there is no boolean type then there's no point to asign a comparaison)

// conditions
condition_mere: condition COMPARAISON condition;
condition: condition COMPARAISON condition | operande | operation;

// operations
operation: operation OPERATOR operation | operande;
operande: IDF | INTEGER | REAL;

// print statement
print: 'printCompil' '(' printcontent ')' ';';
printcontent: operande; // it may also be some text or integer or float

// scan statement
scan: 'scanCompil' '(' IDF ')' ';'; // we'll implement multiple idf's in a scan statement later

// if statement
if_statement: 'if' '(' condition_mere ')' 'then' '{' instructions '}' ('else' '{' instructions '}')?;

// do while
do_while: 'do' '{' instructions '}' 'while' '(' condition_mere ')';