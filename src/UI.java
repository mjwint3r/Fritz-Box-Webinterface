import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
	InputStream is = null;
	try {
	    URL url = new URL("http://www.tutego.com/index.html");
	    System.out.println(url.getHost());
	    is = url.openStream();
	    System.out.println(new Scanner(is).useDelimiter("\\Z").next());
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {

	} finally {
	    if (is != null)
		try {
		    is.close();
		} catch (IOException e) {
		    
		}
	}
    }
}