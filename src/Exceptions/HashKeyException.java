package Exceptions;

public class HashKeyException extends Exception{
    private final String message;

    public HashKeyException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

