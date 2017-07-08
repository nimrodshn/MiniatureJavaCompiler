import java.util.ArrayList;

public class AST {
	ASTNode root;
	
	public AST(ASTNode root){
		this.root = root;
	}
	
	public AST(){}
	
	// Getters & Setters.
	
	public ASTNode getRoot() {
		return root;
	}

	public void setRoot(ASTNode root) {
		this.root = root;
	}
	
	/*
	 * Description: Prints the tree 'in-order'.
	 */
	public void treeToStringArray(ASTNode node, ArrayList<String> arr){
		if (node != null){
			treeToStringArray(node.leftChild,arr);
			arr.add(node.getToken().getStr());
			treeToStringArray(node.rightChild,arr);
		}
	}
	
}
