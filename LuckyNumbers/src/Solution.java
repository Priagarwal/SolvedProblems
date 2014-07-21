import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean isPrime(int n) {
		boolean isPrm = true;
		if(n == 1)
			return false;
		if(n == 2)
			return true;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				isPrm = false;
				break;
			}
		}		
		return isPrm;
	}
	
	public static int sumOfDigits(long n){
		int sum = 0;
        long num = n;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
	
	public static int sumOfSqrOfDigits(long n){
		int sum = 0;
        long num = n;
		while(num > 0) {
			sum += ((num % 10)*(num % 10));
			num /= 10;
		}
		return sum;
	} 
    public static boolean isLucky(long n) {
		boolean isLky = false;
		if(isPrime(sumOfDigits(n))&&isPrime(sumOfSqrOfDigits(n)))
			isLky = true;
		return isLky;
	}
    static int luckyNumbers(long a,long b) {
      int noOfLky = 0;
	  for(long i = a; i <= b; i++) {
			if(isLucky(i)) {
				noOfLky++;
			}
		}		
		return noOfLky;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        long _a = 0,_b = 0;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            String next = in.nextLine();
            String[] next_split = next.split(" ");
            try {
            _a=Integer.parseInt(next_split[0]);
            }catch (NumberFormatException e) {
                System.out.println("You've entered non-integer number");
                System.out.println("This caused " + e);
            }
            try {
            	_b=Integer.parseInt(next_split[1]);
            }catch (NumberFormatException e) {
                System.out.println("You've entered non-integer number");
                System.out.println("This caused " + e);
            }
            
           res = luckyNumbers(_a,_b);
           System.out.println(res);
        }
    }
}