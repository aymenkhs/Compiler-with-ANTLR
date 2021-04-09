import generated_files.tiny_parserBaseVisitor;
import generated_files.tiny_parserParser;

import java.util.ArrayList;

import nodes.*;
import org.antlr.v4.runtime.Token;


public class Routines extends tiny_parserBaseVisitor<Node>{

    private final ArrayList<String> semanticErrors;

    private final ArrayList<String> warnings;

    private final SymbolesTable table_Symboles;

    public Routines(SymbolesTable table_Symboles) {
        this.semanticErrors = new ArrayList<>();
        this.warnings = new ArrayList<>();
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
        resultats.initialize();
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
                        - or an int or a float in which case we check that the type of the result is int or float
                    (a float accept an integer value and is automatically casted to an int if asigned to an int)
                */
                Node operande = visitOperation_mere(ctx.operation_mere());
                if (operande == null){
                    return null;
                }

                /*  visitOperation_mere vas retourner un fils de nodes, qui sera soit:
                        - un IDF_Int ou IDF_Float ou IDF_String dans le cas ou il n'y a pas d'operation
                        - un ConstanteInteger ou ConstanteReal dan le cas d'une operation ou d'assignement a une constante
                        - null dans le cas ou il y a un IDF de type String dans l'operation

                    donc on verifie la classe de la valleur retourner et on la compare avec le type du resultats de l'operation

                    Si le type du resultats de l'operarion est un String on s'attend a un IDF String
                    Si le type du resultats de l'operarion est un Int ou Float on verifie uniquement qu'il ne s'aggit pas d'un idf de type String
                */

                if (resultats.getType().equals("StringCompil")){
                    // dans se cas le idf (resultats) est de type String et il doit recevoir un idf de type string

                    if(!(operande instanceof Idf_String)){
                        semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " doit etre assigner avec un String ");
                    }
                } else {
                    // dans se cas il s'aggit d'un float ou int et le seul probleme est si on a un IDF (operande) String
                    if(operande instanceof Idf_String){
                        semanticErrors.add("IDF \"" + idf_name + "\" a la ligne " + row + " est un "+ resultats.getType() +" il ne peut pas prendre la valleur d'un StringCompil");
                    }
                }
            }
        } else {
            visitChildren(ctx);
        }
        return null;
    }

    @Override
    public Node visitOperation_mere(tiny_parserParser.Operation_mereContext ctx) {

        if (ctx.operation_mere() != null){
            Node operande1 = visitOperation_mere(ctx.operation_mere());
            Node operande2 = visitOperation_fils(ctx.operation_fils());
            if (operande1 == null || operande2 == null){
                return null;
            }

            if (operande1 instanceof Idf_String || operande2 instanceof Idf_String){
                int row = ctx.start.getLine();
                semanticErrors.add("ligne : " + row + ", un StringCompil ne peut pas etre dans une operation ");
                return null;
            }

            if (operande1 instanceof Idf_float || operande2 instanceof Idf_float || operande1 instanceof ConstanteReal
                    || operande2 instanceof ConstanteReal){
                return new ConstanteReal();
            } else {
                return new ConstanteInteger();
            }

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public Node visitOperation_fils(tiny_parserParser.Operation_filsContext ctx) {

        if (ctx.operation_fils() != null){
            Node operande1 = visitOperation_fils(ctx.operation_fils());
            Node operande2 = visitOperation_gf(ctx.operation_gf());

            if (operande1 == null || operande2 == null){
                return null;
            }

            if (operande1 instanceof Idf_String || operande2 instanceof Idf_String){
                int row = ctx.start.getLine();
                semanticErrors.add("ligne : " + row + ", un StringCompil ne peut pas etre dans une operation ");
                return null;
            }

            if (ctx.DIV() != null){
                return new ConstanteReal();
            }

            if (operande1 instanceof Idf_float || operande2 instanceof Idf_float || operande1 instanceof ConstanteReal
                    || operande2 instanceof ConstanteReal){
                return new ConstanteReal();
            } else {
                return new ConstanteInteger();
            }
        } else {
            return visitChildren(ctx);
        }

    }

    @Override
    public Node visitOperation_gf(tiny_parserParser.Operation_gfContext ctx) {

        if (ctx.operation_gf() != null){
            Node node = visitOperation_gf(ctx.operation_gf());

            if (node == null){
                return null;
            }

            if(node instanceof Idf_String){
                int row = ctx.start.getLine();
                semanticErrors.add("ligne : " + row + ", un StringCompil ne peut pas etre dans une operation ");
                return null;
            } else if (node instanceof Idf_int){
                return new ConstanteInteger();
            } else if (node instanceof Idf_float){
                return new ConstanteReal();
            }

            return node;
        } else if (ctx.operation_mere() != null){
            Node node = visitOperation_mere(ctx.operation_mere());

            if (node == null){
                return null;
            }

            if(node instanceof Idf_String){
                int row = ctx.start.getLine();
                semanticErrors.add("ligne : " + row + ", un StringCompil ne peut pas etre dans une operation ");
                return null;
            }

            return node;
        } else {
            return visitOperande(ctx.operande());
        }
    }

    @Override
    public Node visitOperande(tiny_parserParser.OperandeContext ctx) {

        if(ctx.IDF() != null){
            Token idToken = ctx.IDF().getSymbol();
            int row = idToken.getLine();
            int column = idToken.getCharPositionInLine();
            String idf_name = ctx.IDF().getText();

            IDF idf = check_declarer(idf_name, row, column);

            if (!(idf instanceof IdfUndeclared) && !idf.isInitialized()){
                // we check if the value is not initialized in which case we put a warning
                warnings.add("ligne : " + row + ", IDF "+ idf.getName() + " utiliser avant initialisation.");
            }

            return idf;
        } else if (ctx.INTEGER() != null){
            return new ConstanteInteger();
        } else {
            return new ConstanteReal();
        }
    }

    @Override
    public Node visitScan(tiny_parserParser.ScanContext ctx) {

        Token idToken = ctx.IDF().getSymbol();
        int row = idToken.getLine();
        int column = idToken.getCharPositionInLine();
        String idf_name = ctx.IDF().getText();

        IDF idf = check_declarer(idf_name, row, column);
        idf.initialize();
        return idf;
    }
}

