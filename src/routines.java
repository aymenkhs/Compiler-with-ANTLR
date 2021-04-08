import generated_files.tiny_parserBaseVisitor;
import generated_files.tiny_parserParser;

import java.util.ArrayList;

import nodes.*;
import org.antlr.v4.runtime.Token;


public class Routines extends tiny_parserBaseVisitor<Node>{

    private final ArrayList<String> semanticErrors;

    private final SymbolesTable table_Symboles;

    public Routines(SymbolesTable table_Symboles) {
        this.semanticErrors = new ArrayList<>();
        this.table_Symboles = table_Symboles;
    }

    private IDF check_declarer(String idf_name, int row, int column){
        if (table_Symboles.containsVar(idf_name)){
            return table_Symboles.getIDF(idf_name);
        } else if (table_Symboles.alreadyUndeclared(idf_name)) {
            IdfUndeclared idf = (IdfUndeclared) table_Symboles.getIDF(idf_name);
            idf.addOcurence(row, column);
            return idf;
        } else {
            semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " et colones " + column + " non declarer");
            // cree un IDF avec valleur declarer = false et la retourner
            IdfUndeclared idf = new IdfUndeclared(idf_name);
            idf.addOcurence(row, column);
            table_Symboles.addUnDeclaredVar(idf);
            return idf;
        }
    }

    @Override
    public Node visitAssignment(tiny_parserParser.AssignmentContext ctx) {

        Token idToken = ctx.IDF().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine();

        /*  we check if the idf exist, and return the IDF (we create a new one with the declared=false if it doesn't exist */
        IDF resultats = check_declarer(ctx.IDF().getText(), line, column);

        Node operande;

        if (ctx.STRING() != null){
            // if the son is a String we check if the idf is a string
        } else {
            // if not... the possibilities are, (an IDF in which case we check the types) an int or a float in each case we check the types
        }

        return resultats;
    }
}
