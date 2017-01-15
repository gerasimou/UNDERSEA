package main;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import auxiliary.Utility;
import uuv.dsl.ParserEngine;
import uuv.dsl.UUVListener;
import uuv.dsl.gen.UUVParser;
import uuv.dsl.gen.UUVVisitor;

public class MainParser {

	public static String configFile = "resources/config.properties";
	public static String sourceFile = "resources/uuv.dsl";

	
	public static void main (String args[]){
		String source = Utility.readFile(sourceFile);
		
		//Generate the language
//		new MainParser().parser.generatedAntlrFiles("UUV.g4");
		
		//run listener/visitor
		runListerner(source);		
	}

	
	/**
	 * Generate language (visitors and listeners)
	 * @param inputFile
	 */
	@SuppressWarnings("unused")
	private void generatedAntlrFiles(String inputFile){
		String[] arg0 = { "-listener", "-visitor", inputFile, "-o", "./src/org/spg/uuv/dsl/gen"};
//						"-package", "org.spg.antlr.src.gen"};    
        org.antlr.v4.Tool.main(arg0);
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

