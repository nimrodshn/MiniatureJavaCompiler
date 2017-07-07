
public class Token {
	String str;

	public Token(){
		this.str = null;
	}
	
	public Token(String str){
		this.str = str;
	}
	
	public Token(Token t){
		this.str = t.getStr();
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
}
