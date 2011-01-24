import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Diese Klasse stellt einige einfache Methoden zur Ein- und Ausgabe auf einem
 * Terminal zur Verf&uuml;gung.
 * 
 * @author P. Pepper und Gruppe
 * @version 1.1 Modifiziert von A. Lochbihler
 * @version 1.2 Modifiziert von F. Kelbert
 */
public final class Terminal {

    /** Privater Konstruktor gegen Objekterzeugung */
    private Terminal() {
    }

    /** Ein Reader-Objekt, das bei allen Lesezugriffen verwendet wird. */
    private static BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));

    /** Allgemeine Fehlermeldung */
    private static final String ERROR = "Error!";
 
    /** Fehlermeldung fuer ungueltige byte-Eingabe */
    private static final String ERROR_INVALID_BYTE =
        "Ungueltige Byte-Zahl! (Nochmal eingeben) ";

    /** Fehlermeldung fuer ungueltige short-Eingabe */
    private static final String ERROR_INVALID_SHORT =
        "Ungueltige Short-Zahl! (Nochmal eingeben) ";

    /** Fehlermeldung fuer ungueltige int-Eingabe */
    private static final String ERROR_INVALID_INT =
        "Ungueltige Integer-Zahl! (Nochmal eingeben) ";

    /** Fehlermeldung fuer ungueltige long-Eingabe */
    private static final String ERROR_INVALID_LONG =
        "Ungueltige Long-Zahl! (Nochmal eingeben) ";

    /** Fehlermeldung fuer ungueltige float-Eingabe */
    private static final String ERROR_INVALID_FLOAT =
        "Ungueltige Float-Zahl! (Nochmal eingeben) ";

    /** Fehlermeldung fuer ungueltige double-Eingabe */
    private static final String ERROR_INVALID_DOUBLE =
        "Ungueltige Double-Zahl! (Nochmal eingeben) ";

    /** Fehlermeldung bei Eingabe eines leeren Arrays */
    private static final String ERROR_EMPTY_ARRAY =
        "Ein leeres Array ist nicht erlaubt! (Nochmal eingeben) ";

    /** Fehlermeldung bei Eingabe einer leeren Array-Zeile */
    private static final String ERROR_EMPTY_LINE =
        "Eine leere Zeile ist nicht erlaubt! (Nochmal eingeben) ";

    /** Fehlermeldung bei Eingabe einzeiliger Matrizen */
    private static final String ERROR_ONE_LINE_ARRAY =
        "Eine Matrix muss mindestens zwei Zeilen besitzen! (Nochmal eingeben) ";
    
    /** Fehler beim Lesen einer Datei */
    private static final String ERROR_READ_FILE =
        "Fehler beim Lesen der Datei! ";
    


    /**
     * Liest eine Zeichenkette vom Terminal.
     * 
     * @return das gelesene Zeichen. Modifiziert von A. L ochbihler, damit kein
     *         Null-String mehr zurueckgegeben wird.
     */
    public static String readString() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer Zeichenkette.
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Zeichenkette.
     */
    public static String askString(String prompt) {
        System.out.print(prompt);
        return readString();
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer Zeichenkette.
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Zeichenkette.
     */
    public static String ask(String prompt) {
        return askString(prompt);
    }

    /**
     * Liest einen Wahrheitswert vom Terminal. Die Zeichenkette "true"
     * (unabh&auml;ngig von Gro&szlig;-/Kleinschreibung) liefert true, alles
     * andere false.
     * 
     * @return der eingegebene Wert.
     */
    public static boolean readBoolean() {
        return Boolean.parseBoolean(getTokens()[0]);
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe eines Wahrheitswerts.
     * Die Zeichenkette "true" (unabh&auml;ngig von Gro&szlig;-/Kleinschreibung)
     * liefert true, alles andere false.
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return der eingegebene Wert.
     */
    public static boolean askBoolean(String prompt) {
        System.out.print(prompt);
        return readBoolean();
    }

    /**
     * Liest ein Zeichen vom Terminal. Zeilenumbruche zaehlen als eigene
     * Zeichen.
     * 
     * @return das gelesene Zeichen.
     */
    public static char readChar() {
        while (true) {
            String input = readString();
            
            if (input.length() == 0) {
                System.err.println(ERROR_EMPTY_LINE);
            } else {
                return input.charAt(0);
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe eines Zeichens.
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return das eingegebene Zeichen.
     */
    public static char askChar(String prompt) {
        System.out.print(prompt);
        return readChar();
    }

    /**
     * Liest eine ganze Zahl (8 Bit) vom Terminal.
     * 
     * @return die gelesene Zahl.
     */
    public static byte readByte() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Byte.parseByte(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_BYTE);
                }
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer ganzen Zahl (8
     * Bit).
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Zahl.
     */
    public static byte askByte(String prompt) {
        System.out.print(prompt);
        return readByte();
    }

    /**
     * Liest eine ganze Zahl (16 Bit) vom Terminal.
     * 
     * @return die gelesene Zahl.
     */
    public static short readShort() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Short.parseShort(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_SHORT);
                }
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer ganzen Zahl (16
     * Bit).
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Zahl.
     */
    public static short askShort(String prompt) {
        System.out.print(prompt);
        return readShort();
    }

    /**
     * Liest eine ganze Zahl (32 Bit) vom Terminal.
     * 
     * @return die gelesene Zahl.
     */
    public static int readInt() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Integer.parseInt(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_INT);
                }
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer ganzen Zahl
     * (32 Bit).
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Zahl.
     */
    public static int askInt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    /**
     * Liest eine ganze Zahl (64 Bit) vom Terminal.
     * 
     * @return die gelesene Zahl.
     */
    public static long readLong() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Long.parseLong(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_LONG);
                }
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer ganzen Zahl (64
     * Bit).
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Zahl.
     */
    public static long askLong(String prompt) {
        System.out.print(prompt);
        return readLong();
    }

    /**
     * Liest eine Gleitpunktzahl(32 Bit) vom Terminal.
     * 
     * @return die gelesene Zahl.
     */
    public static float readFloat() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Float.parseFloat(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_FLOAT);
                }
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer Gleitpunktzahl
     * einfacher Genauigkeit (32 Bit).
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Gleitpunktzahl.
     */
    public static float askFloat(String prompt) {
        System.out.print(prompt);
        return readFloat();
    }

    /**
     * Liest eine Gleitpunktzahl(64 Bit) vom Terminal.
     * 
     * @return die gelesene Zahl.
     */
    public static double readDouble() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Double.parseDouble(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_DOUBLE);
                }
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer Gleitpunktzahl
     * doppelter Genauigkeit (64 Bit).
     * 
     * @param prompt die auszugebende Zeichenkette.
     * @return die eingegebene Gleitpunktzahl.
     */
    public static double askDouble(String prompt) {
        System.out.print(prompt);
        return readDouble();
    }

    /**
     * Liest ein Integer-Array vom Terminal.
     * 
     * @return array das gelesene Array.
     * @throws NumberFormatException bei falschem Zahlenformat.
     */
    public static int[] readIntArray() {
        while (true) {
            String[] tokens = readString().split(",");
            if (tokens.length > 0) {
                int[] array = new int[tokens.length];

                try {
                    for (int i = 0; i < tokens.length; i++) {
                        array[i] = Integer.parseInt(tokens[i]);
                    }
                    
                    return array;
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_INT);
                }
            } else {
                System.err.println(ERROR_EMPTY_ARRAY);
            }
        }
    }

    /**
     * Liest eine Integer-Matrix vom Terminal.
     * 
     * @return matrix die gelesene Matrix..
     */
    public static int[][] readIntMatrix() {
        while (true) {
            String[] lineTokens = readString().split("/");

            if (lineTokens.length > 1) {
                String[][] tokens = new String[lineTokens.length][];
                int columns = 0;

                for (int line = 0; line < lineTokens.length; line++) {
                    tokens[line] = lineTokens[line].split(",");

                    if (tokens[line].length > columns) {
                        columns = tokens[line].length;
                    }
                }

                if (columns > 0) {
                    int[][] array = new int[lineTokens.length][columns];

                    try {
                        for (int line = 0; line < tokens.length; line++) {
                            for (int column = 0; column < tokens[line].length;
                                 column++) {
                                array[line][column] =
                                    Integer.parseInt(tokens[line][column]);
                            }
                        }

                        return array;
                    } catch (NumberFormatException e) {
                        System.err.println(ERROR_INVALID_INT);
                    }
                } else {
                    System.out.println(ERROR_EMPTY_LINE);
                }
            } else {
                System.out.println(ERROR_ONE_LINE_ARRAY);
            }
        }
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe eines Integer Arrays.
     * 
     * @param prompt die anzuzeigende Eingabeaufforderung
     * @return das gelesene Array.
     */
    public static int[] askIntArray(String prompt) {
        System.out.print(prompt);
        return readIntArray();
    }

    /**
     * Gibt eine Zeichenkette aus und erwartet die Eingabe einer Integer Matrix.
     * 
     * @param prompt die anzuzeigende Eingabeaufforderung
     * @return die gelesene Matrix.
     */
    public static int[][] askIntMatrix(String prompt) {
        System.out.print(prompt);
        return readIntMatrix();
    }


    /**
     * Liest eine Zeile von der Eingabe und spaltet Sie an whitespace-Zeichen
     * auf.
     * 
     * @return Array von Strings, die die 
     */
    private static String[] getTokens() {
        String line;
        try {
            line = in.readLine();
        } catch (IOException e) {
            throw new Error(e);
        }

        if (line == null) {
            System.err.println(ERROR);
            return null;
        } else {
            return line.split("\\s");
        }
    }
    
    
	/**
	 * the current day of the month
	 */
	public static final int TODAYS_DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	
	/**
	 * the current month
	 */
	public static final int TODAYS_MONTH = Calendar.getInstance().get(Calendar.MONTH) + 1;
	
	/**
	 * the current year
	 */
	public static final int TODAYS_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	/**
	 * a newline according to the used operating system
	 */
	public static final String NEWLINE = System.getProperty("line.separator");
	
	
	
	/**
	 * Liest die einzelnen Zeilen der Datei <code>fileName</code>
	 * und liefert die einzelnen in der entsprechenden Reihenfolge
	 * als {@link String}-Array zurueck.
	 * Der Rueckgabewert ist <code>null</code>, falls die Datei nicht
	 * exisitiert oder nicht gelesen werden kann.
	 * 
	 * @param fileName die zu lesende Datei
	 * @return die Zeilen der zu lesenden Datei als {@link String}-Array
	 * 		oder <code>null</code>, falls die Datei nicht existiert oder
	 * 		nicht gelesen werden kann.
	 */
	public static String[] readFile(String fileName) {
		BufferedReader bufferedReader;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.println(ERROR_READ_FILE + "(" + fileName + ") (" + e + ")");
			return null;
		}
		
		List<String> lines = new LinkedList<String>();
		
		try {
			String line = bufferedReader.readLine();
			
			while (line != null) {
				lines.add(line);				
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.err.println(ERROR_READ_FILE + "(" + fileName + ") (" + e + ")");
			return null;
		}
		
		return lines.toArray(new String[0]);
		
	}
	
	
	/**
	 * Creates a new {@link Calendar} instance from the specified {@link String}.
	 * 
	 * The format of the specified {@link String} has to be &quote;dd.MM.yyyy-HH:mm&quote;
	 * If the String does not have this format, a {@link ParseException} will be thrown. 
	 * This is the inverse function to {@link Terminal#calendarToString(Calendar)}.
	 *
	 * 
	 * @param strDate the String to be converted into a {@link Calendar} object.
	 * @return a {@link Calendar} object representing the date and time in the specified string.
	 * @throws ParseException if the specified string is invalid
	 */
	public static Calendar createCalendar(String strDate) throws ParseException {
		if (!strDate.matches("((0[1-9])|([1-2][0-9])|(3[0-1]))."		// dd.
				+ "((0[1-9])|(1[0-2]))."								// MM.
				+ "((19[0-9]{2}+)|(2[0-9]{3}+))-"						// yyyy-
				+ "(([0-1][0-9])|(2[0-3])):"							// HH:
				+ "([0-5][0-9])")) {									// mm
			throw new ParseException("Invalid date: " + strDate, -1);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(strDate));
		
		return cal;
	}
	
	
	/**
	 * Returns a {@link String} representation of the specified {@link Calendar}.
	 * 
	 * The returned {@link String} has the format &quote;dd.MM.yyyy-HH:mm&quote;.
	 * If the specified {@link Calendar} object is <code>null</code>, <code>null</code>
	 * is returned.
	 * 
	 * @param cal the {@link Calendar} to be converted into a {@link String}.
	 * @return a {@link String} representing the specified {@link Calendar}
	 * 		or <code>null</code>, if the argument was <code>null</code>
	 */
	public static String calendarToString(Calendar cal) {
		String strdate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
		
		if (cal != null) {
			strdate = sdf.format(cal.getTime());
		}
		
		return strdate;
	}
}
