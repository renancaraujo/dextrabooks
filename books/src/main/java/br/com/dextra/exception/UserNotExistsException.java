package br.com.dextra.exception;

public class UserNotExistsException extends MyMessageException {
	UserNotExistsException() {
		super();
	}

	public UserNotExistsException(String message) {
		super(message);

	}

	public UserNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotExistsException(Throwable cause) {
		super(cause);
	}

}
