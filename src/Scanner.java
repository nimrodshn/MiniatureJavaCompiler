import java.util.ArrayList;

public interface Scanner {
	/*
	 * Description: This method receives a series of instructions in the form of an array of strings and outputs
	 * an array containing the the above instructions broken into streams of tokens.
	 * @Param: String a set of instructions.
	 */
	public ArrayList<TokenStream> scan(ArrayList<String> str);
}
