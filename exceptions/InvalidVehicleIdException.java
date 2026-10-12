package exceptions;

public class InvalidVehicleIdException extends RuntimeException{
    public InvalidVehicleIdException(String message){
        super(message);
    }
}
