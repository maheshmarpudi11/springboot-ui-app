package com.example.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> catchRuntimeException(RuntimeException e){
		
		ErrorResponse er = new ErrorResponse();
		er.setErrorDesc(e.getMessage());
		er.setErrorCode("500");
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.INTERNAL_SERVER_ERROR);  // error object and 500
	}	
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<ErrorResponse> catchProductNotFoundException(RuntimeException e){
		
		ErrorResponse er = new ErrorResponse();
		er.setErrorDesc(e.getMessage());
		er.setErrorCode("300");
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.OK);  // error object and 500
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String,String> errors = new HashMap<String,String>();
		
		List<ObjectError> ObjErrors = ex.getBindingResult().getAllErrors();
		for (ObjectError error : ObjErrors) {
			errors.put(((FieldError)error).getField() , error.getDefaultMessage());
		}
		
		    ErrorResponse errorResponse = new ErrorResponse();
		    errorResponse.setMaperrrors(errors);
		    errorResponse.setErrorCode("400");
		    errorResponse.setErrorDesc("invalid inputs.");
		    
		    
		    
		    return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}

}
