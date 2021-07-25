package task3.process.exception;

public class ConnectionParseException extends Exception {
    private static final String MESSAGE = "Invalid string to prepare array of vertices connections.";

    public ConnectionParseException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
