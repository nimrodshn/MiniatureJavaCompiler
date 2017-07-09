import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class InstructionsParserTest {
	InstructionsScanner scanner = new InstructionsScanner();
	InstructionsParser parser = new InstructionsParser();
	@Test
	public void InstructionsParserTest() {
		// Test 1
		ArrayList<String> str1 = new ArrayList<>(Arrays.asList("i = 0", "j = ++i","x = i++ + 5","y = 5 + 3 * 10","i += y"));
		String[][] expected1 = {
				{"i","=","0"},
				{"i","=","i","+","1"},
				{"j","=","i"},
				{"x","=","i","+","5"},
				{"i","=","i","+","1"},
				{"y","=","5","+","3", "*", "10"},
				{"i","=","i","+","y"}
		};
		ArrayList<TokenStream> scanned1 = scanner.scan(str1);
		ArrayList<AST> parsed1 = parser.parse(scanned1);
		for (int i=0;i<parsed1.size();i++){
			ArrayList<String> arr = new ArrayList<String>();
			parsed1.get(i).treeToStringArray(parsed1.get(i).getRoot(), arr);
			String[] got = new String[arr.size()];
			got = arr.toArray(got);
			String[] ex = expected1[i];
			assertArrayEquals(got,ex);
		}
		
		// Test 2
		ArrayList<String> str2 = new ArrayList<>(Arrays.asList("i = 1","j = i + 5","x = j++ + i++ + m++","m = ++j * i++"));
		String[][] expected2 = {
				{"i","=","1"}, 
				{"j","=","i","+","5"},
				{"x","=","j","+","i","+","m"},
				{"m","=","m","+","1"},
				{"i","=","i","+","1"},
				{"j","=","j","+","1"},
				{"j","=","j","+","1"},
				{"m","=","j","*","i"},
				{"i","=","i","+","1"}
				
		};
		ArrayList<TokenStream> scanned2 = scanner.scan(str2);
		ArrayList<AST> parsed2 = parser.parse(scanned2);
		for (int i=0;i<parsed2.size();i++){
			ArrayList<String> arr = new ArrayList<String>();
			parsed2.get(i).treeToStringArray(parsed2.get(i).getRoot(), arr);
			String[] got = new String[arr.size()];
			got = arr.toArray(got);
			String[] ex = expected2[i];
			assertArrayEquals(got,ex);
		}
		
	}

}
