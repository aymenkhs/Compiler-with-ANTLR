import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class AntlerToExp extends tiny_parserBaseVisitor {

     private ArrayList<String> vars;
     private ArrayList<String> semanticErrors;
     private ArrayList<IDF> symbol_table;

    public ArrayList<String> getVars() {
        return vars;
    }

    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
    }

    public ArrayList<IDF> getSymbol_table() {
        return symbol_table;
    }

    public AntlerToExp() {
        this.vars = new ArrayList<String>();
        this.semanticErrors = new ArrayList<String>();
        this.symbol_table =new ArrayList<IDF>();
    }

    public IDF chose_type(String type,String name){
        if(type.equals("intCompil")){
            Idf_int var= new Idf_int(type,name);
            return var;
        }
        else if(type.equals("floatCompil")){
            Idf_float var= new Idf_float(type,name);
            return var;
        }
        else {
            Idf_String var= new Idf_String(type,name);
            return var;
        }

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
        Token idToken=ctx.idf_dec().IDF().getSymbol();

        int line=idToken.getLine();
        int column=idToken.getCharPositionInLine();


        String type=ctx.getChild(0).getText();
        String names=ctx.getChild(1).getText();
        String[] array = names.split(",");

        for(int i=0;i<array.length;i++){
            IDF var=chose_type(type,array[i]);

            if(vars.contains(var.getName())){
                semanticErrors.add("variable : "+var.getName()+" ALRDY DEClARED! at line "+line+" column "+column);
            }
            else {
                vars.add(var.getName());
                symbol_table.add(var);
            }
        }

        return super.visitDeclaration_type(ctx);
    }

    @Override
    public Object visitType(tiny_parserParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Object visitIdf_dec(tiny_parserParser.Idf_decContext ctx) {
        return super.visitIdf_dec(ctx);
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
