package adona65.collection_manager.exception;

/**
 * Exception class figuring "Resource not found" exception type.
 * 
 * @author adona65
 */
@SuppressWarnings("serial")
public class UnauthorizedException extends RuntimeException {

	public UnauthorizedException(String id) {
		super("You're not authorized to perform this call. Please provide correct credentials.");
	}
}
