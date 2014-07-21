package triangle;

import java.util.HashMap;
import java.util.Map;

public class TriangleTester {

	
	static Map<Triangle, String> type = new HashMap<Triangle, String>();
	
	static boolean testTriangle(Triangle t) {
		if ( type.get(t) == t.triangleType()) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Triangle t = new Triangle(15, 20, 15);
		type.put(t,"Isosceles");
		if ( testTriangle(t) ) {
			System.out.println("Fails");
		} else {
			System.out.println("Passed");
		}
	}	

}
