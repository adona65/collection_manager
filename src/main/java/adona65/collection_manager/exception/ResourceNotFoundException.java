package adona65.collection_manager.exception;

/**
 * Exception class figuring "Resource not found" exception type.
 * 
 * @author adona65
 */
@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String id) {
		super("Could not find the resource " + id);
	}
}
