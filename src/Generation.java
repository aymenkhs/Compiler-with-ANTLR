
import org.antlr.v4.runtime.tree.ParseTree;

import generated_files.tiny_parserParser;
import generated_files.tiny_parserBaseVisitor;

import nodes.*;

public class Generation extends tiny_parserBaseVisitor<Node> {

    private Quadruplets quadruplets;

    public Generation() {
        super();
        this.quadruplets = new Quadruplets();
    }

    public Quadruplets getQuadruplets() {
        return quadruplets;
    }

    @Override
    public Node visitAssignment(tiny_parserParser.AssignmentContext ctx) {
        String idf = ctx.getChild(0).getText();
        String var = ctx.getChild(2).getText();


        visitChildren(ctx);
        //System.out.println(idf + "=" + var);
        return null;
    }

    @Override
    public Node visitOperation_mere(tiny_parserParser.Operation_mereContext ctx) {

        if (ctx.operation_mere() != null){
            Node operande1 = visitOperation_mere(ctx.operation_mere());
            Node operande2 = visitOperation_fils(ctx.operation_fils());
            QuadElement quad = quadruplets.addQuad(ctx.getChild(1).getText(), operande1, operande2, new Temporaire());
            System.out.println(quad);
            return quad.getResultats();
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public Node visitOperation_fils(tiny_parserParser.Operation_filsContext ctx) {

        if (ctx.operation_fils() != null){
            Node operande1 = visitOperation_fils(ctx.operation_fils());
            Node operande2 = visitOperation_gf(ctx.operation_gf());
            QuadElement quad = quadruplets.addQuad(ctx.getChild(1).getText(), operande1, operande2, new Temporaire());
            System.out.println(quad);
            return quad.getResultats();
        } else {
            return visitChildren(ctx);
        }

    }

    @Override
    public Node visitOperation_gf(tiny_parserParser.Operation_gfContext ctx) {

        if (ctx.operation_gf() != null){
            Node operande1 = visitOperation_gf(ctx.operation_gf());
            QuadElement quad = quadruplets.addQuad(ctx.getChild(0).getText(), operande1, null, new Temporaire());
            System.out.println(quad);
            return quad.getResultats();
        } else if (ctx.operation_mere() != null){
            return visitOperation_mere(ctx.operation_mere());
        } else {
            return visitOperande(ctx.operande());
        }
    }

    @Override
    public Node visitOperande(tiny_parserParser.OperandeContext ctx) {

        if(ctx.IDF() != null){
            return new IDF(ctx.getChild(0).getText());
        } else if (ctx.INTEGER() != null){
            return new ConstanteInteger("int", Integer.parseInt(ctx.getChild(0).getText()));
        } else {
            return new ConstanteReal("real", Float.parseFloat(ctx.getChild(0).getText()));
        }
    }



}
