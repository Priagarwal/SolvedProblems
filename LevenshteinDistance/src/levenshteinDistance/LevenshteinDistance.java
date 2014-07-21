package levenshteinDistance;

public class LevenshteinDistance {
	LevenshteinDistance() {
		
	}
	int minimum(int a, int b, int c) {
		int min = a;
		if (min > b) {
			min = b;
		}
		if (min > c) {
			min = c;
		}
		return min;
	}

	int computeLevenshteinDistance(String aString , String bString) {
		int aLen = aString.length(); 
		int bLen = bString.length();
		int cost = 0;
		if (aLen == 0) {
			return bLen; 
		}
		if (bLen == 0) {
			return aLen;
		}
		if (aString.charAt(aLen - 1) == bString.charAt(bLen - 1)) {
			cost = 0;
		} else {
			cost = 1;
		}
		if (aLen >1 && bLen > 1 ) {
			int a = computeLevenshteinDistance(aString.substring(0, aLen - 2), bString) + 1 ;
			int b = computeLevenshteinDistance(aString , bString.substring(0, bLen - 2)) + 1;
			int c = computeLevenshteinDistance(aString.substring(0, aLen - 2), bString.substring(0, bLen - 2) + cost);
			return minimum(a,b ,c);
		}
		else if (aLen > 1 ) {
			int a = computeLevenshteinDistance(aString.substring(0, aLen - 2), bString) + 1 ;
			return a + cost;
		}
		else if (bLen > 1 ) {
			int b = computeLevenshteinDistance(aString , bString.substring(0, bLen - 2)) + 1;
			return b + cost;
		}
		else {
			return cost;
		}
		  	
	}
	
	public static void main(String[] args) {
		LevenshteinDistance l = new LevenshteinDistance();
        System.out.println(l.computeLevenshteinDistance("bacd" , "b"));
        
    }


}
