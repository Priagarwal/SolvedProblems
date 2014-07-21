package url;

public class URL {
	String url;
	String protocol;
	String domain;
	String path;

	private final String PATTERNWITHOUTPROTOCOL ="^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private final String PATTERNWITHPROTOCOL ="^(http(s{0,1})?|ftp|file|wais|mailto|gopher|news|nntp|telnet|prospero)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";


	URL(String url) {
		this.url = url;
		protocol = "";
		domain = "";
		path = "";
	}

	boolean hasProtocol() {
		return url.matches(PATTERNWITHPROTOCOL);
	}

	String extractProtocol() {
		if (this.isValidURL()) {
			if (this.hasProtocol()) {
				protocol = url.substring(0, url.indexOf("://"));
			} else {
				protocol = "";
			}
			return protocol;
		}
		return "Invalid URL";
	}

	public String extractDomain() {
		if (this.isValidURL()) {
			String temp = url.substring(url.indexOf("://") + 3);
			if (temp.indexOf('/') != -1)
				domain = temp.substring(0, temp.indexOf('/'));
			else
				domain = temp;
			return domain;
		}
		return "Invalid URL";
	}

	String extractPath() {
		if (this.isValidURL()) {
			for (int i = 1; i < url.length() - 1; i++) {
				if (url.charAt(i) == '/' && url.charAt(i + 1) != '/'
						&& url.charAt(i - 1) != '/') {
					return url.substring(i + 1);
				}
			}
		}
		return "Invalid URL";
	}

	boolean isValidURL() {

		if (url == null) {
			return false;
		}

		return url.matches(PATTERNWITHPROTOCOL)
				|| url.matches(PATTERNWITHOUTPROTOCOL);

	}

	public static void main(String[] args) {
		URL u = new URL("ftp://a.large.site/abc");
		System.out.println(u.extractProtocol());
		System.out.println(u.extractDomain());
		System.out.println(u.extractPath());
		u.url = "mailto:user@host";
		//System.out.println(u.extractProtocol());
		System.out.println(u.extractDomain());
		//System.out.println(u.extractPath());
	}

}
