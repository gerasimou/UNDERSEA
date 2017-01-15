package uuv.dsl;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.Nullable;

import uuv.dsl.gen.UUVLexer;
import uuv.dsl.gen.UUVParser;

public class ParserEngine {

	
	public static UUVParser createParser(String source){
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
}
