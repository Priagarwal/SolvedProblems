package triangle;

public class Triangle {

	float a;
	float b;
	float c;
	
	Triangle( float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	boolean isInvalid() {
		boolean valid = true;
		if ( a + b <= c || a + c <= b || b + c <= a) {
			valid = false;
		}
		if ( a < 0 || b < 0 || c < 0) {
			valid = false;
		}
		return(!valid);
	}
	String triangleType() {
		String s = new String("") ;
		if ( isInvalid()) {
			s = "Invalid Triangle" ;
		} else if ( a == b) {
			if ( a== c ) {
				s = "Equilateral Triangle";
			} else {
				s = "Isosceles";
			}
		} else if ( a == c || b == c) {
			s = "Isosceles";			
		} else {
			s = "Scalene";
		}
		
		return s;
	}
	public static void main(String[] args) {
		Triangle t = new Triangle( 10, 10, 10);
		System.out.println(t.triangleType());
	}

}
