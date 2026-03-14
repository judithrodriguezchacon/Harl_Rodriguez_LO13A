package clueGame;

//special exception message for bad data input
public class BadConfigFormatException extends Exception {
	public BadConfigFormatException() {
		super("The File input was configured poorly.");
	}
	
	public BadConfigFormatException(String message) {
		super(message);
	}
}
