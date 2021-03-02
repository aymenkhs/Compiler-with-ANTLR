grammar tiny_parser;
import  tiny_lexer;

program: 'compil' PROGRAMNAME '(' ')' '{' declarations 'start' instructions '}';

declarations: | declaration_type declarations| declaration_type;
declaration_type: type idf_dec ';';
type:'intCompil'|'floatCompil';
idf_dec: IDF | IDF ',' idf_dec;

instructions: | inst instructions|inst;
inst:';'; // an instruction can be an affectation/ an if statement/ do-while/ print and scan (maybe conditions or
