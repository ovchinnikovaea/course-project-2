package pro.sky.java.course2.courseproject2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionException extends RuntimeException {
    public NotEnoughQuestionException() {
    }

    public NotEnoughQuestionException(String s) {
    }

    public NotEnoughQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughQuestionException(Throwable cause) {
        super(cause);
    }

    public NotEnoughQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
