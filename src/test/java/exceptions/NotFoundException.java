package exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NotFoundException extends AssertionError {
    private final Date time;
    private final static String TIME_PATTERN = "yy-MM-dd HH:mm:ss";

    public NotFoundException(String message) {
        super(message);
        this.time = new Date();
    }

    public String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_PATTERN);
        return dateFormat.format(time);
    }
}
