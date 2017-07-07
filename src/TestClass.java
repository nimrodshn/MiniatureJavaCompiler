
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] expected = {
				{"i","=","0"},
				{"i","=","i","+","1"},
				{"j","=","i"},
				{"x","=","i","+","5"},
				{"i","=","i","+", "1"},
				{"y","=","5","+","3", "*", "10"},
				{"i","=","i","+","y"}
		};
		System.out.print(expected[0].length);
	}

}
