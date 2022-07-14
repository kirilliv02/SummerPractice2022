package exceptions;

public class LogoNotFoundException extends AssertionError {
    public LogoNotFoundException(String message) {
        super(message);
    }
}
