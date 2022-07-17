package logger;

import exceptions.NotFoundException;
import org.junit.rules.ErrorCollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    public static void saveLogs(ErrorCollector errorCollector, String className) {
        List<Throwable> errors;
        try {
            Field field = errorCollector.getClass().getDeclaredField("errors");
            field.setAccessible(true);
            errors = (ArrayList<Throwable>) field.get(errorCollector);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (!errors.isEmpty()) {
            File file = new File("logs/log-" + className + ".txt");
            try (PrintWriter writer = new PrintWriter(file, String.valueOf(StandardCharsets.UTF_8))) {
                for (Throwable error : errors) {
                    try {
                        NotFoundException exception = (NotFoundException) error;
                        writer.println(exception.getTime() + " " + exception.getMessage());
                    } catch (RuntimeException e) {
                        throw new RuntimeException();
                    }
                }
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
