import java.util.ArrayList;

public class InstructionTokenizer implements Tokenizer {
	/*
	 * Description: Break instructions by white spaces to create an array of tokens in the same order as the given string.
	 * @Param: String representing an instruction.
	 */	
	public TokenStream tokenize(String input) {
		String[] raw_strings =  input.split(" ");
		ArrayList<Token> stream = new ArrayList<Token>();
		for (int i=0;i<raw_strings.length;i++){
			stream.add(new Token(raw_strings[i]));
		}
		return new TokenStream(stream);
	}
}
