// Generated from C:/Users/youcef/Documents/GitHub/CompileP/TinyLanguage_SII/src\tiny_parser.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tiny_parserParser}.
 */
public interface tiny_parserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(tiny_parserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(tiny_parserParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(tiny_parserParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(tiny_parserParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#declaration_type}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_type(tiny_parserParser.Declaration_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#declaration_type}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_type(tiny_parserParser.Declaration_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(tiny_parserParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(tiny_parserParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#idf_dec}.
	 * @param ctx the parse tree
	 */
	void enterIdf_dec(tiny_parserParser.Idf_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#idf_dec}.
	 * @param ctx the parse tree
	 */
	void exitIdf_dec(tiny_parserParser.Idf_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(tiny_parserParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(tiny_parserParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(tiny_parserParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(tiny_parserParser.InstContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(tiny_parserParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(tiny_parserParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#condition_mere}.
	 * @param ctx the parse tree
	 */
	void enterCondition_mere(tiny_parserParser.Condition_mereContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#condition_mere}.
	 * @param ctx the parse tree
	 */
	void exitCondition_mere(tiny_parserParser.Condition_mereContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(tiny_parserParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(tiny_parserParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#operation_mere}.
	 * @param ctx the parse tree
	 */
	void enterOperation_mere(tiny_parserParser.Operation_mereContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#operation_mere}.
	 * @param ctx the parse tree
	 */
	void exitOperation_mere(tiny_parserParser.Operation_mereContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#operation_fils}.
	 * @param ctx the parse tree
	 */
	void enterOperation_fils(tiny_parserParser.Operation_filsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#operation_fils}.
	 * @param ctx the parse tree
	 */
	void exitOperation_fils(tiny_parserParser.Operation_filsContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#operation_gf}.
	 * @param ctx the parse tree
	 */
	void enterOperation_gf(tiny_parserParser.Operation_gfContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#operation_gf}.
	 * @param ctx the parse tree
	 */
	void exitOperation_gf(tiny_parserParser.Operation_gfContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#operande}.
	 * @param ctx the parse tree
	 */
	void enterOperande(tiny_parserParser.OperandeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#operande}.
	 * @param ctx the parse tree
	 */
	void exitOperande(tiny_parserParser.OperandeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(tiny_parserParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(tiny_parserParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#printcontent}.
	 * @param ctx the parse tree
	 */
	void enterPrintcontent(tiny_parserParser.PrintcontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#printcontent}.
	 * @param ctx the parse tree
	 */
	void exitPrintcontent(tiny_parserParser.PrintcontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#scan}.
	 * @param ctx the parse tree
	 */
	void enterScan(tiny_parserParser.ScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#scan}.
	 * @param ctx the parse tree
	 */
	void exitScan(tiny_parserParser.ScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(tiny_parserParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(tiny_parserParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#else_if}.
	 * @param ctx the parse tree
	 */
	void enterElse_if(tiny_parserParser.Else_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#else_if}.
	 * @param ctx the parse tree
	 */
	void exitElse_if(tiny_parserParser.Else_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#then}.
	 * @param ctx the parse tree
	 */
	void enterThen(tiny_parserParser.ThenContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#then}.
	 * @param ctx the parse tree
	 */
	void exitThen(tiny_parserParser.ThenContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(tiny_parserParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(tiny_parserParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link tiny_parserParser#do_while}.
	 * @param ctx the parse tree
	 */
	void enterDo_while(tiny_parserParser.Do_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link tiny_parserParser#do_while}.
	 * @param ctx the parse tree
	 */
	void exitDo_while(tiny_parserParser.Do_whileContext ctx);
}