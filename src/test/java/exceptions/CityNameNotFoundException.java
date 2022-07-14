package exceptions;

public class CityNameNotFoundException extends Error {
    public CityNameNotFoundException(String message) {
        super(message);
    }
}
