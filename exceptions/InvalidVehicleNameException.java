package exceptions;

public class InvalidVehicleNameException extends RuntimeException {
    public InvalidVehicleNameException(String message){
        super(message);
    }
}
