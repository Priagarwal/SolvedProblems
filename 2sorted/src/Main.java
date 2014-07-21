public class Main{
	static int a[] = {2,6,9,12,67};
	static int b[] = {4,7,11,34,55};
	
	public static int kthSmallestAiPlusBj(int k){
		int i = 0, j = 0, count = 0;
		for(i = 0; i < a.length; i++) {
			for(j = 0; j < b.length && (a[i]+b[j] < a[i+1]+b[0]); j++) {
				count++;
				if(count == k) {
					System.out.println(i+"th element of a and "+j+"th element of b, and the "+k+"th smallest sum is "+ (a[i]+b[j])  );
					return(a[i]+b[j]);
				}
			}
		}
		
		
		return 0;
	}
	
	public static void main(String args[]) {
		
		for(int i = 1; i< 10; i++)
			System.out.println(kthSmallestAiPlusBj(i));
		//System.out.println(b);
	}
}