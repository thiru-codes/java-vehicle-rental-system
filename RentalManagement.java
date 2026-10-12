import exceptions.*;

public class RentalManagement {

    private VehicleRecords VehicleRecords = new VehicleRecords();

    // ==== ADD VEHICLE ====    
    public void addVehicle(int vehicleId, String vehicleName, String vehicleType, double rentalPricePerDay){
        VehicleRecords.checkDuplicateVehicleID(vehicleId);
        if(vehicleId<=0){
            throw new InvalidVehicleIdException("Error! Vehicle ID must be greater than 0");
        } 
        if(vehicleName == "" || vehicleName.isEmpty()){
            throw new InvalidVehicleNameException("Error! Vehicle Name must not be empty");
        } 
        if((!"CAR".equals(vehicleType)) && (!"BIKE".equals(vehicleType)) && (!"VAN".equals(vehicleType))){
            throw new InvalidVehicleTypeException("Error! Vehicle type must be Car, Bike or Van");
        }
        if(rentalPricePerDay<=0){
            throw new InvalidRentalPriceException("Error! Vehicle Rental Price must be greater than 0");
        }
        Vehicle newVehicle = new Vehicle(vehicleId, vehicleName, vehicleType,rentalPricePerDay);
        VehicleRecords.addVehicle(newVehicle);
        VehicleRecords.availableVehicleCount++;
    }

    // ==== VIEW ALL VEHICLES ====    
    public void viewAllVehicles(){
        VehicleRecords.viewAllVehicles();
    }

    // ==== SEARCH VEHICLE ====    
    public void searchVehicle(int vehicleId){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        System.out.println("Vehicle ID           : " + vehicle.getId());
        System.out.println("Name                 : " + vehicle.getName());
        System.out.println("Type                 : " + vehicle.getType());
        System.out.println("Rental Price Per Day : " + vehicle.getRentalPPD());
        System.out.println("Rental Status        : " + vehicle.getRentalStatus());
        System.out.println("Number of Rental Days: "+ vehicle.getNumberOfRentalDays());
        System.out.println();
    }

    // ==== RENT VEHICLE ====    
    public void rentVehicle(int vehicleId, int numberOfRentalDays){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        if(vehicle.getRentalStatus() == VehicleStatus.RENTED){
            throw new VehicleNotAvailableException("Cannot rent, Vehicle not available.");
        }
        if(numberOfRentalDays<=0){
            throw new InvalidRentalDaysException("Error! Number of rental days must be greater than 0");
        }
        vehicle.setRentalStatus(VehicleStatus.RENTED);
        vehicle.setRentalDays(numberOfRentalDays);
        VehicleRecords.availableVehicleCount--;
    }

    // ==== RETURN VEHICLE ====    
    public void returnVehicle(int vehicleId){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        if(vehicle.getRentalStatus() == VehicleStatus.AVAILABLE){
            throw new VehicleNotRentedException("Vehicle not rented, cannot return it.");
        }
        calculateRentalAmount(vehicleId);
        vehicle.setRentalStatus(VehicleStatus.AVAILABLE);
        vehicle.setRentalDays(0);
        VehicleRecords.availableVehicleCount++;
    }

    // ==== UPDATE VEHICLE ====    
    public void updateVehicle(String vehicleName, int vehicleId){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        if(vehicleName == "" || vehicleName.isEmpty()){
            throw new InvalidVehicleNameException("Error! Vehicle Name must not be empty");
        } 
        vehicle.setVehicleName(vehicleName);
    }
    public void updateVehicle(int vehicleId, String vehicleType){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        if(vehicleType != "CAR" && vehicleType != "BIKE" && vehicleType != "VAN"){
            throw new InvalidVehicleTypeException("Error! Vehicle type must be Car, Bike or Van");
        } 
        vehicle.setVehicleType(vehicleType);
    }
    public void updateVehicle(int vehicleId, double rentalPricePerDay){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        // if status is rented throw exception
        if(vehicle.getRentalStatus() == VehicleStatus.RENTED){
            throw new VehicleNotAvailableException("Error! Rental Price of a currently rented vehicle cannot be updated.");
        }
        if(rentalPricePerDay<=0){
            throw new InvalidRentalPriceException("Error! Vehicle Rental Price must be greater than 0");
        }
        vehicle.setRentalPricePerDay(rentalPricePerDay);
    }


    // ==== DELETE VEHICLE ====    
    public void deleteVehicle(int vehicleId){
        VehicleRecords.deleteVehicle(vehicleId);
    }

    // ==== CALCULATE RENTAL AMOUNT ====    
    public void calculateRentalAmount(int vehicleId){
        Vehicle vehicle = VehicleRecords.searchVehicle(vehicleId);
        int rentalDays = vehicle.getNumberOfRentalDays();
        double rentalAmount = vehicle.getRentalPPD() * rentalDays;
        double discount;
        String discountPercentage;
        
        if(rentalDays>=1 && rentalDays<=2){
            discountPercentage = "0%";
            discount = 0;
        }
        else if(rentalDays>=3 && rentalDays<=5){
            discountPercentage = "5%";
            discount = 0.05*rentalAmount;
        }
        else if(rentalDays>=6 && rentalDays<=9){
            discountPercentage = "10%";
            discount = 0.1*rentalAmount;
        }
        else{
            discountPercentage = "15%";
            discount = 0.15*rentalAmount;
        }
        searchVehicle(vehicleId);
        System.out.println("Rental Amount               : " + rentalAmount);
        System.out.println("Discount Percentage         : " + discountPercentage);
        System.out.println("Discount                    : " + discount);
        if(discount>0){
            System.out.println("Total Amount after Discount : " + (rentalAmount-discount));
        }
    }

    // ==== DISPLAY AVAILABLE VEHICLES ====    
    public void displayAvaliableVehicles(){
        VehicleRecords.displayAvaliableVehicles();
    }

}
