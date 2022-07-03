package exceptions;

public class CityNameNotFoundException extends Throwable{
    public CityNameNotFoundException(String message) {
        super(message);
    }
}
