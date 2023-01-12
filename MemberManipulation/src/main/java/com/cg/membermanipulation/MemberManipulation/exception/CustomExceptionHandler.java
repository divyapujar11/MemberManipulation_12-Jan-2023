package com.cg.membermanipulation.MemberManipulation.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
	
//	@ExceptionHandler(AddressNotValidException.class)
//	ResponseEntity<?> handleInvalidArgumentException(Exception exception, ServletWebRequest request){
//		APIerror apiError = new APIerror();
//		
//		apiError.setTimeStamp(LocalDateTime.now());
//		apiError.setUriPath(request.getDescription(false));
//		apiError.setStatus(HttpStatus.BAD_REQUEST);
//		apiError.setErrors(exception.getMessage());
//		
//		return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
//		
//	}
	
		@ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errorMap.put(error.getField(), error.getDefaultMessage());
	        });
	        return errorMap;
	    }
	
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(AddressNotValidException.class)
	    public Map<String, String> handleAddressNotValidException(AddressNotValidException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
	    
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(AlreadyExistedMemberException.class)
	    public Map<String, String> handleAlreadyExistedMemberException(AlreadyExistedMemberException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
	    
	
}
