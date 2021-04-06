
import org.antlr.v4.runtime.tree.ParseTree;

import generated_files.tiny_parserParser;
import generated_files.tiny_parserBaseVisitor;

import nodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Generation extends tiny_parserBaseVisitor<Node> {

    private static HashMap<String,String> comparators;

    private Quadruplets quadruplets;

    private Stack<AdresseQuad> do_while_LIFO;

    public Generation() {
        super();
        this.quadruplets = new Quadruplets();
        this.do_while_LIFO = new Stack<>();
    }

    public Quadruplets getQuadruplets() {
        return quadruplets;
    }

    @Override
    public Node visitAssignment(tiny_parserParser.AssignmentContext ctx) {
        Node operande;
        IdfQuad resultats = new IdfQuad(ctx.getChild(0).getText());

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
        String operateur = Generation.comparators.get(ctx.getChild(1).getText());

        QuadElement quadCond = quadruplets.addQuad(operateur, operande1, operande2, null);
        quadruplets.addQuad("=", new ConstanteBoolean("bool", false), null, results);
        QuadElement quadBR = quadruplets.addQuad("BR", null, null, null);
        QuadElement quadFinCond = quadruplets.addQuad("=", new ConstanteBoolean("bool", true), null, results);
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
            return new IdfQuad(ctx.getChild(0).getText());
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
        IDF IdfQuad = new IdfQuad(ctx.getChild(2).getText());
        QuadElement quad = quadruplets.addQuad("scan", null, null, IdfQuad);
        return quad.getResultats();
    }

    @Override
    public Node visitIf_statement(tiny_parserParser.If_statementContext ctx) {
        AdresseQuad addresseLastBZ = null;
        AdresseQuad adresseFinIF;
        ArrayList<QuadElement> else_ifELements = new ArrayList<>();

        Node resultCond = visitCondition(ctx.condition());

        QuadElement quadIF = quadruplets.addQuad("BZ", resultCond, null, null);

        visitThen(ctx.then());

        if (ctx.else_if().isEmpty() && ctx.else_statement() == null){
            quadIF.setResultats(new AdresseQuad(quadruplets.size()));
        } else {
            quadIF.setResultats(new AdresseQuad(quadruplets.size()+1));
            QuadElement QuadENDIF = quadruplets.addQuad("BR", null, null, null);
            for (tiny_parserParser.Else_ifContext elseIF : ctx.else_if()){
                addresseLastBZ = (AdresseQuad) visitElse_if(elseIF);
                else_ifELements.add(quadruplets.addQuad("BR", null, null, null));
            }

            if (ctx.else_statement() != null){
                visitElse_statement(ctx.else_statement());
                adresseFinIF = new AdresseQuad(quadruplets.size());
            } else {
                quadruplets.removeLastBR();
                adresseFinIF = new AdresseQuad(quadruplets.size());
                
                if(!ctx.else_if().isEmpty()){
                    addresseLastBZ.decrementAdresse();
                }
                
            }

            QuadENDIF.setResultats(adresseFinIF);
            for (QuadElement quad: else_ifELements){
                quad.setResultats(adresseFinIF);
            }
        }

        return null;
    }

    @Override
    public Node visitElse_if(tiny_parserParser.Else_ifContext ctx) {
        Node resultCond = visitCondition(ctx.condition());
        QuadElement quadIF = quadruplets.addQuad("BZ", resultCond, null, null);
        visitThen(ctx.then());
        quadIF.setResultats(new AdresseQuad(quadruplets.size()+1));
        return quadIF.getResultats();
    }

    @Override
    public Node visitDo_while(tiny_parserParser.Do_whileContext ctx) {
        do_while_LIFO.push(new AdresseQuad(quadruplets.size()));
        visitInstructions(ctx.instructions());
        Node resultCond = visitCondition(ctx.condition());
        quadruplets.addQuad("BNZ", resultCond, null, do_while_LIFO.pop());
        return null;
    }


    public static void initComparators(){
        comparators = new HashMap<>();
        comparators.put("==", "BE");
        comparators.put("!=", "BNE");
        comparators.put("<>", "BNE");
        comparators.put(">=", "BGE");
        comparators.put(">", "BG");
        comparators.put("<=", "BLE");
        comparators.put("<", "BL");
    }
}
