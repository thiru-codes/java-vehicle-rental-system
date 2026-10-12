import java.util.Scanner;

import exceptions.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalManagement RentalManagement = new RentalManagement();

        boolean exit = false;

        while(!exit){
            System.out.println();
            System.out.println("------- Vehicle Rental Management System -------");
            System.out.println();

            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Rent Vehicle");
            System.out.println("5. Return Vehicle");
            System.out.println("6. Update Vehicle");
            System.out.println("7. Delete Vehicle");
            System.out.println("8. Calculate Rental Amount");
            System.out.println("9. Display Available Vehicles");
            System.out.println("10. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch(choice){
                case 1:{
                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter Vehicle Name: ");
                    String vehicleName = scanner.nextLine();
                    vehicleName = vehicleName.trim();

                    System.out.print("Enter Vehicle Type (CAR, BIKE, VAN): ");
                    String vehicleType = scanner.next();
                    vehicleType = vehicleType.trim().toUpperCase();
                    
                    System.out.print("Enter Rental Price Per Day: ");
                    int rentalPricePerDay = scanner.nextInt();
                    System.out.println();

                    try{
                        RentalManagement.addVehicle(vehicleId,vehicleName,vehicleType,rentalPricePerDay);
                        System.out.println("Vehicle " + vehicleId + " " + vehicleName + " successfully added!");
                    }
                    catch(DuplicateVehicleIdException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InvalidVehicleIdException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InvalidVehicleNameException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InvalidVehicleTypeException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InvalidRentalPriceException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2:{
                    System.out.println();
                    RentalManagement.viewAllVehicles();
                    break;
                }

                case 3:{
                    System.out.println();
                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId = scanner.nextInt();
                    System.out.println();
                    try{
                        RentalManagement.searchVehicle(vehicleId);
                    }
                    catch(VehicleNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 4:{
                    System.out.println();
                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId = scanner.nextInt();
                    System.out.print("Enter Number of Rental Days: ");
                    int numberOfRentalDays = scanner.nextInt();
                    System.out.println();
                    try{
                        RentalManagement.rentVehicle(vehicleId,numberOfRentalDays);
                        System.out.println();
                        System.out.println("Vehicle " + vehicleId + " " + " successfully rented!");
                    }
                    catch(VehicleNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    catch(VehicleNotAvailableException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InvalidRentalDaysException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 5:{
                    System.out.println();
                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId = scanner.nextInt();
                    System.out.println();
                    try{
                        RentalManagement.returnVehicle(vehicleId);
                        System.out.println();
                        System.out.println("Vehicle " + vehicleId + " " + " successfully returned!");
                    }
                    catch(VehicleNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    catch(VehicleNotRentedException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                
                case 6:{
                    System.out.print("Enter Vehicle Id: ");
                    int vehicleId = scanner.nextInt();
                    System.out.println();

                    RentalManagement.searchVehicle(vehicleId); 
                        
                    System.out.println("Select field to update:");
                    System.out.println("1. Vehicle Name");
                    System.out.println("2. Vehicle Type");
                    System.out.println("3. Rental Price per Day");
                    System.out.println();
                        
                    int ch = scanner.nextInt();
                    scanner.nextLine();
                        
                    switch(ch){
                        case 1:
                            System.out.println("Enter updated vehicle name: ");
                            String vehicleName = scanner.nextLine();
                            vehicleName = vehicleName.trim();
                            try{
                                RentalManagement.updateVehicle(vehicleName,vehicleId);
                                System.out.println("Name field successfully updated for Vehicle: " + vehicleId);
                            }
                            catch(VehicleNotFoundException e){
                                System.out.println(e.getMessage());
                            }
                            catch(InvalidVehicleNameException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Enter updated vehicle type: ");
                            String vehicleType = scanner.next();
                            vehicleName = vehicleType.trim().toUpperCase();
                            try{
                                RentalManagement.updateVehicle(vehicleId,vehicleType);
                                System.out.println("Type field successfully updated for Vehicle: " + vehicleId);
                            }
                            catch(VehicleNotFoundException e){
                                System.out.println(e.getMessage());
                            }
                            catch(InvalidVehicleTypeException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println("Enter updated rental price per day: ");
                            double rentalPricePerDay = scanner.nextDouble();
                            try{
                                RentalManagement.updateVehicle(vehicleId,rentalPricePerDay);
                                System.out.println("Rental Price Per Day field successfully updated for Vehicle: " + vehicleId);
                            }
                            catch(VehicleNotFoundException e){
                                System.out.println(e.getMessage());
                            }
                            catch(VehicleNotAvailableException e){
                                System.out.println(e.getMessage());
                            }
                            catch(InvalidRentalPriceException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Invalid choice, try again");
                            break;
                    }
                    break;
                }

                case 7:{
                    System.out.println();
                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId = scanner.nextInt();
                    System.out.println();
                    try{
                        RentalManagement.deleteVehicle(vehicleId);
                        System.out.println("Vehicle " + vehicleId + " deleted successfully!");
                    }
                    catch(VehicleNotAvailableException e){
                        System.out.println(e.getMessage());
                    }
                    catch(VehicleNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 8:{
                    System.out.println();
                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId = scanner.nextInt();
                    System.out.println();
                    try{
                        RentalManagement.calculateRentalAmount(vehicleId);
                    }
                    catch(VehicleNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 9:{
                    System.out.println();
                    RentalManagement.displayAvaliableVehicles();
                    break;
                }

                case 10:{
                    System.out.println();
                    System.out.println("Exiting Rental Management System.");
                    System.out.println();
                    exit = true;
                    break;
                }

                default:{
                    System.out.println();
                    System.out.println("Invalid choice, try again!");
                    break;
                }
            }
        }
        scanner.close();
    }
}