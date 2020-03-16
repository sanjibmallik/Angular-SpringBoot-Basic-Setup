package com.example.demo.advice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.ErrorMessage;
import com.example.demo.model.Problem;



@ControllerAdvice @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE) 
public class GlobalControllerAdvice //extends ResponseEntityExceptionHandler  
{
	/**
	 * Note use base class if you wish to leverage its handling.
	 * Some code will need changing.
	 */
	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);
    
    @ExceptionHandler(Throwable.class) 
    public ResponseEntity < Problem > problem(final Throwable e) {
        String message =e.getMessage();
		//might actually prefer to use a geeric mesasge
		
		message="Problem occured";
		UUID uuid = UUID.randomUUID();
		String logRef=uuid.toString();
		logger.error("logRef="+logRef, message, e);
		return new ResponseEntity <Problem> (new Problem(logRef, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }
   
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
    		) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }
        ErrorMessage errorMessage = new ErrorMessage(errors);
        Object result=errorMessage;
        //Object result=ex.getBindingResult();//instead of above can allso pass the more detailed bindingResult
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

   
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class) 
    public ResponseEntity<ErrorMessage> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex 
    		) {
        String unsupported = "Unsupported content type: " + ex.getContentType();
        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
        ErrorMessage errorMessage = new ErrorMessage(unsupported, supported);
        return new ResponseEntity(errorMessage, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class) 
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ErrorMessage errorMessage;
        if (mostSpecificCause != null) {
            String exceptionName = mostSpecificCause.getClass().getName();
            String message = mostSpecificCause.getMessage();
            errorMessage = new ErrorMessage(exceptionName, message);
        } else {
            errorMessage = new ErrorMessage(ex.getMessage());
        }
        return new ResponseEntity(errorMessage,  HttpStatus.BAD_REQUEST);
    }
   
}