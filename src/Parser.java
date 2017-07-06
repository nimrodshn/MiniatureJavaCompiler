
public interface Parser {
	/*
	 * Description: This method receives an array of strings representing instructions and transforms it into
	 * an Array of AST's each representing an instruction corresponding to input array.
	 * @Param: Array of Strings each is a single instruction.
	 */
	AST[] parse(String[] instructions); 
}
