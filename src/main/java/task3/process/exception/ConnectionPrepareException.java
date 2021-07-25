package task3.process.exception;

public class ConnectionPrepareException extends Exception {
    private static final String MESSAGE = "Invalid string to prepare array of vertices connections.";

    public ConnectionPrepareException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
