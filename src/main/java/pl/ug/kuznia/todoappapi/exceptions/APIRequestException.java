package pl.ug.kuznia.todoappapi.exceptions;

public class APIRequestException extends RuntimeException {
    public APIRequestException(String message) {
        super(message);
    }


}
