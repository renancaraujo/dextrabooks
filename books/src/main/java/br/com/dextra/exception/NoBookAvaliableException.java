package br.com.dextra.exception;

public class NoBookAvaliableException extends MyMessageException {
	NoBookAvaliableException() {
		super();
	}

	public NoBookAvaliableException(String message) {
		super(message);

	}

	public NoBookAvaliableException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoBookAvaliableException(Throwable cause) {
		super(cause);
	}

}
