import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class InstructionsSemanticAnalyzerTest {
	InstructionsScanner scanner = new InstructionsScanner();
	InstructionsParser parser = new InstructionsParser();
	InstructionsSemanticAnalyzer analyzer = new InstructionsSemanticAnalyzer();
	@Test
	public void InstructionsSemanticAnalyzerTest() {
		// Test 1
		ArrayList<String> str1 = new ArrayList<>(Arrays.asList("i = 0", "j = ++i","x = i++ + 5","y = 5 + 3 * 10","i += y"));
		HashMap<String,Integer> expected1 = new HashMap<String,Integer>();
		expected1.put("i", 37);
		expected1.put("x", 6);
		expected1.put("y", 35);
		expected1.put("j", 1);
		ArrayList<TokenStream> scanned1 = scanner.scan(str1);
		ArrayList<AST> parsed1 = parser.parse(scanned1);

		HashMap<String,Integer> results1 = analyzer.analyze(parsed1);
		
		assertTrue(expected1.equals(results1));
		
		// Test 1
		ArrayList<String> str2 = new ArrayList<>(Arrays.asList("i = 1","j = i + 5","x = j++ + i++ + m++","m = ++j * i++"));
		HashMap<String,Integer> expected2 = new HashMap<String,Integer>();
		expected2.put("i", 3);
		expected2.put("x", 7);
		expected2.put("m", 16);
		expected2.put("j", 8);
		ArrayList<TokenStream> scanned2 = scanner.scan(str2);
		ArrayList<AST> parsed2 = parser.parse(scanned2);

		HashMap<String,Integer> results2 = analyzer.analyze(parsed2);
		
		assertTrue(expected2.equals(results2));
	}
	
	

}
