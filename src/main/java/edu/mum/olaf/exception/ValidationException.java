package edu.mum.olaf.exception;

import edu.mum.olaf.domain.dto.DomainErrors;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private DomainErrors validationErrors;

	public ValidationException(DomainErrors validationErrors){
		this.validationErrors = validationErrors;
	}
	
	public DomainErrors getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(DomainErrors validationErrors) {
		this.validationErrors = validationErrors;
	}

}
