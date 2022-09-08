package assignment04;

public class NotInDicException extends Exception {
	
	public NotInDicException() {
		super("This word does not exist in dictionary");
	}
	
	public NotInDicException (String message) {
		super(message);
	}
}
