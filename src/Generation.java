
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
        Node operande;
        IDF resultats = new IDF(ctx.getChild(0).getText());

        if (ctx.STRING() != null){
            operande = new ConstanteString("string", ctx.getChild(2).getText());
        } else {
            operande = visitOperation_mere(ctx.operation_mere());
        }

        QuadElement quad = quadruplets.addQuad(ctx.getChild(1).getText(), operande, null, resultats);
        quad = quadruplets.optimizeLastAssignement();
        return quad.getResultats();
    }

    @Override
    public Node visitCondition(tiny_parserParser.ConditionContext ctx) {
        Node operande1 = visitOperation_mere(ctx.operation_mere().get(0));
        Node operande2 = visitOperation_mere(ctx.operation_mere().get(1));
        Temporaire results = new Temporaire();
        QuadElement quadCond = quadruplets.addQuad(ctx.getChild(1).getText(), operande1, operande2, null);
        quadruplets.addQuad("=", new ConstanteBoolean("bool", false), null, results);
        QuadElement quadBR = quadruplets.addQuad("BR", null, null, null);
        QuadElement quadFinCond = quadruplets.addQuad("=", null, null, results);
        quadCond.setResultats(new AdresseQuad(quadFinCond.getNum()));
        quadBR.setResultats(new AdresseQuad(quadFinCond.getNum()+1));
        return results;
    }

    @Override
    public Node visitOperation_mere(tiny_parserParser.Operation_mereContext ctx) {

        if (ctx.operation_mere() != null){
            Node operande1 = visitOperation_mere(ctx.operation_mere());
            Node operande2 = visitOperation_fils(ctx.operation_fils());
            QuadElement quad = quadruplets.addQuad(ctx.getChild(1).getText(), operande1, operande2, new Temporaire());
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

    @Override
    public Node visitPrint(tiny_parserParser.PrintContext ctx) {
        Node operande = visitPrintcontent(ctx.printcontent());
        QuadElement quad = quadruplets.addQuad("print", null, null, operande);
        return quad.getResultats();
    }

    @Override
    public Node visitPrintcontent(tiny_parserParser.PrintcontentContext ctx) {
        if (ctx.STRING() != null){
            return new ConstanteString("string", ctx.getChild(2).getText());
        } else {
            Node n =  visitOperation_mere(ctx.operation_mere());
            return n;
        }
    }

    @Override
    public Node visitScan(tiny_parserParser.ScanContext ctx) {
        IDF idf = new IDF(ctx.getChild(2).getText());
        QuadElement quad = quadruplets.addQuad("scan", null, null, idf);
        return quad.getResultats();
    }

    @Override
    public Node visitIf_statement(tiny_parserParser.If_statementContext ctx) {
        Node resultCond = visitCondition(ctx.condition());

        QuadElement quadIF = quadruplets.addQuad("BZ", resultCond, null, null);
        // we'll store this quad then we'll put the adresse of the jump in the operande 2

        if (!ctx.else_if().isEmpty()){
            // get the number of else if
            System.out.println( "there is at least one else if" );
        }

        if (ctx.else_statement() != null){
            // we treate the else
            System.out.println( "there is an else" );
        }

        return null;
    }
}
