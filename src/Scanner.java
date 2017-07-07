import java.util.ArrayList;

public interface Scanner {
	/*
	 * Description: This method recievs a series of instructions in the form of one "raw string" and outputs
	 * an array containing the the above instructions broken into streams of tokens.
	 * @Param: String a set of instructions.
	 */
	public ArrayList<TokenStream> scan(String str);
}
