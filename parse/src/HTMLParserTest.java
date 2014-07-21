//import javax.swing.text.html.parser.*;
import org.htmlparser.Parser;

import org.htmlparser.Node;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.MetaTag;
import org.htmlparser.util.*;


public class HTMLParserTest {
    public static void main(String... args) {
        Parser parser = new Parser();
        //<meta name="description" content="Some texte about the sit e." />
        HasAttributeFilter filter = new HasAttributeFilter("name", "description");
        try {
            parser.setResource("https://github.com/search?l=php&q=pretty_print&ref=searchresults&type=Code");
            NodeList list = parser.parse(filter);
            Node node = list.elementAt(0);

            if (node instanceof MetaTag) {
                MetaTag meta = (MetaTag) node;
                String description = meta.getAttribute("content");

                System.out.println(description);
                // Prints: "YouTube is a place to discover, watch, upload and share videos."
            }

        } catch (ParserException e) {
            e.printStackTrace();
        }
//        String inputHTML = readFile("filemakerExport.htm","UTF-8");
//        Parser parser = new Parser();
//        parser.setInputHTML(inputHTML);
//        parser.setEncoding("UTF-8");    
        NodeList nl;
		try {
			nl = parser.parse(null);
			NodeList trs = nl.extractAllNodesThatMatch(new TagNameFilter("pretty"),true);
	        for(int i=0;i<trs.size();i++) {
	            NodeList nodes = trs.elementAt(i).getChildren();
	            NodeList tds  = nodes.extractAllNodesThatMatch(new TagNameFilter("pretty"),true);
	            Node node = tds.elementAt(0);

	            if (node instanceof MetaTag) {
	                MetaTag meta = (MetaTag) node;
	                String description = meta.getAttribute("content");

	                System.out.println(description);
	                // Prints: "YouTube is a place to discover, watch, upload and share videos."
	            }
	            // Do stuff with tds
	        }
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    }

}