// Generated from C:/Users/youcef/Documents/GitHub/CompileP/TinyLanguage_SII/src\tiny_parser.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tiny_parserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tiny_parserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(tiny_parserParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(tiny_parserParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#declaration_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_type(tiny_parserParser.Declaration_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(tiny_parserParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#idf_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdf_dec(tiny_parserParser.Idf_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(tiny_parserParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(tiny_parserParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(tiny_parserParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#condition_mere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_mere(tiny_parserParser.Condition_mereContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(tiny_parserParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#operation_mere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation_mere(tiny_parserParser.Operation_mereContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#operation_fils}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation_fils(tiny_parserParser.Operation_filsContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#operation_gf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation_gf(tiny_parserParser.Operation_gfContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#operande}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperande(tiny_parserParser.OperandeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(tiny_parserParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#printcontent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintcontent(tiny_parserParser.PrintcontentContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#scan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan(tiny_parserParser.ScanContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(tiny_parserParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#else_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if(tiny_parserParser.Else_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#then}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen(tiny_parserParser.ThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(tiny_parserParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tiny_parserParser#do_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_while(tiny_parserParser.Do_whileContext ctx);
}