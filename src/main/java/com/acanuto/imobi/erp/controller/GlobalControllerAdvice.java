package com.acanuto.imobi.erp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acanuto.imobi.erp.util.ErrorMessage;
import com.acanuto.imobi.erp.util.ExceptionResponse;
import com.acanuto.imobi.erp.util.Function;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> authenticationExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(Function.getDateTime("dd/MM/yyyy hh:mm:ss"),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(Function.getDateTime("dd/MM/yyyy hh:mm:ss"),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(RuntimeException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(Function.getDateTime("dd/MM/yyyy hh:mm:ss"),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ExceptionResponse> problem(final Throwable e) {
		return new ResponseEntity<ExceptionResponse>(
				new ExceptionResponse(Function.getDateTime("dd/MM/yyyy hh:mm:ss"), e.getMessage(), ""),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		List<String> errors = new ArrayList<String>(fieldErrors.size() + globalErrors.size());
		String error;
		for (FieldError fieldError : fieldErrors) {
			error = fieldError.getField() + ": " + fieldError.getDefaultMessage();
			errors.add(error);
		}
		for (ObjectError objectError : globalErrors) {
			error = objectError.getObjectName() + ": " + objectError.getDefaultMessage();
			errors.add(error);
		}
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//	public ResponseEntity<ErrorMessage> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
//		String unsupported = "Unsupported content type: " + ex.getContentType();
//		String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
//		ErrorMessage errorMessage = new ErrorMessage(unsupported, supported);
//		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
//	}

//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
//		Throwable mostSpecificCause = ex.getMostSpecificCause();
//		ErrorMessage errorMessage;
//		if (mostSpecificCause != null) {
//			String exceptionName = mostSpecificCause.getClass().getName();
//			String message = mostSpecificCause.getMessage();
//			errorMessage = new ErrorMessage(exceptionName, message);
//		} else {
//			errorMessage = new ErrorMessage(ex.getMessage());
//		}
//		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//	}

}