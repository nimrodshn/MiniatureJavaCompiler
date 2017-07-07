import java.util.ArrayList;

public class InstructionsParser implements Parser {
	
	/*
	 * Description: Parse a series of instructions in "Miniature Java" given as an array of strings. The parser follows the following set of procedure:
	 * 1. First we turn each instruction into token streams.
	 * 2. Next, we get rid of syntactic sugar in the token streams.
	 * 3. Finally we build an AST from the above token streams.
	 * This Array of AST is then passed to the Semantic Analyzer for final evaluation of the assignments.
	 */
	public ArrayList<AST> parse(ArrayList<TokenStream> instructions) {
		return null;
	}
}
