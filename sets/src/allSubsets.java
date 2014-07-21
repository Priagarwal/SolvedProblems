import java.util.*;

public class allSubsets {
	ArrayList<Character> givenSet = new ArrayList<Character>();
	ArrayList<ArrayList<Character>> powerSet = new ArrayList<ArrayList<Character>>();

	ArrayList<ArrayList<Character>> createPowerSet(int index) {
		ArrayList<ArrayList<Character>> pSet = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> h1 = new ArrayList<Character>();
		char e = givenSet.get(index);
		h1.add(e);
		if (index < givenSet.size() - 1) {			
			ArrayList<ArrayList<Character>> powerSubSet = new ArrayList<ArrayList<Character>>();
			powerSubSet = createPowerSet(index + 1);
			for (ArrayList<Character> l : powerSubSet) {
				ArrayList<Character> l1 = new ArrayList<Character>();
				l1.addAll(l);
				pSet.add(l1);
				l.add(e);
				pSet.add(l);
			}
		}
		pSet.add(h1);
		return pSet;
	}

	public static void main(String args[]) {
		char a[] = ("aim").toCharArray();
		allSubsets mySet = new allSubsets();
		for (char i : a)
			mySet.givenSet.add(i);
		System.out.println(mySet.givenSet);
		mySet.powerSet = mySet.createPowerSet(0);
		
		System.out.println(mySet.powerSet);
		// for(ArrayList<Character> h:myPowerSet) {
		// System.out.println(h);
		// }
	}
}