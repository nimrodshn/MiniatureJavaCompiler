import static org.junit.Assert.*;
import org.junit.Test;


public class InstructionsScannerTest {
	InstructionsScanner scanner = new InstructionsScanner();
	@Test
	public void testScanner() {
		// Test 1
		String str1 = "i = 0\nj = ++i\nx = i++ + 5\ny = 5 + 3 * 10\ni += y\n";
		String[] ans1 = {"i = 0", "j = ++i", "x = i++ + 5", "y = 5 + 3 * 10", "i += y"};
		String[] arr1 = scanner.scan(str1);
		assertArrayEquals(arr1,ans1);
		// Test 2
		String str2 = "i = 1\nj += i\nx = j + 7\n";
		String[] ans2 = {"i = 1", "j += i", "x = j + 7"};
		String[] arr2 = scanner.scan(str2);
		assertArrayEquals(arr2,ans2);
		// Test 3
		String str3 = "";
		String[] ans3 = {""};
		String[] arr3 = scanner.scan(str3);
		assertArrayEquals(arr3,ans3);
		// Test 4
		String str4 = "shimi = 3\nx = shimi++\n";
		String[] ans4 = {"shimi = 3", "x = shimi++"};
		String[] arr4 = scanner.scan(str4);
		assertArrayEquals(arr4,ans4);
	}

}
