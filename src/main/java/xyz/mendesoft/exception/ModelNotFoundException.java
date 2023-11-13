package xyz.mendesoft.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND) //404
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message) {
        super(message);
    }
}
