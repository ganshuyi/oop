package assignment04;

public class EmptyException extends Exception {
	
	public EmptyException() {
		super("List is empty");
	}
	
	public EmptyException (String message) {
		super(message);
	}
	
}
