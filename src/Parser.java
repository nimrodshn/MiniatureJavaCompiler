import java.util.ArrayList;

public interface Parser {
	/*
	 * Description: This method receives an array of TokenStreams representing instructions and transforms it into
	 * an Array of AST's each representing an instruction corresponding to input array.
	 * @Param: Array of Strings each is a single instruction.
	 */
	ArrayList<AST> parse(ArrayList<TokenStream> instructions); 
}
