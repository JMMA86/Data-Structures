package Exceptions;

public class StackNullException extends Exception{
    private String message;

    public StackNullException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
