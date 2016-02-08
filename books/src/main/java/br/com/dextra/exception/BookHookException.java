package br.com.dextra.exception;

import io.yawp.commons.http.HttpException;

public class BookHookException extends MyMessageException {

	public BookHookException(String message) {
		super(message);
	}

}
