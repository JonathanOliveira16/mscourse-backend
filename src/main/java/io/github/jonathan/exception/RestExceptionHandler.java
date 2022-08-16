package io.github.jonathan.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.jonathan.controller.DTO.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(JsonBadFormattedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleJsonBadFormatted(final JsonBadFormattedException exception,
	final HttpServletRequest request) {

	log.error("error", exception);
	ExceptionResponse error = new ExceptionResponse();
	error.setErrorMessage("Bad formatted JSON");
	error.callerURL(request.getRequestURI());

	return error;
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleNotFound(final NotFoundException exception,
	final HttpServletRequest request) {

	log.error("error", exception);
	ExceptionResponse error = new ExceptionResponse();
	error.setErrorMessage("No data in database!");
	error.callerURL(request.getRequestURI());

	return error;
	}
	
}
