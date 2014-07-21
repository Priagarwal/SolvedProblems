package poker;



public class Evaluator {
	int Hand1[] = new int[] { 0, 0, 0, 0, 0, 0 };
	int Hand2[] = new int[] { 0, 0, 0, 0, 0, 0 };
	
	public Evaluator( int a[], int b[]) {
		for( int i = 0; i < a.length ; i++) {
			Hand1[i] = a[i];
			Hand2[i] = b[i];
		}
	}
	
	public int winnerHand(){
		for( int i = 0; i < this.Hand1.length ; i++) {
			if (this.Hand1[i] > this.Hand2[i])
				return 1;
			else if (this.Hand1[i] < this.Hand2[i])
				return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int a[] = new int[] {10, 12, 13, 27, 32, 33};
		int b[] = new int[] {11, 12, 13, 27, 32, 33};
		Evaluator e = new Evaluator ( a , b );
		System.out.println(e.winnerHand());
	}
	
}



/*calling function as:


		Evaluate E1 = new Evaluate();
		System.out.println(E1.winnerHand(h1, h2));
*/