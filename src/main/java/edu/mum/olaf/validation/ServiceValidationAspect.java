package edu.mum.olaf.validation;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import edu.mum.olaf.domain.dto.DomainError;
import edu.mum.olaf.domain.dto.DomainErrors;
import edu.mum.olaf.exception.ValidationException;

@Aspect
@Component
public class ServiceValidationAspect {

	@Autowired
	private Validator validator;

	@Autowired
	MessageSourceAccessor messageAccessor;

	@Pointcut("execution(* edu.mum.olaf.service..*(..))")
	public void applicationMethod() {}

	@Pointcut("args(object)")
	public void argsMethod(Object object) {}
	
	 @Pointcut("@annotation(edu.mum.olaf.validation.ServiceValidation)")
	 public void validate() {}

	@Before("validate() && applicationMethod() && argsMethod(object)")
	public void doValidate(Object object) throws ValidationException {

		Errors errors = new BeanPropertyBindingResult(object, object.getClass().getName());

		validator.validate(object, errors);

		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
			DomainErrors domainErrors = new DomainErrors();
			
			for (FieldError fieldError : fieldErrors) {
				DomainError domainError = new DomainError();
				domainError.setMessage(messageAccessor.getMessage(fieldError));
				domainErrors.getErrors().add(domainError);
			}
			throw new ValidationException(domainErrors);
		}

		return;
	}
}
