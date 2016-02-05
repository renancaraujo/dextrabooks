package br.com.dextra.exception;

public class BookHookException extends MyMessageException {
	BookHookException() {
		super();
	}

	public BookHookException(String message) {
		super(message);

	}

	public BookHookException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookHookException(Throwable cause) {
		super(cause);
	}

}
