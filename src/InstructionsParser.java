import java.util.ArrayList;
import java.util.Stack;

public class InstructionsParser implements Parser {
	
	/*
	 * Description: Parse a series of instructions in "Miniature Java" given as an array of strings. The parser follows the following set of procedure:
	 * 1. First we turn each instruction into token streams.
	 * 2. Next, we get rid of syntactic sugar in the token streams.
	 * 3. Finally we build an AST from the above token streams.
	 * This Array of AST is then passed to the Semantic Analyzer for final evaluation of the assignments.
	 */
	public ArrayList<AST> parse(ArrayList<TokenStream> tokenStreamArray) {
		ArrayList<AST> res = new ArrayList<AST>();
		for (TokenStream stream : tokenStreamArray){
			res.add(buildAST(stream));
		}
		return res;
	}
	
	/*
	 * Description:
	 * Build the Abstract Syntax tree according to the Following semantics:
	 * 1. The root is always a token representing '='.
	 * 2. The left node is always the token representing the variable we assign to.
	 * 3. The right subtree is the assigned expression based on the elementary arithmetic operations order of precedence. 
	 * 4. The building of the right subtree is based on 'Shunting-yard algorithm' (Edsger Dijkstra).
	 */
	private AST buildAST(TokenStream stream){
		AST res = new AST();
		if (stream.getStreamSize() > 0){
		    Stack<ASTNode> stack = new Stack<ASTNode>();
		    res.setRoot(new ASTNode(stream.getToken(1)));     	// Root node is the token representing '=' operator.
		    ASTNode root = res.getRoot();
		    root.setLeftChild(new ASTNode(stream.getToken(0)));	// Root left child is the token representing the assigned variable.
		    int counter = 2;
		    while (counter < stream.getStreamSize()){
		    	// current token is a variable or a number.
		    	if (stream.getToken(counter).getStr() != "+" && stream.getToken(counter).getStr() != "-" && stream.getToken(counter).getStr() != "*" && stream.getToken(counter).getStr() != "/"){
		    		stack.push(new ASTNode(stream.getToken(counter)));
			    	counter++;
		    	} else if (stream.getToken(counter).getStr() == "+" || stream.getToken(counter).getStr() == "-"){
		    		stack.push(new ASTNode(stream.getToken(counter)));
		    		counter++;
		    	} else if (stream.getToken(counter).getStr() == "*" || stream.getToken(counter).getStr() == "/"){
		    		ASTNode operator = new ASTNode(stream.getToken(counter));
		    		counter++;
	    			ASTNode operand = stack.pop();
	    			operator.setRightChild(new ASTNode(stream.getToken(counter)));
	    			operator.setLeftChild(operand);
	    			stack.push(operator);
	    			counter++;
	            }
		    }
		    // Pop off the stack the nodes to create the right subtree.
		    while (stack.size()>1){
		    	ASTNode rightNode = stack.pop();
		    	ASTNode subOp = stack.pop();
		    	ASTNode leftNode = stack.pop();
		    	subOp.setLeftChild(leftNode);
		    	subOp.setRightChild(rightNode);
		    	stack.push(subOp);
		    }
		    // Last node in the stack represents the right subtree.
		    ASTNode rightSubtree = stack.pop();
		    root.setRightChild(rightSubtree);
		}
		return res;
	}
}
