
public class Reconcile {

	int[][] finalDistribution = new int[10][];
	Reconcile() {
		
	}
	int num_people;
	String reconcile(float[][] distribution) {
		String S = new String("");
		for ( int i = 0; i < num_people ; i++) {
			for ( int j = i + 1; j < num_people ; j++) {
				if (distribution[i][j] > distribution[j][i]) {
					distribution[i][j] = distribution[i][j] - distribution[j][i];
					distribution[j][i] = 0;
					//S = S +  personMap(i) + " will give Rupees" +  distribution[i][j] + " to " + personMap(j);
				} else if(distribution[j][i] > distribution[i][j]) {
					distribution[j][i] = distribution[j][i] - distribution[i][j];
					distribution[i][j] = 0;
					//S = S +  personMap(j) + " will give Rupees" +  distribution[j][i] + " to " + personMap(i);
				}
			}
		}
		
		return S;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
