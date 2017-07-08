import java.util.ArrayList;

public interface SemanticAnalyzer {
	/*
	 * Description: Given an array of trees analyze it according to java semantics and output result to the user.
	 * @Param: an array of AST representing instructions in 'Miniature' Java.
	 */
	public void analyze(ArrayList<AST> treeArray);
}
