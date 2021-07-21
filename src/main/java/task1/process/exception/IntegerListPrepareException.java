package task1.process.exception;

public class IntegerListPrepareException extends Exception{
    private static final String MESSAGE = "Invalid string to prepare list of integers.";

    public IntegerListPrepareException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
