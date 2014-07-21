package wordWrap;

import java.util.ArrayList;
import java.util.Iterator;


	public class WordWrap {

	    private int screenLength;
	    
	    public WordWrap(int screenLength) {
	        this.screenLength = screenLength;
	    }
	    
	    public String getNextLine(String s) {
	    
	        return s.substring(0, Math.min(s.length(), screenLength));
	    }
	    
	    public boolean isEqual(ArrayList<String> Astrings, ArrayList<String> Bstrings) {
	        Iterator<String> AStringItr = Astrings.iterator();
	        Iterator<String> BStringItr = Astrings.iterator();
	        while (AStringItr.hasNext()) {
	              if (AStringItr.next() != BStringItr.next())
	                  return false;
	        }
	        return (!BStringItr.hasNext());
	        }

	    
	    public ArrayList<String> wordWrap(String text) {
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = "";
	        
	        while (text.length() > 0) {
	            line = getNextLine(text);
	            lines.add(line.trim());
	            System.out.println("TEXT:" + text + ":" + text.length() + ":'" + getNextLine(text) + "'");
	            text = text.substring(Math.min(text.length(), line.length()));
	        }
	        System.out.println("!TEXT:" + text + ":" + text.length());
	        
	        return lines;
	    }
	    
	    public String displayLines(ArrayList<String> lines) {
	        String output = "";
	        
	        for(String i: lines) {
	            output += i + "\n";
	        }
	        
	        return output;
	    }

	}


