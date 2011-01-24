

public class UI {
    private static Connection con;
    
    public static void main(String[] args) {
	boolean running = true;
	con = new Connection();
	String input = "";
	
	while (running) {
	    System.out.println("URL eingeben:");
	    input = Terminal.ask(">");
	    if (input.equals("exit")) {
		running = false;
	    } else {
	System.out.println(con.getSite(input));
	    }
	}

	
    }
}