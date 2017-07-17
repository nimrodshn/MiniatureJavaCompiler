import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MiniatureCompiler implements Compiler {
	InstructionsScanner scanner;
	InstructionsParser parser;
	InstructionsSemanticAnalyzer analyzer;
	
	public MiniatureCompiler() {
		scanner = new InstructionsScanner();
		parser = new InstructionsParser();
		analyzer = new InstructionsSemanticAnalyzer();
	}
	
	/*
	 * Description: A wrapper for the scanner, parser and semantic analyzer; Using the above interfaces as a pipeline we are able to generate
	 * the "compiled" results.
	 * @Param: A series of instructions in the form of an array of strings and outputs the correct assignments to each variable at the end of these instructions. 
	 */
	public void compile(ArrayList<String> str) {
		ArrayList<TokenStream> scannedString = scanner.scan(str);
		ArrayList<AST> ASTList = parser.parse(scannedString);
		analyzer.analyze(ASTList);
		analyzer.printVarResults();
	}
	
	public static void main(String[] args) throws IOException {
	    ArrayList<String> instructionLines = new ArrayList<String>();
	    try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));  // change here to args[0] if wish to compile and run from command line.   
	        String line;
	        while ((line = br.readLine()) != null) {
	            instructionLines.add(line);
	        }
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
        MiniatureCompiler compiler = new MiniatureCompiler();
        compiler.compile(instructionLines);   // prints the characters one by one                             
	}

}
