import java.util.ArrayList;
import java.util.Arrays;

public class ncr {
	public static char[] getChars(int n) {
		char allChars[] = new char[n];
		//char c = n.;
		int j = 0;
		for(int i = 49; i< n+49; i++) {
			allChars[j++] = (char) (i);
		}
		return allChars;
	}
	
	public static ArrayList<String> combinations(int n, int r) {
		ArrayList<String> combos = new ArrayList<String>();
		char from[] = new char[n];
		String s = new String();
		from = getChars(n);
		//System.out.println(from);
		//from = getInput(n);
		if(r <= 0) {
			combos = null;
		} else if(r == 1) {
			for(char c : from) {
				s = c+"";
				combos.add(s);
			}			
		} else if(n == r) {
			//System.out.println("In the case where n equals r");
			s = new String(from);
			combos.add(s);
		} else {
			ArrayList<String> combosNthTaken = combinations(n-1,r-1);
				for(String a : combosNthTaken) {
					a = a + from[n-1];
					combos.add(a);
				}
			ArrayList<String> combosNthNotTaken = combinations(n-1,r);
			combos.addAll(combosNthNotTaken);
		}
		
		//considering all are distinct
		
		return combos;
	}
	
	public static char[] getInput(int n) {
		char[] input = new char[n];
		input = "mango".toCharArray();
		return input;
	}
	
	public static void main(String args[]) {
		
		//System.out.println(getChars(5));
		System.out.println(combinations(5,2));
	}
}