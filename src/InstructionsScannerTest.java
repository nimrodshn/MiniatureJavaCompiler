import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class InstructionsScannerTest {
	InstructionsScanner scanner = new InstructionsScanner();
	@Test
	public void testScanner() {
		// Test 1
		String str1 = "i = 0\nj = ++i\nx = i++ + 5\ny = 5 + 3 * 10\ni += y\n";
		String[][] expected1 = {
				{"i","=","0"},
				{"i","=","i","+","1"},
				{"j","=","i"},
				{"x","=","i","+","5"},
				{"i","=","i","+", "1"},
				{"y","=","5","+","3", "*", "10"},
				{"i","=","i","+","y"}
		};
		ArrayList<TokenStream> scanned1 = scanner.scan(str1);
		for (int i=0;i<scanned1.size();i++){
			String[] got = scanned1.get(i).tokenStreamToStringArray();
			String[] ex = expected1[i];
			assertArrayEquals(got,ex);
		}
		
		// Test 2
		String str2 = "i = 1\nj += i\nx = j + 7\n";
		String[][] expected2 = {
				{"i","=","1"}, 
				{"j","=","j","+","i"}, 
				{"x","=","j","+","7"}
		};
		ArrayList<TokenStream> scanned2 = scanner.scan(str2);
		for (int i=0;i<scanned2.size();i++){
			String[] got = scanned2.get(i).tokenStreamToStringArray();
			String[] ex = expected2[i];
			assertArrayEquals(got,ex);
		}
		
		// Test 3
		String str3 = "i = 1\nj = i + 5\nx = j++ + i++ + m++\nm = ++j * i++\n";
		String[][] expected3 = {
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
		ArrayList<TokenStream> scanned3 = scanner.scan(str3);
		for (int i=0;i<scanned3.size();i++){
			String[] got = scanned3.get(i).tokenStreamToStringArray();
			String[] ex = expected3[i];
			assertArrayEquals(got,ex);
		}
	}

}
