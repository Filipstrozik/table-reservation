package pl.strozik.tablereservation.exception;

public class TableeNotFoundException extends RuntimeException {
    public TableeNotFoundException(String message){
        super(message);
    }
}

