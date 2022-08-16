package io.github.jonathan.controller.DTO;

import lombok.Data;

@Data
public class ExceptionResponse {
	private String errorMessage;
	private String requestedURI;
	
	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}
}
