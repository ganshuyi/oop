package assignment04;

public class AlreadyExistInDicException extends Exception {
	
	public AlreadyExistInDicException() {
		super("This word already exists in dictionary");
	}
	
	public AlreadyExistInDicException (String message) {
		super(message);
	}
	
}
