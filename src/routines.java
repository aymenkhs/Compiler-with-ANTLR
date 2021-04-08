import generated_files.tiny_parserBaseVisitor;
import generated_files.tiny_parserParser;

import java.util.ArrayList;
import java.util.Stack;

import nodes.*;


public class Routines extends tiny_parserBaseVisitor<Node>{

    private ArrayList<String> semanticErrors;

    private SymbolesTable table_Symboles;

    public Routines(SymbolesTable table_Symboles) {
        this.semanticErrors = new ArrayList<>();
        this.table_Symboles = table_Symboles;
    }

    public boolean isDeclared(String idf_name){
        return table_Symboles.containsVar(idf_name);
    }

    
}
