package edu.mum.olaf.restReciverController;

import javax.security.auth.login.CredentialNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.olaf.domain.dto.*;
import edu.mum.olaf.exception.ValidationException;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DomainErrors handleException(ValidationException exception) {
		return exception.getValidationErrors();
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public DomainErrors handleException(AccessDeniedException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setMessage(exception.getMessage());
		return errors;
	}
	
	@ExceptionHandler(CredentialNotFoundException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public DomainErrors handleException(CredentialNotFoundException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setMessage(exception.getMessage());
		return errors;
	}
//	
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.FORBIDDEN)
//	@ResponseBody
//	public DomainErrors handleException(Exception exception) {
//		DomainErrors errors = new DomainErrors();
//		errors.setMessage(exception.getMessage());
//		return errors;
//	}

}