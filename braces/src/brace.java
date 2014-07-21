import java.util.ArrayList;



public class brace {
	public static ArrayList<String> drawBraces(int n) {
		ArrayList<String> validStrings= new ArrayList<String>();
		if(n <= 0) {
			System.out.println("Invalid Input");
			validStrings = null;
		}
		else if (n == 1)
			validStrings.add("()");
		else {
			ArrayList<String> subValidStrings = new ArrayList<String>();
			subValidStrings = drawBraces(n-1);
			for(String s :subValidStrings ) {
				validStrings.add("("+s+")");
				validStrings.add(s+"()");
				if(!( s + "()").equals("()"+s))
					validStrings.add("()"+s);
			}
		}
		return validStrings;
	}
	
	
	private static boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		boolean isPalin = true;
		char a[] = s.toCharArray();
		int l = s.length();
		for(int i = 0; i < l/2; i++) {
			if(a[i] != a[l-1-i]) {
				isPalin = false;
				break;
			}
		}
		return isPalin;
	}


	public static void main(String args[]) {
		//System.out.println(isPalindrome("()")?"true":"false");
		System.out.println(drawBraces(3));
	}
}