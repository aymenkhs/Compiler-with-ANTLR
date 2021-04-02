// Generated from C:/Users/aymen/Documents/SII/tpcompil/TinyLanguage_SII/src/grammar\tiny_parser.g4 by ANTLR 4.9.1
package generated_files;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tiny_parserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, INTEGER=20, REAL=21, PRODUCT=22, DIV=23, PLUS=24, 
		MINUS=25, AFFECTATION=26, COMPARAISON=27, IDF=28, PROGRAMNAME=29, WHITESPACE=30, 
		NEWLINE=31, STRING=32, INLINECOMMENT=33, BLOCKCOMMENT=34;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_declaration_type = 2, RULE_type = 3, 
		RULE_idf_dec = 4, RULE_instructions = 5, RULE_inst = 6, RULE_assignment = 7, 
		RULE_condition = 8, RULE_operation_mere = 9, RULE_operation_fils = 10, 
		RULE_operation_gf = 11, RULE_operande = 12, RULE_print = 13, RULE_printcontent = 14, 
		RULE_scan = 15, RULE_if_statement = 16, RULE_else_if = 17, RULE_then = 18, 
		RULE_else_statement = 19, RULE_do_while = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "declaration_type", "type", "idf_dec", "instructions", 
			"inst", "assignment", "condition", "operation_mere", "operation_fils", 
			"operation_gf", "operande", "print", "printcontent", "scan", "if_statement", 
			"else_if", "then", "else_statement", "do_while"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'compil'", "'('", "')'", "'{'", "'start'", "'}'", "';'", "'intCompil'", 
			"'floatCompil'", "'StringCompil'", "','", "'printCompil'", "'scanCompil'", 
			"'if'", "'else if'", "'then'", "'else'", "'do'", "'while'", null, null, 
			"'*'", "'/'", "'+'", "'-'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "INTEGER", "REAL", "PRODUCT", 
			"DIV", "PLUS", "MINUS", "AFFECTATION", "COMPARAISON", "IDF", "PROGRAMNAME", 
			"WHITESPACE", "NEWLINE", "STRING", "INLINECOMMENT", "BLOCKCOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "tiny_parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tiny_parserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAMNAME() { return getToken(tiny_parserParser.PROGRAMNAME, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(43);
			match(PROGRAMNAME);
			setState(44);
			match(T__1);
			setState(45);
			match(T__2);
			setState(46);
			match(T__3);
			setState(47);
			declarations();
			setState(48);
			match(T__4);
			setState(49);
			instructions();
			setState(50);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public Declaration_typeContext declaration_type() {
			return getRuleContext(Declaration_typeContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				declaration_type();
				setState(54);
				declarations();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				declaration_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaration_typeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Idf_decContext idf_dec() {
			return getRuleContext(Idf_decContext.class,0);
		}
		public Declaration_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitDeclaration_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_typeContext declaration_type() throws RecognitionException {
		Declaration_typeContext _localctx = new Declaration_typeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			type();
			setState(60);
			idf_dec();
			setState(61);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Idf_decContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(tiny_parserParser.IDF, 0); }
		public Idf_decContext idf_dec() {
			return getRuleContext(Idf_decContext.class,0);
		}
		public Idf_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idf_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitIdf_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Idf_decContext idf_dec() throws RecognitionException {
		Idf_decContext _localctx = new Idf_decContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_idf_dec);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(IDF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(IDF);
				setState(67);
				match(T__10);
				setState(68);
				idf_dec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionsContext extends ParserRuleContext {
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructions);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				inst();
				setState(73);
				instructions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				inst();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ScanContext scan() {
			return getRuleContext(ScanContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Do_whileContext do_while() {
			return getRuleContext(Do_whileContext.class,0);
		}
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inst);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDF:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				assignment();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				print();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				scan();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				if_statement();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				do_while();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(tiny_parserParser.IDF, 0); }
		public TerminalNode AFFECTATION() { return getToken(tiny_parserParser.AFFECTATION, 0); }
		public Operation_mereContext operation_mere() {
			return getRuleContext(Operation_mereContext.class,0);
		}
		public TerminalNode STRING() { return getToken(tiny_parserParser.STRING, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(IDF);
			setState(86);
			match(AFFECTATION);
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case INTEGER:
			case REAL:
			case PLUS:
			case MINUS:
			case IDF:
				{
				setState(87);
				operation_mere();
				}
				break;
			case STRING:
				{
				setState(88);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(91);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<Operation_mereContext> operation_mere() {
			return getRuleContexts(Operation_mereContext.class);
		}
		public Operation_mereContext operation_mere(int i) {
			return getRuleContext(Operation_mereContext.class,i);
		}
		public TerminalNode COMPARAISON() { return getToken(tiny_parserParser.COMPARAISON, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			operation_mere();
			setState(94);
			match(COMPARAISON);
			setState(95);
			operation_mere();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operation_mereContext extends ParserRuleContext {
		public Operation_filsContext operation_fils() {
			return getRuleContext(Operation_filsContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(tiny_parserParser.PLUS, 0); }
		public Operation_mereContext operation_mere() {
			return getRuleContext(Operation_mereContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(tiny_parserParser.MINUS, 0); }
		public Operation_mereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_mere; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitOperation_mere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operation_mereContext operation_mere() throws RecognitionException {
		Operation_mereContext _localctx = new Operation_mereContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operation_mere);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				operation_fils();
				setState(98);
				match(PLUS);
				setState(99);
				operation_mere();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				operation_fils();
				setState(102);
				match(MINUS);
				setState(103);
				operation_mere();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				operation_fils();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operation_filsContext extends ParserRuleContext {
		public Operation_gfContext operation_gf() {
			return getRuleContext(Operation_gfContext.class,0);
		}
		public TerminalNode PRODUCT() { return getToken(tiny_parserParser.PRODUCT, 0); }
		public Operation_filsContext operation_fils() {
			return getRuleContext(Operation_filsContext.class,0);
		}
		public TerminalNode DIV() { return getToken(tiny_parserParser.DIV, 0); }
		public Operation_filsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_fils; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitOperation_fils(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operation_filsContext operation_fils() throws RecognitionException {
		Operation_filsContext _localctx = new Operation_filsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operation_fils);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				operation_gf();
				setState(109);
				match(PRODUCT);
				setState(110);
				operation_fils();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				operation_gf();
				setState(113);
				match(DIV);
				setState(114);
				operation_fils();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				operation_gf();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operation_gfContext extends ParserRuleContext {
		public Operation_mereContext operation_mere() {
			return getRuleContext(Operation_mereContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(tiny_parserParser.MINUS, 0); }
		public Operation_gfContext operation_gf() {
			return getRuleContext(Operation_gfContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(tiny_parserParser.PLUS, 0); }
		public OperandeContext operande() {
			return getRuleContext(OperandeContext.class,0);
		}
		public Operation_gfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_gf; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitOperation_gf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operation_gfContext operation_gf() throws RecognitionException {
		Operation_gfContext _localctx = new Operation_gfContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operation_gf);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__1);
				setState(120);
				operation_mere();
				setState(121);
				match(T__2);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(MINUS);
				setState(124);
				operation_gf();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(PLUS);
				setState(126);
				operation_gf();
				}
				break;
			case INTEGER:
			case REAL:
			case IDF:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				operande();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandeContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(tiny_parserParser.IDF, 0); }
		public TerminalNode INTEGER() { return getToken(tiny_parserParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(tiny_parserParser.REAL, 0); }
		public OperandeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operande; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitOperande(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandeContext operande() throws RecognitionException {
		OperandeContext _localctx = new OperandeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operande);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << REAL) | (1L << IDF))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public PrintcontentContext printcontent() {
			return getRuleContext(PrintcontentContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__11);
			setState(133);
			match(T__1);
			setState(134);
			printcontent();
			setState(135);
			match(T__2);
			setState(136);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintcontentContext extends ParserRuleContext {
		public Operation_mereContext operation_mere() {
			return getRuleContext(Operation_mereContext.class,0);
		}
		public TerminalNode STRING() { return getToken(tiny_parserParser.STRING, 0); }
		public TerminalNode IDF() { return getToken(tiny_parserParser.IDF, 0); }
		public PrintcontentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printcontent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitPrintcontent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintcontentContext printcontent() throws RecognitionException {
		PrintcontentContext _localctx = new PrintcontentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_printcontent);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				operation_mere();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(IDF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScanContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(tiny_parserParser.IDF, 0); }
		public ScanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scan; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitScan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanContext scan() throws RecognitionException {
		ScanContext _localctx = new ScanContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_scan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__12);
			setState(144);
			match(T__1);
			setState(145);
			match(IDF);
			setState(146);
			match(T__2);
			setState(147);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public List<Else_ifContext> else_if() {
			return getRuleContexts(Else_ifContext.class);
		}
		public Else_ifContext else_if(int i) {
			return getRuleContext(Else_ifContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__13);
			setState(150);
			match(T__1);
			setState(151);
			condition();
			setState(152);
			match(T__2);
			setState(153);
			then();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(154);
				else_if();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(160);
				else_statement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_ifContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public Else_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitElse_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_ifContext else_if() throws RecognitionException {
		Else_ifContext _localctx = new Else_ifContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_else_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__14);
			setState(164);
			match(T__1);
			setState(165);
			condition();
			setState(166);
			match(T__2);
			setState(167);
			then();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__15);
			setState(170);
			match(T__3);
			setState(171);
			instructions();
			setState(172);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_statementContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__16);
			setState(175);
			match(T__3);
			setState(176);
			instructions();
			setState(177);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_whileContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Do_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tiny_parserVisitor ) return ((tiny_parserVisitor<? extends T>)visitor).visitDo_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_whileContext do_while() throws RecognitionException {
		Do_whileContext _localctx = new Do_whileContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_do_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__17);
			setState(180);
			match(T__3);
			setState(181);
			instructions();
			setState(182);
			match(T__5);
			setState(183);
			match(T__18);
			setState(184);
			match(T__1);
			setState(185);
			condition();
			setState(186);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00bf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\5\6H\n\6\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\5"+
		"\bV\n\b\3\t\3\t\3\t\3\t\5\t\\\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13m\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\fx\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0083\n\r"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0090\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u009e"+
		"\n\22\f\22\16\22\u00a1\13\22\3\22\5\22\u00a4\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*\2\4\3\2\n\f\4\2\26\27\36\36\2\u00be\2,\3\2\2\2"+
		"\4;\3\2\2\2\6=\3\2\2\2\bA\3\2\2\2\nG\3\2\2\2\fN\3\2\2\2\16U\3\2\2\2\20"+
		"W\3\2\2\2\22_\3\2\2\2\24l\3\2\2\2\26w\3\2\2\2\30\u0082\3\2\2\2\32\u0084"+
		"\3\2\2\2\34\u0086\3\2\2\2\36\u008f\3\2\2\2 \u0091\3\2\2\2\"\u0097\3\2"+
		"\2\2$\u00a5\3\2\2\2&\u00ab\3\2\2\2(\u00b0\3\2\2\2*\u00b5\3\2\2\2,-\7\3"+
		"\2\2-.\7\37\2\2./\7\4\2\2/\60\7\5\2\2\60\61\7\6\2\2\61\62\5\4\3\2\62\63"+
		"\7\7\2\2\63\64\5\f\7\2\64\65\7\b\2\2\65\3\3\2\2\2\66<\3\2\2\2\678\5\6"+
		"\4\289\5\4\3\29<\3\2\2\2:<\5\6\4\2;\66\3\2\2\2;\67\3\2\2\2;:\3\2\2\2<"+
		"\5\3\2\2\2=>\5\b\5\2>?\5\n\6\2?@\7\t\2\2@\7\3\2\2\2AB\t\2\2\2B\t\3\2\2"+
		"\2CH\7\36\2\2DE\7\36\2\2EF\7\r\2\2FH\5\n\6\2GC\3\2\2\2GD\3\2\2\2H\13\3"+
		"\2\2\2IO\3\2\2\2JK\5\16\b\2KL\5\f\7\2LO\3\2\2\2MO\5\16\b\2NI\3\2\2\2N"+
		"J\3\2\2\2NM\3\2\2\2O\r\3\2\2\2PV\5\20\t\2QV\5\34\17\2RV\5 \21\2SV\5\""+
		"\22\2TV\5*\26\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\17"+
		"\3\2\2\2WX\7\36\2\2X[\7\34\2\2Y\\\5\24\13\2Z\\\7\"\2\2[Y\3\2\2\2[Z\3\2"+
		"\2\2\\]\3\2\2\2]^\7\t\2\2^\21\3\2\2\2_`\5\24\13\2`a\7\35\2\2ab\5\24\13"+
		"\2b\23\3\2\2\2cd\5\26\f\2de\7\32\2\2ef\5\24\13\2fm\3\2\2\2gh\5\26\f\2"+
		"hi\7\33\2\2ij\5\24\13\2jm\3\2\2\2km\5\26\f\2lc\3\2\2\2lg\3\2\2\2lk\3\2"+
		"\2\2m\25\3\2\2\2no\5\30\r\2op\7\30\2\2pq\5\26\f\2qx\3\2\2\2rs\5\30\r\2"+
		"st\7\31\2\2tu\5\26\f\2ux\3\2\2\2vx\5\30\r\2wn\3\2\2\2wr\3\2\2\2wv\3\2"+
		"\2\2x\27\3\2\2\2yz\7\4\2\2z{\5\24\13\2{|\7\5\2\2|\u0083\3\2\2\2}~\7\33"+
		"\2\2~\u0083\5\30\r\2\177\u0080\7\32\2\2\u0080\u0083\5\30\r\2\u0081\u0083"+
		"\5\32\16\2\u0082y\3\2\2\2\u0082}\3\2\2\2\u0082\177\3\2\2\2\u0082\u0081"+
		"\3\2\2\2\u0083\31\3\2\2\2\u0084\u0085\t\3\2\2\u0085\33\3\2\2\2\u0086\u0087"+
		"\7\16\2\2\u0087\u0088\7\4\2\2\u0088\u0089\5\36\20\2\u0089\u008a\7\5\2"+
		"\2\u008a\u008b\7\t\2\2\u008b\35\3\2\2\2\u008c\u0090\5\24\13\2\u008d\u0090"+
		"\7\"\2\2\u008e\u0090\7\36\2\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2"+
		"\u008f\u008e\3\2\2\2\u0090\37\3\2\2\2\u0091\u0092\7\17\2\2\u0092\u0093"+
		"\7\4\2\2\u0093\u0094\7\36\2\2\u0094\u0095\7\5\2\2\u0095\u0096\7\t\2\2"+
		"\u0096!\3\2\2\2\u0097\u0098\7\20\2\2\u0098\u0099\7\4\2\2\u0099\u009a\5"+
		"\22\n\2\u009a\u009b\7\5\2\2\u009b\u009f\5&\24\2\u009c\u009e\5$\23\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5(\25\2\u00a3"+
		"\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4#\3\2\2\2\u00a5\u00a6\7\21\2\2"+
		"\u00a6\u00a7\7\4\2\2\u00a7\u00a8\5\22\n\2\u00a8\u00a9\7\5\2\2\u00a9\u00aa"+
		"\5&\24\2\u00aa%\3\2\2\2\u00ab\u00ac\7\22\2\2\u00ac\u00ad\7\6\2\2\u00ad"+
		"\u00ae\5\f\7\2\u00ae\u00af\7\b\2\2\u00af\'\3\2\2\2\u00b0\u00b1\7\23\2"+
		"\2\u00b1\u00b2\7\6\2\2\u00b2\u00b3\5\f\7\2\u00b3\u00b4\7\b\2\2\u00b4)"+
		"\3\2\2\2\u00b5\u00b6\7\24\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00b8\5\f\7\2"+
		"\u00b8\u00b9\7\b\2\2\u00b9\u00ba\7\25\2\2\u00ba\u00bb\7\4\2\2\u00bb\u00bc"+
		"\5\22\n\2\u00bc\u00bd\7\5\2\2\u00bd+\3\2\2\2\r;GNU[lw\u0082\u008f\u009f"+
		"\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}