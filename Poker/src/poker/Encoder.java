package poker;
import java.util.*;

public class Encoder {
	String InputString;
	HashMap Map_Number;
	HashMap Map_Suite;

	public Encoder( String s) {
		Map_Number = new HashMap();
		Map_Suite = new HashMap();
		Map_Number.put('2', 0);
		Map_Number.put('3', 1);
		Map_Number.put('4', 2);
		Map_Number.put('5', 3);
		Map_Number.put('6', 4);
		Map_Number.put('7', 5);
		Map_Number.put('8', 6);
		Map_Number.put('9', 7);
		Map_Number.put('T', 8);
		Map_Number.put('J', 9);
		Map_Number.put('Q', 10);
		Map_Number.put('K', 11);
		Map_Number.put('A', 12);
		Map_Suite.put('H', 0);
		Map_Suite.put('D', 1);
		Map_Suite.put('C', 2);
		Map_Suite.put('S', 3);
		InputString = s;
	}

	int[] convertToNum() {
		//InputString = new String(Input);
		int x[] = { 0, 0, 0, 0, 0 };
		int j;
		for (int i = j = 0; i < InputString.length(); i += 2, j++) {
			x[j] = (Integer) Map_Number.get(InputString.charAt(i));
			x[j] += 13 * (Integer) Map_Suite.get(InputString.charAt(i + 1));
		}
		return x;
	}
	/**
	 * @param args
	 */
}
