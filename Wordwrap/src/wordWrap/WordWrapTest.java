package wordWrap;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WordWrapTest {

	@Test
    public void testGetNextLine() {

         WordWrap Awrap = new WordWrap(5);
         assertEquals(Awrap.getNextLine("abcde"), "abcde");
         assertEquals(Awrap.getNextLine("abcde "), "abcde");
         assertEquals(Awrap.getNextLine(" abcde"), "abcde");
    }


	@Test
	public void testWordWrap() {
		WordWrap Awrap = new WordWrap(5);
		String aText = " ";
		String bText = "abcde";
		String cText = "abcde ";
		String dText = " abcde";
		String eText = " abcde ";
		String fText = "abcde fghijk";
		String gText = " TDD completely turns traditional development around. When you first go to implement a new feature, the first question that you ask is whether the existing design is the best design possible that enables you to implement that functionality.  If so, you proceed via a TFD approach. ";
		ArrayList<String> testArrayList = new ArrayList<String>();
		testArrayList.add("");
		assertTrue( Awrap.isEqual(testArrayList, Awrap.wordWrap(aText)));
		assertTrue( Awrap.isEqual(new ArrayList<String>({"abcde"}, "hi"), Awrap.wordWrap(bText)));
		assertFalse( Awrap.isEqual(new ArrayList<String>("abc","de"), Awrap.wordWrap(bText)));
	}

	/*
	@Test
	public void testFit() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testWordWrap1() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayLines() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}
*/
}
