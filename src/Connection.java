import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Connection {
    public Connection() {

    }

    public String getSite(String url) throws MalformedURLException, IOException {
	String code = "";
	InputStream is = null;

	URL url2 = new URL(url);
	is = url2.openStream();
	code = new Scanner(is).useDelimiter("\\Z").next();

	if (is != null) {
	    is.close();
	}

	return code;
    }
}
