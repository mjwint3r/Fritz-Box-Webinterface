import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Connection {
    public Connection() {

    }
    public String getSite(String url) {
	String code = "";
	InputStream is = null;
	try {
	    URL url2 = new URL(url);
	    is = url2.openStream();
	    code = new Scanner(is).useDelimiter("\\Z").next();
	} catch (MalformedURLException e) {
	    code = "Falsche Eingabe";
	} catch (IOException e) {

	} finally {
	    if (is != null)
		try {
		    is.close();
		} catch (IOException e) {
		    
		}
	}
	return code;
    }
}
