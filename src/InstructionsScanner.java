import java.util.ArrayList;

public class InstructionsScanner implements Scanner {
	
	InstructionTokenizer tokenizer;
	ArrayList<TokenStream> instructionSet;
	
	public InstructionsScanner(){
		this.tokenizer = new InstructionTokenizer();
	}
	
	/*
	 * Description: This method receives a series of instructions in the form of one "raw string" and outputs
	 * an array containing the the above instructions broken into streams of tokens.
	 * @Param: String a set of instructions.
	 */
	public ArrayList<TokenStream> scan(String str) {
		this.instructionSet = new ArrayList<TokenStream>();
		String[] instructionLines = str.split("\n"); 	// Split line by null terminator character.
		// Initially, create a raw token stream, from the original lines.
		for (String line : instructionLines){
			TokenStream rawTokenStream = this.tokenizer.tokenize(line);
			instructionSet.add(rawTokenStream);
		}
		cleanSyntacticSuger(instructionSet);
		return instructionSet;
	}
	
	/*
	 *  Description: Find 'Syntactic Sugar' in the whole instruction set on modify it according to java semantics.
	 *  i.e iterate over the token stream representing each line and catch the syntactic modifying the instruction set where needed.
	 *  @Param: Array list of TokenStream each representing a line.
	 */
	private void cleanSyntacticSuger(ArrayList<TokenStream> instructionSet){
		ArrayList<Token> res = new ArrayList<Token>();
		for (int i=0;i<instructionSet.size();i++){
			catchAndReplaceSyntacticSuger(instructionSet.get(i), i);
		}
	}
	
	/*
	 * Description: Catch syntactic sugar in the Token stream (i.e. "+=", "++" etc.) and fix the token stream according to java semantic.
	 * Example - Token stream is "i", "+=" "5"; stream will be transformed to "i", "=", "i" "+" "5".
	 * @Param: an array of tokens.
	 */
	private void catchAndReplaceSyntacticSuger(TokenStream stream,int idx){
		int counter = idx;
		ArrayList<Token> rawStream = stream.getStream();
		ArrayList<Token> modifiedStream = new ArrayList<Token>();
		for (int i=0;i<rawStream.size();i++){
			String tokenString = rawStream.get(i).getStr();
			if (tokenString.contains("+=")){
				// Change the syntactic sugar someVariable += 5 -> someVariable = someVariable + 5. 
				Token assignmentVariable = stream.getAssignmentVariable(); // the variable we assign to is the first token in the token stream.
				rawStream.set(i, new Token("="));
				rawStream.add(i+1, new Token(assignmentVariable));
				rawStream.add(i+2, new Token("+"));
			} else if (tokenString.contains("++")){
				// There are two cases: either a token of the form someVar++ or ++someVar.
				// In the first case (post-increment) we change the value of the token to be 'someVar' and append the line "someVar = someVar + 1" after the line represented by this token stream in the instructionSet.
				// In the second case (pre-increment) we change the value of the token to be someVar and append the line "someVar = someVar + 1" before the line represented by this token stream in the instructionSet.
				int indexOfInc = tokenString.indexOf("++");
				Token variableName = new Token();
				TokenStream newLine = new TokenStream();
			    String temp = new String();
				switch (indexOfInc){
				case 0: 
					// pre-increment case.
				    variableName.setStr((tokenString.substring(2)));
				    temp = variableName.getStr() + " = " + variableName.getStr() + " + 1";
				    newLine.setStream(this.tokenizer.tokenize(temp).getStream());
					rawStream.set(i, variableName);
				    this.instructionSet.add(counter, newLine);
				    counter++; // for some extreme corner cases where we have post-increment and pre-increment in the same instruction.
				    break;
				default: 
					// post increment case
				    variableName.setStr((tokenString.substring(0,indexOfInc)));
				    temp = variableName.getStr() + " = " + variableName.getStr() + " + 1";
				    newLine.setStream(this.tokenizer.tokenize(temp).getStream());
					rawStream.set(i, variableName);
					this.instructionSet.add(counter+1, newLine);
				    break;
				}
			} 
		}
	}

}
