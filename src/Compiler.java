import java.util.ArrayList;

public interface Compiler {
	/*
	 * Description: A wrapper for the scanner, parser and semantic analyzer; Using the above interfaces as a pipeline we are able to generate
	 * the "compiled" results.
	 * @Param: A series of instructions in the form of an array of strings and outputs the correct assignments to each variable at the end of these instructions. 
	 */
	void compile(ArrayList<String> str);
}
