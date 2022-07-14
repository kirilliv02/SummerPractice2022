package exceptions;

public class SearchButtonNotFoundException extends AssertionError{

    public SearchButtonNotFoundException(String message) {
        super(message);
    }
}
