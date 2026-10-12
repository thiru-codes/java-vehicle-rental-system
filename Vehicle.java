public class Vehicle {
    private final int vehicleId;
    private String vehicleName;
    private String vehicleType;
    private double rentalPricePerDay;
    private int numberOfRentalDays;
    private VehicleStatus rentalStatus; 

    // ==== constructor ===
    public Vehicle(int vehicleId, String vehicleName, String vehicleType, double rentalPricePerDay){
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.rentalPricePerDay = rentalPricePerDay;
        this.numberOfRentalDays = 0;
        this.rentalStatus = VehicleStatus.AVAILABLE;
    }

    // ===== getters ====
    public int getId(){
        return vehicleId;
    }
    public String getName(){
        return vehicleName;
    }
    public String getType(){
        return vehicleType;
    }
    public double getRentalPPD(){
        return rentalPricePerDay;
    }
    public int getNumberOfRentalDays(){
        return numberOfRentalDays;
    }
    public VehicleStatus getRentalStatus(){
        return rentalStatus;
    }

    // ===== setters ====
    public void setVehicleName(String vehicleName){
        this.vehicleName = vehicleName;
    }
    public void setVehicleType(String type){
        this.vehicleType = type;
    }
    public void setRentalPricePerDay(double rentalPricePerDay){
        this.rentalPricePerDay = rentalPricePerDay;
    }
    public void setRentalStatus(VehicleStatus rentalStatus){
        this.rentalStatus = rentalStatus;
    }
    public void setRentalDays(int numberOfRentalDays){
        this.numberOfRentalDays = numberOfRentalDays;
    }
}
