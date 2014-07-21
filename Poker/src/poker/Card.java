package poker;

public class Card {

    public int integerCard;
    
    
    private       static int val[] = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private       static char suit[] = {'H','D','C','S'};
           
    public int pip() {
           return val[integerCard%13];
    }
    
    public char suit() {
           return suit[integerCard/13];
    }
    
    Card() {
           integerCard = 0;
    }
    
    Card(int integerCard) {
           this.integerCard = integerCard;
    }
    
    Card(Card c) {
           integerCard = c.integerCard;
    }
}
