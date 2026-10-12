package exceptions;

public class DuplicateVehicleIdException extends RuntimeException{
    public DuplicateVehicleIdException(String message){
        super(message);
    }
}
