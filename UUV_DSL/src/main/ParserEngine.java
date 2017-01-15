package main;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import auxiliary.Utility;
import uuv.dsl.UUVListener;
import uuv.dsl.gen.UUVLexer;
import uuv.dsl.gen.UUVParser;
import uuv.dsl.gen.UUVVisitor;

public class ParserEngine {

	public static String configFile = "resources/config.properties";
	public static String sourceFile = "resources/uuv.dsl";

	
	public static void main (String args[]){
		String source = Utility.readFile(sourceFile);
		
		//run listener/visitor
		ParserEngine.runListerner(source);		
	}

	
	private static UUVParser createParser(String source){
		 // create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(source); 
		// create a lexer that feeds off of input CharStream
		UUVLexer lexer = new UUVLexer(input); 
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create error parser
        BaseErrorListener errorListener = createErrorListener();
		// create a parser that feeds off the tokens buffer
		UUVParser parser = new UUVParser(tokens);
		//add error listerner to parser and lexer
		lexer.addErrorListener(errorListener);
		parser.addErrorListener(errorListener);
		
		return parser;

	}
	
	
	private static BaseErrorListener createErrorListener() {
        BaseErrorListener errorListener = new BaseErrorListener() {

            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, @Nullable Object offendingSymbol, int line,
                    int charPositionInLine, String msg, @Nullable RecognitionException e) {
                //Print the syntax error 
                System.out.printf("\t%s at (%d, %d)%n", msg, line, charPositionInLine);
            }
        };
        return errorListener;
    }
	
	
	/**
	 * Run visitor
	 * @param inputString
	 */
	@SuppressWarnings("unused")
	private static void runVisitor(String source){
		//create parser
	    UUVParser parser = ParserEngine.createParser(source);
		// begin parsing at prog rule
		ParseTree tree = parser.model();
		//Create the visitor
		UUVVisitor visitor = null;//new UUVVisitor();
		// and visit the nodes
		visitor.visit(tree);		
	}
	
	
	/**
	 * Run listerner
	 * @param inputString
	 */
	@SuppressWarnings("unused")
	private static void runListerner(String source){
		//create parser
	    UUVParser parser = ParserEngine.createParser(source);
	    // begin parsing at model rule
		ParseTree tree = parser.model();	
		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		// Create a listener
		UUVListener listener = new UUVListener();
		// Walk the tree created during the parse, trigger callbacks
		walker.walk(listener, tree);
	}
}
