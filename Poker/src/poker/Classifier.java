package poker;
 
public class Classifier {
       int classification[];
       
       int valArray[] = new int[] { 0, 0, 0, 0, 0, 0};
       char suitArray[] = new char[] { '\0', '\0','\0','\0','\0','\0'};
       Classifier(Hand h) {
              classification = new int[] { 0, 0, 0, 0, 0, 0 };
              for(int i = 0; i < 5; i++) {
            	  valArray[i] = h.valArray[i];
              	  suitArray[i] = h.suitArray[i];
              }
       }
 
      
       int[] classify(Hand hand1) {
              
    	   int rank = 10;
              if (hand1.isRoyalFlush()) {
                     rank -= 0;
                     }
              else if (hand1.isStraightFlush()) {
                     rank -= 1;
                     classification[1] = valArray[4];
              } 
              else if (hand1.isFourOfAKind()) {
                     rank -= 2;
                     if (valArray[0] == valArray[3]) {
                       classification[1] = valArray[0];
                       classification[2] = valArray[4];
                       } 
                     else {
                       classification[1] = valArray[4];
                       classification[2] = valArray[0];        
                     }
              } 
              else if (hand1.isFullHouse()) {
                     rank -= 3;
                      if (valArray[0] == valArray[2]) {
                       classification[1] = valArray[0];
                       classification[2] = valArray[3];
                       }
                      else {
                       classification[1] = valArray[2];
                       classification[2] = valArray[0]; 
                      }
              }
              else if (hand1.isFlush()) {
                     rank -= 4;
                     for (int i = 0; i < 5; i++) {
                         classification[i] = valArray[i];
                     }
              }
              else if (hand1.isStraight()) {
                     rank -= 5;
                     classification[1] = valArray[4];
              }
              else if (hand1.isThreeOfAKind()) {
                     rank -= 6;
                     if (valArray[0] == valArray[2]) {
                       classification[1] = valArray[0];
                       classification[2] = valArray[4];
                       classification[3] = valArray[3];
                     } else if (valArray[1] == valArray[3]) {
                       classification[1] = valArray[1];
                       classification[2] = valArray[4];
                       classification[3] = valArray[0];
                     } else {
                       classification[1] = valArray[2];
                       classification[2] = valArray[1];
                       classification[3] = valArray[0];
                     }
                       
              } 
              else if (hand1.isTwoPair()) {
                     rank -= 7;
                     if (valArray[0] != valArray[1]) {
                       classification[1] = valArray[4];
                       classification[2] = valArray[2];
                       classification[3] = valArray[1];
                     }
                     else if (valArray[2] != valArray[3]) {
                       classification[1] = valArray[4];
                       classification[2] = valArray[1];
                       classification[3] = valArray[2];
                     }
                     else {
                       classification[1] = valArray[3];
                       classification[2] = valArray[1];
                       classification[3] = valArray[4];
                     }                     
              }
              else if (hand1.isOnePair()) {
                       rank -= 8;
                       if (valArray[0] == valArray[1]) {
                    	   classification[1] = valArray[1];
                    	   classification[2] = valArray[4];
                    	   classification[3] = valArray[3];
                    	   classification[4] = valArray[2];
                       }
                       else if (valArray[1] == valArray[2]) {
                    	   classification[1] = valArray[2];
                    	   classification[2] = valArray[4];
                    	   classification[3] = valArray[3];
                    	   classification[4] = valArray[1];
                       }
                       else if (valArray[2] == valArray[3]) {
                    	   classification[1] = valArray[3];
                    	   classification[2] = valArray[4];
                    	   classification[3] = valArray[1];
                    	   classification[4] = valArray[0];
                       } else {
                    	   classification[1] = valArray[4];
                    	   classification[2] = valArray[2];
                    	   classification[3] = valArray[1];
                    	   classification[4] = valArray[0];
                          
                       }
                       
              } 
              else if (hand1.isHighCard()) {
                     rank -= 9;
                     classification[1] = valArray[0];
              	     classification[2] = valArray[1];
              	     classification[3] = valArray[2];
              	     classification[4] = valArray[3];
              	     classification[5] = valArray[4];
              }
                   classification[0] = rank;
              return (classification);
       }
 
 
        /**
       * @param args
       */
       public static void main(String[] args) {
              // TODO Auto-generated method stub
 
       }
 
}
