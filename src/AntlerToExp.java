import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class AntlerToExp extends tiny_parserBaseVisitor {

    private ArrayList<String> vars;
     ArrayList<String> semanticErrors;

    public AntlerToExp() {
        this.vars = new ArrayList<String>();
        this.semanticErrors = new ArrayList<String>();
    }

    @Override
    public Object visitProgram(tiny_parserParser.ProgramContext ctx) {
        System.out.println("NOOB?");
        return super.visitProgram(ctx);
    }

    @Override
    public Object visitDeclarations(tiny_parserParser.DeclarationsContext ctx) {
        return super.visitDeclarations(ctx);
    }

    @Override
    public Object visitDeclaration_type(tiny_parserParser.Declaration_typeContext ctx) {
        return super.visitDeclaration_type(ctx);
    }

    @Override
    public Object visitType(tiny_parserParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Object visitIdf_dec(tiny_parserParser.Idf_decContext ctx) {
        Token idToken=ctx.IDF().getSymbol();

        int line=idToken.getLine();
        int column=idToken.getCharPositionInLine();

        String var=ctx.getChild(0).getText();
        if(vars.contains(var)){
            semanticErrors.add("variable : "+var+" ALRDY DEClARED! at line "+line+" column "+column);
        }
        else {
            vars.add(var);
        }
        return var;
    }

    @Override
    public Object visitInstructions(tiny_parserParser.InstructionsContext ctx) {
        return super.visitInstructions(ctx);
    }

    @Override
    public Object visitInst(tiny_parserParser.InstContext ctx) {
        return super.visitInst(ctx);
    }

    @Override
    public Object visitAssignment(tiny_parserParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public Object visitCondition_mere(tiny_parserParser.Condition_mereContext ctx) {
        return super.visitCondition_mere(ctx);
    }

    @Override
    public Object visitCondition(tiny_parserParser.ConditionContext ctx) {
        return super.visitCondition(ctx);
    }

    @Override
    public Object visitOperation_mere(tiny_parserParser.Operation_mereContext ctx) {
        return super.visitOperation_mere(ctx);
    }

    @Override
    public Object visitOperation_fils(tiny_parserParser.Operation_filsContext ctx) {
        return super.visitOperation_fils(ctx);
    }

    @Override
    public Object visitOperation_gf(tiny_parserParser.Operation_gfContext ctx) {
        return super.visitOperation_gf(ctx);
    }

    @Override
    public Object visitOperande(tiny_parserParser.OperandeContext ctx) {
        return super.visitOperande(ctx);
    }

    @Override
    public Object visitPrint(tiny_parserParser.PrintContext ctx) {
        return super.visitPrint(ctx);
    }

    @Override
    public Object visitPrintcontent(tiny_parserParser.PrintcontentContext ctx) {
        return super.visitPrintcontent(ctx);
    }

    @Override
    public Object visitScan(tiny_parserParser.ScanContext ctx) {
        return super.visitScan(ctx);
    }

    @Override
    public Object visitIf_statement(tiny_parserParser.If_statementContext ctx) {
        return super.visitIf_statement(ctx);
    }

    @Override
    public Object visitElse_if(tiny_parserParser.Else_ifContext ctx) {
        return super.visitElse_if(ctx);
    }

    @Override
    public Object visitThen(tiny_parserParser.ThenContext ctx) {
        return super.visitThen(ctx);
    }

    @Override
    public Object visitElse_statement(tiny_parserParser.Else_statementContext ctx) {
        return super.visitElse_statement(ctx);
    }

    @Override
    public Object visitDo_while(tiny_parserParser.Do_whileContext ctx) {
        return super.visitDo_while(ctx);
    }
}
