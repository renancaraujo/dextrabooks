package br.com.dextra.exception;

import io.yawp.commons.http.HttpException;

public class MyMessageException extends HttpException{
	private String message = null;

    public MyMessageException(String message) {
        super(500,message);
        this.message = message;
        
    }

    @Override
    public String toString(){
    	return message;
    } 
    
    @Override 
    public String getMessage() {
        return message;
    }

	
}
