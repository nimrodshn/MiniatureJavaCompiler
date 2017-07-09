import java.util.ArrayList;
import java.util.HashMap;

public class InstructionsSemanticAnalyzer implements SemanticAnalyzer {
	HashMap<String,Integer> varResults;  

	@Override
	public HashMap<String,Integer> analyze(ArrayList<AST> treeArray) {
		varResults = new HashMap<String,Integer>();
		for (int i=0;i<treeArray.size();i++){
			analyzeAST(treeArray.get(i));
		}
		return varResults;
	}
	
	/*
	 * Description: For each AST compute its value and assign to the corresponding value in the hash.
	 * @Param: AST representing the arithmetic expression.
	 */
	private void analyzeAST(AST tree){
		String variableToAssign = tree.getRoot().getLeftChild().getToken().getStr();
		ASTNode rightSubTree = tree.getRoot().getRightChild();
		
		int valToAssign = computeVariableToAssign(rightSubTree);
		
		if (varResults.containsKey(variableToAssign)){
			varResults.replace(variableToAssign, valToAssign);
		}
		else {
			varResults.put(variableToAssign, valToAssign);
		}
	}
	
	/*
	 * Description: Computes the numerical value to assign to the variable. This is done by recursivly traversing through the AST.
	 * @Param: Node as a root of a subtree to traverse through.
	 */
	private int computeVariableToAssign(ASTNode node){
		int result = 0;
		if (node != null){
			if (node.getToken().getStr().equals("+")){
				result = computeVariableToAssign(node.getLeftChild()) + computeVariableToAssign(node.getRightChild());
			}
			if (node.getToken().getStr().equals("-")){
				result = computeVariableToAssign(node.getLeftChild()) - computeVariableToAssign(node.getRightChild());
			}
			if (node.getToken().getStr().equals("*")){
				result = computeVariableToAssign(node.getLeftChild()) * computeVariableToAssign(node.getRightChild());
			}
			if (node.getToken().getStr().equals("/")) {
				result = computeVariableToAssign(node.getLeftChild()) / computeVariableToAssign(node.getRightChild());
			}
			if (isInteger(node.getToken().getStr())){
				result = Integer.parseInt(node.getToken().getStr());
			}
			if (varResults.containsKey(node.getToken().getStr())){
				result = varResults.get(node.getToken().getStr());
			}
		}
		return result;
	}
	
	/*
	 * Description: Prints the Hashmap varResults or Debugging purposes.
	 */
	public void printVarResults(){
		System.out.print(varResults.toString());
	}
	
	/*
	 * Description: Helper function for determining if a string is an integer.
	 * @Param: String str.
	 */
	private static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

}
