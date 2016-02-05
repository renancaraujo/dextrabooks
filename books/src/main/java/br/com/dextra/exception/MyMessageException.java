package br.com.dextra.exception;

public class MyMessageException extends RuntimeException{
	private String message = null;
	MyMessageException(){
		super();
	}

    public MyMessageException(String message) {
        super(message);
        this.message = message;
        
    }


    public MyMessageException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }


    public MyMessageException(Throwable cause) {
        super(cause);
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
