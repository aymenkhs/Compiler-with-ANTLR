import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import generated_files.*;

import java.io.IOException;
import  static  org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {
    public static void main (String[] args){
        try{
            //mainTest est le test ou on utilise la plupars des fonctionnalité de le compilateur,
            //ErrorTest est le test ou on mets plusieurs erreurs.
            String source = "tests/maintest";
            CharStream ca= fromFileName(source);
            tiny_parserLexer lexer= new tiny_parserLexer(ca);
            CommonTokenStream token= new CommonTokenStream(lexer);
            tiny_parserParser parser= new tiny_parserParser(token);
            tiny_parserParser.ProgramContext tree= parser.program();

            SymbolesGeneration visitor= new SymbolesGeneration();
            visitor.visitProgram(tree);

            SymbolesTable table_symboles = visitor.getSemantic_table();

            Routines routines= new Routines(table_symboles,visitor.getSemanticErrors());
            routines.visitProgram(tree);
            System.out.println(routines.getTable_Symboles());
            System.out.println(routines.getWarnings());

            if(!routines.getSemanticErrors().isEmpty()){
                System.out.println(routines.getSemanticErrors());
            }
            else {
                QuadrupletsGeneration visitorQuad = new QuadrupletsGeneration();
                QuadrupletsGeneration.initComparators();
                visitorQuad.visitProgram(tree);
                Quadruplets quadruplets = visitorQuad.getQuadruplets();
                System.out.println("\nLe code intermediaire : ");
                for(QuadElement quad : quadruplets){
                    System.out.println(quad);
                }
                CodeObjetGeneration codeObjet = new CodeObjetGeneration(quadruplets, table_symboles);
                System.out.println("\nLe code objet : ");
                for(String instruction : codeObjet){
                    System.out.println(instruction);
                }
            }



        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
