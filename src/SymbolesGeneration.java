import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

import generated_files.*;
import nodes.*;

public class SymbolesGeneration extends tiny_parserBaseVisitor {

    private final SymbolesTable semantic_table;
    private final ArrayList<String> semanticErrors;


    public SymbolesGeneration() {
        this.semantic_table = new SymbolesTable();
        this.semanticErrors = new ArrayList<String>();
    }


    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
    }

    public SymbolesTable getSemantic_table() {
        return semantic_table;
    }


    public IDF chose_type(String type,String name){
        if(type.equals("intCompil")){
            return new Idf_int(type,name);
        }
        else if(type.equals("floatCompil")){
            return new Idf_float(type,name);
        }
        else {
            return new Idf_String(type,name);
        }
    }

    @Override
    public Object visitProgram(tiny_parserParser.ProgramContext ctx) {
        Token idToken = ctx.IDF().getSymbol();

        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine();

        semantic_table.addprogramName(ctx.IDF().getText());

        if (!Character.isUpperCase(ctx.IDF().getText().charAt(0))){
            semanticErrors.add("ERREUR à la ligne :" + line + ", cololne :" + column + ", LE PREMIER CHARACTERE DU NOM PU PROGRAMME DOIT ÊTRE MAJISCULE\n");
        }

        return super.visitProgram(ctx);
    }

    @Override
    public Object visitDeclaration_type(tiny_parserParser.Declaration_typeContext ctx) {
        Token idToken=ctx.idf_dec().IDF().getSymbol();

        int line=idToken.getLine();
        int column=idToken.getCharPositionInLine();


        String type=ctx.getChild(0).getText();
        String names=ctx.getChild(1).getText();
        String[] array = names.split(",");

        for (String s : array) {
            IDF var = chose_type(type, s);

            if (semantic_table.containsVar(var.getName( ))) {
                semanticErrors.add("ERREUR à la ligne :" + line + ", cololne :" + column + ", variable : '" + var.getName() + "' DEJA DECLARER\n");
            }else if (semantic_table.isProgramName(var.getName())) {
                semanticErrors.add("ERREUR à la ligne :" + line + ", cololne :" + column + ", variable : " + var.getName() + " PORTE LE MEME NOM QUE LE NOM DU PROGRAMME\n");
            } else {
                semantic_table.addDeclaredVar(var);
            }
        }

        return super.visitDeclaration_type(ctx);
    }

}
