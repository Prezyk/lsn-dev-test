package task3.process.exception;

public class EdgeParseException extends Exception {
    public EdgeParseException(String message) {
        super(message);
    }

    public EdgeParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
