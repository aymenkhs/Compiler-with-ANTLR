import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import  static  org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {
    public static void main (String[] args){
        try{
            String source = "src/test.txt";
            CharStream ca= fromFileName(source);
            tiny_parserLexer lexer= new tiny_parserLexer(ca);
            CommonTokenStream token= new CommonTokenStream(lexer);
            tiny_parserParser parser= new tiny_parserParser(token);
            tiny_parserParser.ProgramContext tree= parser.program();

            AntlerToExp visitor= new AntlerToExp();
            visitor.visitProgram(tree);
            System.out.println(visitor.getSemanticErrors());
            System.out.println(visitor.getSymbol_table());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
