import static org.junit.Assert.*;

import org.junit.Test;

public class InstructionTokenizerTest {
	InstructionTokenizer tokenizer = new InstructionTokenizer();
	@Test
	public void testTokenizer() {
		// Test 1
		String str1 = "i = 0";
		
		String[] ans1 = {"i","=","0"};
		TokenStream stream1 = tokenizer.tokenize(str1);
		String[] res1 = new String[stream1.getStreamSize()];
		
		for (int i = 0;i<stream1.getStreamSize();i++){
			res1[i] = stream1.getToken(i).getStr();
		}
		
		assertArrayEquals(res1,ans1);
		
		// Test 2
		String str2 = "x = i++ + 5";
		
		String[] ans2 = {"x","=","i++","+","5"};
		TokenStream stream2 = tokenizer.tokenize(str2);
		String[] res2 = new String[stream2.getStreamSize()];
		
		for (int i = 0;i<stream2.getStreamSize();i++){
			res2[i] = stream2.getToken(i).getStr();
		}
		
		assertArrayEquals(res2,ans2);

		// Test 3
		String str3 = "y = 5 + 3 * 10";
		
		String[] ans3 = {"y","=","5","+","3","*","10"};
		TokenStream stream3 = tokenizer.tokenize(str3);
		String[] res3 = new String[stream3.getStreamSize()];
		
		for (int i = 0;i<stream3.getStreamSize();i++){
			res3[i] = stream3.getToken(i).getStr();
		}
		
	
		assertArrayEquals(res3,ans3);
	}

}
