import java.io.*;
import java.net.MalformedURLException;

public class UI {
    private static Connection con;
    private static BufferedReader in = new BufferedReader(
	    new InputStreamReader(System.in));

    public static void main(String[] args) {
	boolean running = true;
	con = new Connection();
	String input = "";

	while (running) {
	    System.out.println("URL eingeben:");
	    input = ask(">");
	    if (input.equals("exit")) {
		running = false;
	    } else {
		try {
		    if (input.substring(0, 7).equals("http://")) {
			System.out.println(con.getSite(input));
		    } else {
			System.out.println(con.getSite("http://" + input));
		    }
		} catch (MalformedURLException e) {
		    System.out.println("Falsche Eingabe");
		} catch (IOException e) {
		    System.out.println("Verbindungsfehler");
		}
	    }
	}

    }

    public static String askString(String prompt) {
	System.out.print(prompt);
	return readString();
    }

    public static String readString() {
	try {
	    return in.readLine();
	} catch (IOException e) {
	    throw new Error(e);
	}
    }

    public static String ask(String prompt) {
	return askString(prompt);
    }

}