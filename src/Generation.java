import generated_files.tiny_parserParser;

import generated_files.tiny_parserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;


public class Generation<Integer> extends tiny_parserBaseVisitor<Integer> {

    private Quadruplets quadruplets;

    @Override
    public Integer visitAssignment(tiny_parserParser.AssignmentContext ctx) {
        String idf = ctx.getChild(0).getText();
        String var = ctx.getChild(2).getText();


        Integer t = visitChildren(ctx);
        //System.out.println(idf + "=" + var);
        return t;
    }

    @Override
    public Integer visitOperation_mere(tiny_parserParser.Operation_mereContext ctx) {

        if (ctx.children.size() == 3){
            System.out.println("cas 1 :\n\topeartion 1: " + ctx.getChild(0).getText() + "\n\topeartion 2: " + ctx.getChild(1).getText() + "\n\topeartion 3: "  + ctx.getChild(2).getText());
        } else {
            System.out.println("cas 2 " + ctx.getChild(0).getText() );
        }

        return super.visitOperation_mere(ctx);
    }



}
