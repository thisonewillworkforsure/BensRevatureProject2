package com.project2.springbootwebjdbcdatalombok.exception;

public class ApplicationException extends Exception {
    public ApplicationException() {
        // TODO Auto-generated constructor stub
    	super("Internal Database Error! Please try again later!");
    }

    public ApplicationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
	
}
