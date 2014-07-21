package poker;

import java.util.Arrays;
public class Hand {
	Card cards[];
	static int total_cards = 5;
	int valArray[] = new int[] { 0, 0, 0, 0, 0};
    char suitArray[] = new char[] { '\0','\0','\0','\0','\0'} ;
    
    Hand( int cardArray[] ) {
    	for(int i = 0; i < total_cards; i++) {
    		cards[i] = new Card(cardArray[i]);
    	}
     for(int i = 0; i < total_cards; i++) {
         	  valArray[i] = cards[i].pip();
           	  suitArray[i] = cards[i].suit();
           }
     }
	
	Hand(Hand c) {
		for (int i = 0; i < total_cards; i++) {
			cards[i] = c.cards[i];
		}
	}

	Hand(Card ArrayCards[]) {
		for (int i = 0; i < total_cards; i++) {
			cards[i] = ArrayCards[i];
		}
	}

	Hand sort() {
		int integerArray[] = new int[5];
		for (int i = 0; i < total_cards; i++) {
			integerArray[i] = valArray[i];
		}

		Arrays.sort(integerArray);
		for (int i = 0; i < total_cards; i++) {
			cards[i] = new Card(integerArray[i]);
		}
		Hand sortedHand = new Hand(cards);
		return sortedHand;
	}

	public boolean isRoyalFlush() {
		return (isStraightFlush() && valArray[4] == 14);
	}

	public boolean isStraightFlush() {
		return (isFlush() && isStraight());
	}

	public boolean isFourOfAKind() {

		int val1 = valArray[0];
		int val2 = valArray[1];
		int count1 = 1, count2 = 1;
		for (int i = 1; i < total_cards; i++) {
			if (valArray[i] == val1) {
				count1++;
			}
			if (valArray[i] == val2) {
				count2++;
			}

		}
		return (count1 == 4 || count2 == 4);
	}

	public boolean isFullHouse() {
		boolean fullHouse = false;
		if (valArray[1] == valArray[2]
				&& valArray[2] != valArray[3]) 
		{
			if (valArray[0] == valArray[1] && valArray[3] == valArray[4]) {
				fullHouse = true;
			}
		}
		if (valArray[1] != valArray[2] && valArray[2] == valArray[3]) {
			if (valArray[0] == valArray[1] && valArray[3] == valArray[4]) {
				fullHouse = true;
			}
		}
		return (fullHouse);
	}

	public boolean isFlush() {
		for (int i = 1; i < total_cards; i++) {
			if (suitArray[i] != suitArray[0]) {
				return false;
			}
		}
		return true;
	}

	public boolean isStraight() {
		return (valArray[4] - valArray[0] == 4);
	}

	public boolean isThreeOfAKind() {
		int count1 = 1, count2 = 1, count3 = 1;
		int val = valArray[0];
		int val1 = valArray[1];
		int val2 = valArray[2];
		for (int i = 1; i < total_cards; i++) {
			if (valArray[i] == val) {
				count1++;

			} else if (valArray[i] == val1) {
				count2++;
			} else if (valArray[i] == val2) {
				count3++;
			}
		}
		return (count1 == 3 || count2 == 3 || count3 == 3);

	}

	public boolean isTwoPair(){
	       int count = 0;
	       if (!(this.isThreeOfAKind())){
	    	   for( int i=0; i < (total_cards - 1) ; i++)
	    	   {
	              if(valArray[i] == valArray[i+1]){
	                     count++;
	              }
	    	   }
	       }
	       return (count == 2);
	}
	


	public boolean isOnePair() {
		int count = 0;
		for (int i = 0; i < (total_cards - 1); i++) {
			if (valArray[i] == valArray[i+1])
				count++;
		}
		return (count == 1);

	}

	public boolean isHighCard() {

		return true;
	}

}

/**
 * @param args
 */
