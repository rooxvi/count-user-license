package io.ravi.countlicense.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static Logger logger = LogManager.getLogger("applogs");

	@ExceptionHandler(value = { BaseException.class })
	public ResponseEntity<Error> handleApplicationException(BaseException ex, WebRequest request) {
		logger.trace("Web request :: {}", request);
		logger.trace("Exception Message :: {}", ex.getMessage());
		
			
		return new ResponseEntity<>(new Error(ex.getCode(), ex.getDesc()), HttpStatus.NOT_FOUND);

	}

}
