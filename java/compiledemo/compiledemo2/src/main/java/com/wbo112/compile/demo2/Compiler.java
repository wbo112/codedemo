package com.wbo112.compile.demo2;

public class Compiler {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();
		//ImprovedParser improvedParser = new ImprovedParser(lexer);
		//improvedParser.statements();
		
		Parser parser = new Parser(lexer);
		parser.statements();
	}
}
