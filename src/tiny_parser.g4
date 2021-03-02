grammar tiny_parser;
import  tiny_lexer;

program: 'compil' PROGRAMNAME '(' ')' '{' declarations 'start' instructions '}';

declarations: | declaration_type declarations| declaration_type;
declaration_type: type idf_dec ';';
type:'intCompil'|'floatCompil';
idf_dec: IDF | IDF ',' idf_dec;

instructions: | inst instructions| inst;
inst: assignment | print | scan | if_statement; // an instruction can be an affectation/ an if statement/ do-while/ print and scan (maybe conditions or

assignment: IDF AFFECTATION (operande|operation) ';'; // or operation (there is no boolean type then there's no point to asign a comparaison)

condition_mere: condition COMPARAISON condition;
condition: condition COMPARAISON condition | operande | operation;

operation: operation OPERATOR operation | operande;

operande: IDF | INTEGER | REAL;

print: 'printCompil' '(' printcontent ')' ';';
printcontent: operande; // it may also be some text or integer or float

scan: 'scanCompil' '(' IDF ')' ';'; // we'll implement multiple idf's in a scan statement later

if_statement: 'if' '(' condition_mere ')' 'then' '{' instructions '}' ('else' '{' instructions '}')?;

do_while: 'do' '{' condition_mere '}' 'while' '{' instructions '}';