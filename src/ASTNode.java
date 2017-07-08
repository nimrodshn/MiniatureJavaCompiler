
public class ASTNode {
	Token token;
	ASTNode rightChild;
	ASTNode leftChild;
	
	public ASTNode(Token t){
		this.token = t;
	}
	
	public ASTNode(Token t, ASTNode rchild, ASTNode lchild){
		this.token = t;
		this.leftChild = lchild;
		this.rightChild = rchild;
	}
	
	// Getters & Setters.
	
	public ASTNode getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(ASTNode left) {
		this.leftChild = left;
	}

	public ASTNode getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(ASTNode right) {
		this.rightChild = right;
	}
	
	public Token getToken(){
		return this.token;
	}

}
