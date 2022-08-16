package io.github.jonathan.exception;

public class JsonBadFormattedException extends Exception {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	public JsonBadFormattedException() {
		super();
	}

	public JsonBadFormattedException(final String message) {
		super(message);
	}

}
