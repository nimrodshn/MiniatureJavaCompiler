import java.util.ArrayList;

public class TokenStream {
	ArrayList<Token> stream;
	
	public TokenStream(){}
	
	public TokenStream(ArrayList<Token> stream){
		this.stream = stream;
	}
	
	// Getters & Setters
	
	public ArrayList<Token> getStream() {
		return stream;
	}
	
	public void setStream(ArrayList<Token> stream){
		this.stream = stream;
	}
	
	public Token getAssignmentVariable(){
		return this.stream.get(0);
	}
	
	public int getStreamSize(){
		return this.stream.size();
	}
	
	public Token getToken(int idx){
		return this.stream.get(idx);
	}
	
	public String[] tokenStreamToStringArray(){
		String[] res = new String[getStreamSize()];
		for (int i=0;i<getStreamSize();i++){
			res[i] = this.stream.get(i).getStr();
		}
		return res;
	}
}
