package main;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import auxiliary.Utility;
import uuv.dsl.ParserEngine;
import uuv.dsl.UUVListener;
//import uuv.dsl.gen.UUVParser;
//import uuv.dsl.gen.UUVVisitor;

public class MainParser {

	public static String configFile = "resources/config.properties";
	public static String sourceFile = "resources/uuv.dsl";

	
	public static void main (String args[]){
		String source = Utility.readFile(sourceFile);
		
		//Generate the language
//		new MainParser().generatedAntlrFiles("UUV.g4");
		
		//run listener/visitor
		ParserEngine.runListerner(source);		
	}

	
	/**
	 * Generate language (visitors and listeners)
	 * @param inputFile
	 */
	@SuppressWarnings("unused")
	private void generatedAntlrFiles(String inputFile){
		String[] arg0 = { "-listener", "-visitor", inputFile, "-o", "./src/uuv/dsl/gen"};
//						"-package", "org.spg.antlr.src.gen"};    
        org.antlr.v4.Tool.main(arg0);
	}
}

