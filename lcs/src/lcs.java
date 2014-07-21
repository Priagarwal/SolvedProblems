public class lcs {
	static char a[] = ("lemon").toCharArray();
	static char b[] = ("dregon").toCharArray();
	static int max(int a, int b) {
		return( a>=b?a:b);
	}
	static int lcsLength(int i, int j,char seq[] ) {
		if(i == a.length || j == b.length)
			return 0;
		if(a[i] == b[j]) {
			seq[i] = a[i];
			
			return(1 + lcsLength(i+1,j+1,seq));
		}
		else {
			char seq1[] = new char[a.length];
			char seq2[] = new char[a.length];
			int l1 = lcsLength(i,j+1,seq1);
			int l2 = lcsLength(i+1,j,seq2);
			if(l1>= l2) {
				for(int k = i; k<a.length; k++)
					seq[k] = seq1[k];
				return(l1);
			} else {
				for(int k = i+1; k<a.length; k++)
					seq[k] = seq2[k];
				return(l2);
			}
			
		}
	}
	
	
	public static void main(String args[]) {
		char seq[] = new char[a.length];
		int lcsLen = lcsLength(0,0, seq);
		System.out.println(lcsLen);
		for(int k = 0; k<a.length; k++) {
			if(seq[k] != ' ' )
			   System.out.print(seq[k]); 
		}
	}
}