import generated_files.tiny_parserParser;

import generated_files.tiny_parserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.Integer;


public class Generation extends tiny_parserBaseVisitor<String> {

    private Quadruplets quadruplets;

    private int compteur;

    @Override
    public String visitAssignment(tiny_parserParser.AssignmentContext ctx) {
        String idf = ctx.getChild(0).getText();
        String var = ctx.getChild(2).getText();


        visitChildren(ctx);
        //System.out.println(idf + "=" + var);
        return null;
    }

    @Override
    public String visitOperation_mere(tiny_parserParser.Operation_mereContext ctx) {
        /* Integer T =  super.visitOperation_mere(ctx);
        if (ctx.children.size() == 3){
            System.out.println("cas 1 :\n\topeartion 1: " + ctx.getChild(0).getText() + "\n\topeartion 2: " + ctx.getChild(1).getText() + "\n\topeartion 3: "  + ctx.getChild(2).getText());
        } else if (ctx.children.size() == 2){
            System.out.println("cas 2 :\n\topeartion 1: " + ctx.getChild(0).getText() + "\n\topeartion 2: " + ctx.getChild(1).getText());
        }
        */

        if (ctx.operation_mere() != null){
            String temp1 = visitOperation_mere(ctx.operation_mere());
            String temp2 = visitOperation_fils(ctx.operation_fils());
            System.out.println("(" + ctx.getChild(1).getText() + ", " + temp1 + ", " + temp2 + ", T" + compteur + ")" );
            compteur++;
            return "T" + (compteur-1);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public String visitOperation_fils(tiny_parserParser.Operation_filsContext ctx) {
        /*
        super.visitOperation_fils(ctx);

        if (ctx.children.size() == 3){
            System.out.println("cas 3 :\n\topeartion 1: " + ctx.getChild(0).getText() + "\n\topeartion 2: " + ctx.getChild(1).getText() + "\n\topeartion 3: "  + ctx.getChild(2).getText());
        }*/

        if (ctx.operation_fils() != null){
            String temp1 = visitOperation_fils(ctx.operation_fils());
            String temp2 = visitOperation_gf(ctx.operation_gf());
            System.out.println("(" + ctx.getChild(1).getText() + ", " + temp1 + ", " + temp2 + ", T" + compteur + ")" );
            compteur++;
            return "T" + (compteur-1);
        } else {
            return visitChildren(ctx);
        }

    }

    @Override
    public String visitOperation_gf(tiny_parserParser.Operation_gfContext ctx) {
        /*Integer T =  super.visitOperation_gf(ctx);
        if (ctx.children.size() == 3){
            System.out.println("cas 4 :\n\topeartion 1: " + ctx.getChild(0).getText() + "\n\topeartion 2: " + ctx.getChild(1).getText() + "\n\topeartion 3: "  + ctx.getChild(2).getText());
        } else if (ctx.children.size() == 2){
            System.out.println("cas 5 :\n\topeartion 1: " + ctx.getChild(0).getText() + "\n\topeartion 2: " + ctx.getChild(1).getText());
        }*/

        if (ctx.operation_gf() != null){
            String temp = visitOperation_gf(ctx.operation_gf());
            System.out.println("(" + ctx.getChild(0).getText() + " ," + temp + " , , T" + compteur + ")" );
            compteur++;
            return "T" + (compteur-1);
        } else if (ctx.operation_mere() != null){
            return visitOperation_mere(ctx.operation_mere());
        } else {
            return visitOperande(ctx.operande());
        }
    }

    @Override
    public String visitOperande(tiny_parserParser.OperandeContext ctx) {
        /*Integer T =  super.visitOperande(ctx);
        System.out.println("cas 6 :" + ctx.getChild(0).getText());
        */
        return ctx.getChild(0).getText();
    }



}
