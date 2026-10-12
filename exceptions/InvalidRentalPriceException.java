package exceptions;

public class InvalidRentalPriceException extends RuntimeException{
    public InvalidRentalPriceException(String message){
        super(message);
    }
}
