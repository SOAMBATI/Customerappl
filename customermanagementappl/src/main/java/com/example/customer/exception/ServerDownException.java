package com.example.customer.exception;

public class ServerDownException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerDownException() {
        super("Server is down.");
    }

    public ServerDownException(String message) {
        super(message);
    }

    public ServerDownException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerDownException(Throwable cause) {
        super(cause);
    }
}

