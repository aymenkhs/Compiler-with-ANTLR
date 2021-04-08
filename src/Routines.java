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
        int row = idToken.getLine();
        int column = idToken.getCharPositionInLine();
        String idf_name = ctx.IDF().getText();

        /*  we check if the idf exist, and return the IDF (we create a new one with the declared=false if it doesn't exist */
        IDF resultats = check_declarer(idf_name, row, column);
        // if the result idf is undeclared in the first place we don't have to check all types errors in the assignement

        if (resultats.isDeclared()){
            if (ctx.STRING() != null){
                // if the son is a String we check if the idf is a string
                if (!resultats.getType().equals("StringCompil")){
                    semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " et colones " +
                            column + " se voit assigner un StringCompil alors qu'il est de type " + resultats.getType());
                }
            } else {
                /*  if it's not a string...
                    the possibilities are:
                        - an IDF in which case we compare the type of the operande with the result
                        - an int in which case we check that the type of the result is int
                        - a float in which case we check that the type of the result is a float
                */


                Node operande = visitOperation_mere(ctx.operation_mere());
                /*  visitOperation_mere vas retourner un fils de nodes, qui sera soit:
                        - un IDF_Int ou IDF_Float ou IDF_String dans le cas ou il n'y a pas d'operation
                        - un ConstanteInteger ou ConstanteReal dan le cas d'une operation ou d'assignement a une constante

                    donc on verifie la classe de la valleur retourner et on la compare avec le type du resultats de l'operation

                    Si le type du resultats de l'operarion est un String on s'attend a un IDF String
                    Si le type du resultats de l'operarion est un Int on s'attend a un IDF ou Constante Int
                    Si le type du resultats de l'operarion est un Float on verifie uniquement qu'il ne s'aggit pas d'un idf de type String

                */

                if (resultats.getType().equals("StringCompil")){
                    // dans se cas le idf (resultats) est de type String et il doit recevoir un idf de type string

                    if(!(operande instanceof Idf_String)){
                        semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " doit etre assigner avec un String ");
                    }
                } else if (resultats.getType().equals("intCompil")){
                    // dans se cas on auras un probleme dans le cas ou l'operande est un float ou un string
                    if(!(operande instanceof Idf_int || operande instanceof ConstanteInteger)){
                        semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " doit etre assigner avec un Entier ");
                    }
                } else {
                    // dans se cas il s'aggit d'un float et le seul probleme est si on a un IDF (operande) String
                    if(operande instanceof Idf_String){
                        semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " est un floatCompil il ne peut pas prendre la valleur d'un StringCompil");
                    }
                }
            }
        } else {
            visitChildren(ctx);
        }
        return null;
    }
}
