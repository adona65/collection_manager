package adona65.collection_manager.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Controller that manage all Exceptions throwned by Rest Services. Put them in good shape then send the answer to the
 * service caller.
 * 
 * @author adona65
 */
@RestControllerAdvice
public class ExceptionHandlerController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	/**
	 * Exception Handler that catch all exceptions of type "Resource not found".
	 * 
	 * @param ex The type of handled exception.
	 * @param request The request that called the service in error.
	 * 
	 * @return The well shaped error answer (with HTTP 404).
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		logger.info("Exception handled in ExceptionHandlerController/resourceNotFoundException.");
		
		ErrorMessage message = new ErrorMessage(
			HttpStatus.NOT_FOUND.value(),
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		
		return message;
	}
	
	/**
	 * Exception Handler that catch all exceptions of type "Unauthorized not found".
	 * 
	 * @param ex The type of handled exception.
	 * @param request The request that called the service in error.
	 * 
	 * @return The well shaped error answer (with HTTP 401).
	 */
	// TODO : not reached because http 401 is catch by spring framework, not raised by some controller's method.
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public ErrorMessage unauthorizedException(ResourceNotFoundException ex, WebRequest request) {
		logger.info("Exception handled in ExceptionHandlerController/unauthorizedException.");
		
		ErrorMessage message = new ErrorMessage(
			HttpStatus.UNAUTHORIZED.value(),
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		
		return message;
	}
	
	/**
	 * Exception Handler that catch all exceptions of Spring's type "HttpMessageNotReadableException".
	 * 
	 * @param ex The type of handled exception.
	 * @param request The request that called the service in error.
	 * 
	 * @return The well shaped error answer (with HTTP 500).
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage httpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
		logger.info("Exception handled in ExceptionHandlerController/httpMessageNotReadableException.");
		logger.info("Exception is : " + ex.getMessage());
		
		ErrorMessage message = new ErrorMessage(
			HttpStatus.NOT_FOUND.value(),
			new Date(),
			"Server didn't manage to read sended request. Please check your request's format and content.",
			request.getDescription(false)
		);
		
		return message;
	}

	/**
	 * Exception Handler that catch all exceptions not managed by other Exception Handlers.
	 * 
	 * @param ex The type of handled exception.
	 * @param request The request that called the service in error.
	 * 
	 * @return The well shaped error answer (with HTTP 500).
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
		logger.info("Exception handled in ExceptionHandlerController/globalExceptionHandler.");
		
		ErrorMessage message = new ErrorMessage(
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			new Date(),
			ex.getMessage(),
			request.getDescription(false)
		);
		  
		return message;
	}

}
