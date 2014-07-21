package url;

import static org.junit.Assert.*;

import org.junit.Test;



public class URLTest {

	@Test
	public void testExtractProtocol() {
		URL u = new URL("http://www.google.com/abc");
        assertEquals(u.extractProtocol(), "http");
        URL v = new URL("www.google.com/abc");
        assertEquals(v.extractProtocol(), "");
        u.url = "";
        assertEquals(u.extractProtocol(), "Invalid URL");
        u.url = "ftp://internet.address.edu/file/path/file.txt" ;
        assertEquals(u.extractProtocol(), "ftp");
        u.url = "gopher://gumby.brain.headache.edu:151/7fonebook.txt";
        assertEquals(u.extractProtocol(), "gopher");
        u.url = "wais://host_and_port/database" ;
        assertEquals(u.extractProtocol(), "wais");
        u.url = "telnet://flober.rodent.edu" ;
        assertEquals(u.extractProtocol(), "telnet");
        u.url = "news://domain.name.edu:port/news.group";
        assertEquals(u.extractProtocol(), "news");
        //u.url = "mailto:user@host?subject=Happy%20lobsters";
        //assertEquals(u.extractProtocol(), "news");
	}

	@Test
    public void testIsValidURL() {
        URL u = new URL("www.google.com");
        assertTrue(u.isValidURL());
        u.url = "http://www.google.com";
        assertTrue(u.isValidURL());
        u.url = "http://www.google.com";
        assertTrue(u.isValidURL());
        u.url = "www.google.com/hi.php";
        assertTrue(u.isValidURL());
        u.url = "http://www.google.com:80/hi.java";
        assertTrue(u.isValidURL());
        u.url = "";
        assertFalse(u.isValidURL());
        u.url = "http://www.b.a.com:80";
        assertTrue(u.isValidURL());
        u.url = "http://www.b.a.com:80/";
        assertTrue(u.isValidURL());
        u.url = "http://www.b.a.com:80/hello/hi.java";
        assertTrue(u.isValidURL());
        u.url = "http://www.google.com:80/hi/hello/hi.java";
        assertTrue(u.isValidURL());
        u.url = "http://www.b.a.com:80/~hi/he----llo/hi.java";
        assertTrue(u.isValidURL());
        u.url = "http://www.google.com:80/hi/hello:/hi.java";
        assertTrue(u.isValidURL());
        u.url = "ftp://internet.address.edu/file/path/file.txt" ;
        assertTrue(u.isValidURL());
    }
	public void testextractPath() {
		URL u1 = new URL ("http://www.google.com/majorproject/test.cpp/");
		assertEquals("majorproject/test.cpp/",u1.extractPath());
		URL u2 = new URL ("http://www.google.com/");
		assertEquals("",u2.extractPath());
		u2.url = "http://www.google.com:80/~hi.java";
		assertEquals("~hi.java",u2.extractPath());
		u2.url = "http://www.google.com:80/hi/hello:/hi.java";
		assertEquals("hi/hello:/hi.java",u2.extractPath());
		u2.url = "http://www.b.a.com:80/~hi/he----llo/hi.java";
		assertEquals("~hi/he----llo/hi.java",u2.extractPath());
		}

	
	@Test
    public void testExtractDomain() {
        String url1 = "http://some.thing/";
        String domain1 = "some.thing";
        URL u1 = new URL(url1);
        assertEquals(domain1, u1.extractDomain());
        
        String url2 = "ftp://a.large.site" ;
        String domain2 = "a.large.site";
        URL u2 = new URL(url2);
        assertEquals(domain2, u2.extractDomain());
        u2.url = "http://www.google.com:80/~hi.java";
        assertEquals("www.google.com:80", u2.extractDomain());
        u2.url = "http://www.b.a.com:80/hello/hi.java";
        assertEquals("www.b.a.com:80", u2.extractDomain());
    }

}
