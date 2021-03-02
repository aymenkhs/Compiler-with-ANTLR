grammar tiny_parser;
import  tiny_lexer;

program: 'compil' PROGRAMNAME '(' ')' '{' declarations 'start' '}';

declarations: | declaration_type declarations| declaration_type;
declaration_type: type idf_dec ';';
type:'intCompil'|'floatCompil';
idf_dec: IDF | IDF ',' idf_dec;
