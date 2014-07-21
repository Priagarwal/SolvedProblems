package poker;
import java.util.Scanner;	


public class Poker {

	//Hand hand1;
	//Hand hand2;
	 
		
	
	public static void main(String[] args) {
		String ahand , bhand ;
		Scanner in = new Scanner(System.in);
		ahand = in.nextLine();
		bhand = in.nextLine();
		Encoder a = new Encoder(ahand);
		Encoder b = new Encoder(bhand);
		int aArray[] = a.convertToNum();
		int bArray[] = b.convertToNum();
		Hand hand1 = new Hand(aArray);
		Hand hand2 = new Hand(bArray);
		Classifier aClassification = new Classifier(hand1);
		Classifier bClassification = new Classifier(hand2);
		int aHandResult[] = aClassification.classify(hand1);
		int bHandResult[] = bClassification.classify(hand2);
		Evaluator eval = new Evaluator(aHandResult, bHandResult);
		int result = eval.winnerHand() ;
		System.out.println(result);
	}

}
