package bg.softuni.L01LinkedOut.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}