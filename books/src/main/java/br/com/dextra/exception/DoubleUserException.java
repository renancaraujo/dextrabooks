package br.com.dextra.exception;

public class DoubleUserException extends MyMessageException {
	DoubleUserException() {
		super();
	}

	public DoubleUserException(String message) {
		super(message);

	}

	public DoubleUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoubleUserException(Throwable cause) {
		super(cause);
	}

}
