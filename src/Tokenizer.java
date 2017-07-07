
public interface Tokenizer {

	/*
	 * Description: Input a string  containing an instruction and output an array of tokens.
	 * @Param: String representing an instruction.
	 */
	TokenStream tokenize(String input);
}
