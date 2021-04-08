import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

import generated_files.*;
import nodes.*;

public class AntlerToExp extends tiny_parserBaseVisitor {

    private SymbolesTable semantic_table;
    private ArrayList<String> semanticErrors;


    public AntlerToExp() {
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
            Idf_int var= new Idf_int(type,name);
            return var;
        }
        else if(type.equals("floatCompil")){
            Idf_float var= new Idf_float(type,name);
            return var;
        }
        else {
            Idf_String var= new Idf_String(type,name);
            return var;
        }

    }

    @Override
    public Object visitProgram(tiny_parserParser.ProgramContext ctx) {
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

        for(int i=0;i<array.length;i++){
            IDF var=chose_type(type,array[i]);

            if(semantic_table.containsVar(var.getName())){
                semanticErrors.add("variable : "+var.getName()+" ALRDY DEClARED! at line "+line+" column "+column);
            }
            else {
                semantic_table.addDeclaredVar(var);
            }
        }

        return super.visitDeclaration_type(ctx);
    }

}
