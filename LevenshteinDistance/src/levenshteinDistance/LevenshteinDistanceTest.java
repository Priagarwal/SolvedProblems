package levenshteinDistance;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevenshteinDistanceTest {

	
	@Test
	public void testMinimum() {
		LevenshteinDistance l = new LevenshteinDistance();
		assertEquals(l.minimum(5, 12, 1), 1);
		assertEquals(l.minimum(5, 1, 1), 1);
		assertEquals(l.minimum(5, 5, 5), 5);
	}

	
	@Test
	public void testComputeLevenshteinDistance() {
		LevenshteinDistance l = new LevenshteinDistance();
		assertEquals(l.computeLevenshteinDistance("" , "polo"), 4);
		assertEquals(l.computeLevenshteinDistance("horse" , ""), 5);
		assertEquals(l.computeLevenshteinDistance("" , ""), 0);
		assertEquals(l.computeLevenshteinDistance("kitten" , "sitting"), 3);
	}

	
}
