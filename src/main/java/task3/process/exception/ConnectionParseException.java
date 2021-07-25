package task3.process.exception;

public class ConnectionParseException extends Exception {
    public ConnectionParseException(String message) {
        super(message);
    }

    public ConnectionParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
