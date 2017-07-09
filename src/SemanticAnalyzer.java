import java.util.ArrayList;
import java.util.HashMap;

public interface SemanticAnalyzer {
	/*
	 * Description: Given an array of trees analyze it according to java semantics and output result hashmap.
	 * @Param: an array of AST representing instructions in 'Miniature' Java.
	 */
	public HashMap<String,Integer> analyze(ArrayList<AST> treeArray);
}
