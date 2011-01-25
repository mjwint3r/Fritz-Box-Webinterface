import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * The class {@code Connection} represents a Connection to a website.
 * 
 * @author moritz
 * 
 */
public class Connection {
    public Connection() {

    }

    /**
     * Returns the html-sourcecode from the website at url.
     * 
     * @param url
     *            the specified URL
     * @return the html-sourcecode
     * @throws MalformedURLException
     * @throws IOException
     */
    public String getSite(String url) throws MalformedURLException, IOException {
	String code = "";
	InputStream is = null;

	URL url2 = new URL(url);
	is = url2.openStream(); // = openConnection().getInputStream();
	code = new Scanner(is).useDelimiter("\\Z").next();

	if (is != null) {
	    is.close();
	}

	return code;
    }

}
