package exceptions;

public class VehicleNotRentedException extends RuntimeException{
    public VehicleNotRentedException(String message){
        super(message);
    }
}
