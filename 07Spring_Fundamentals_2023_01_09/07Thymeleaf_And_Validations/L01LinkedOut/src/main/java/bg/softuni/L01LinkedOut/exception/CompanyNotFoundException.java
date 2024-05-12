package bg.softuni.L01LinkedOut.exception;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(String message) {
        super(message);
    }

    public CompanyNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}