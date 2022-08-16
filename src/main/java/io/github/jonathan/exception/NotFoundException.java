package io.github.jonathan.exception;

public class NotFoundException extends Exception  {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(final String message) {
		super(message);
	}
}
