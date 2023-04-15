package Exceptions;

public class HashNullException extends Exception{
    private String message;

    public HashNullException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

