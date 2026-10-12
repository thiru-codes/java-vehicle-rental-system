import exceptions.DuplicateVehicleIdException;
import exceptions.VehicleNotAvailableException;
import exceptions.VehicleNotFoundException;

public class VehicleRecords {
    private Vehicle[] vehicles = new Vehicle[100];
    private static int vehicleCount = 0;
    int availableVehicleCount = 0;

    // ==== ADD VEHICLE TO RECORDS ====
    public void addVehicle(Vehicle vehicle){
        vehicles[vehicleCount++] = vehicle;
    }
    
    // ==== VIEW ALL VEHICLES ====
    public void viewAllVehicles(){
        System.out.println("--- Vehicle Records ---");
        System.out.println("No. of vehicle registered : " + vehicleCount);
        System.out.println();

        if(vehicleCount>0){
            for(int i=0;i<vehicleCount;i++){
                System.out.println("Vehicle ID           : " + vehicles[i].getId());
                System.out.println("Name                 : " + vehicles[i].getName());
                System.out.println("Type                 : " + vehicles[i].getType());
                System.out.println("Rental Price Per Day : " + vehicles[i].getRentalPPD());
                System.out.println("Rental Status        : " + vehicles[i].getRentalStatus());
                System.out.println("Number of Rental Days: " + vehicles[i].getNumberOfRentalDays());
                System.out.println();
            }
        }
    }

    // ==== DISPLAY ALL AVAILABLE VEHICLES ====
    public void displayAvaliableVehicles(){
        System.out.println("- Available Vehicle Records -");
        System.out.println("No. of vehicles available : " + availableVehicleCount);
        System.out.println();

        if(vehicleCount>0 && availableVehicleCount>0){
            for(int i=0;i<vehicleCount;i++){
                if(vehicles[i].getRentalStatus() == VehicleStatus.AVAILABLE){
                    System.out.println("Vehicle ID           : " + vehicles[i].getId());
                    System.out.println("Name                 : " + vehicles[i].getName());
                    System.out.println("Type                 : " + vehicles[i].getType());
                    System.out.println("Rental Price Per Day : " + vehicles[i].getRentalPPD());
                    System.out.println("Rental Status        : " + vehicles[i].getRentalStatus());
                    System.out.println("Number of Rental Days: "+ vehicles[i].getNumberOfRentalDays());
                    System.out.println();
                }
            }
        }
    }

    // ==== SEARCH VEHICLE ====
    public Vehicle searchVehicle(int vehicleId){
        for(int i=0;i<vehicleCount;i++){
            if(vehicles[i].getId() == vehicleId){
                return vehicles[i];
            }
        }
        throw new VehicleNotFoundException("Error! Vehicle not found for given Id");
    }

    // ==== DELETE VEHICLE ===
    public void deleteVehicle(int vehicleId){
        for(int i=0;i<vehicleCount;i++){
            if(vehicles[i].getId() == vehicleId){
                if(vehicles[i].getRentalStatus() == VehicleStatus.RENTED){
                    throw new VehicleNotAvailableException("Error! Vehicle not available.\nCannot delete vehicle from system.");
                }
                vehicles[i] = null;
                for(int j=i+1;j<vehicleCount;j++){
                    Vehicle temp = vehicles[i];
                    vehicles[i] = vehicles[j];
                    vehicles[j] = temp;
                }
                vehicleCount--;
                return;
            }
        }
        throw new VehicleNotFoundException("Error! Vehicle not found for given Id");
    }


    // ====  CHECK DUPLICATE VEHICLE ID ====
    public void checkDuplicateVehicleID(int vehicleId){
        if(vehicleCount>0){
            for(int i=0;i<vehicleCount;i++){
                if(vehicles[i].getId() == vehicleId){
                    throw new DuplicateVehicleIdException("Error! Vehicle ID already exists");
                }
            }
        }
    }
}
