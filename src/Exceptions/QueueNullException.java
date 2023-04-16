package Exceptions;

public class QueueNullException extends Exception{
    private final String message;

    public QueueNullException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
