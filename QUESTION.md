Develop a console-based Vehicle Rental Management System using Java
=======================================================================

The application should allow a rental company to manage its vehicles and perform basic rental operations.

The system should maintain the following information for each vehicle:

Vehicle ID
Vehicle Name
Vehicle Type
Rental Price Per Day
Number of Rental Days
Rental Status

Vehicle Type:
-------------
The system should support the following vehicle types:(Car,Bike,Van)

Rental Status:
--------------
A vehicle can have one of the following statuses:(Available, Rented)

Menu Options:
-------------
The application should continuously display the following menu:
1. Add Vehicle 
2. View All Vehicles 
3. Search Vehicle 
4. Rent Vehicle 
5. Return Vehicle 
6. Update Vehicle 
7. Delete Vehicle 
8. Calculate Rental Amount 
9. Display Available Vehicles 
10. Exit

1. Add Vehicle:
Allow the user to add a new vehicle.
The following details should be entered:
Vehicle ID
Vehicle Name
Vehicle Type
Rental Price Per Day

When a vehicle is added:
Vehicle ID must be unique.
Vehicle ID must be greater than 0.
Vehicle name must not be empty.
Vehicle type must be Car, Bike, or Van.
Rental price must be greater than 0.
Newly added vehicles should have the status Available.

2. View All Vehicles
Display all registered vehicles.
If no vehicles are registered, display an appropriate message.

3. Search Vehicle
Allow the user to search for a vehicle using the Vehicle ID.
If the vehicle exists, display its complete details.
If the vehicle does not exist, display: Vehicle not found.

4. Rent Vehicle
Allow the user to rent a vehicle.
The user should enter:
Vehicle ID
Number of rental days

Before renting, check:
Whether the Vehicle ID exists.
Whether the vehicle is currently Available.
Whether the number of rental days is greater than 0.

If all conditions are satisfied:
Change the vehicle status to Rented.
Store the number of rental days.

5. Return Vehicles
Allow the user to return a rented vehicle.
The user should enter the Vehicle ID.

Check whether:
The vehicle exists.
The vehicle is currently Rented.

If the vehicle is rented:
Change the status to Available.
Calculate and display the rental amount.
Reset the rental days.

6. Update Vehicle
Allow the user to update an existing vehicle using the Vehicle ID.
The following details can be updated:

Vehicle Name
Vehicle Type
Rental Price Per Day

The Vehicle ID should not be changed.
A vehicle that is currently Rented should not be allowed to update its rental price.
Display an appropriate message when an update is not allowed.

7. Delete Vehicle
Allow the user to delete a vehicle using the Vehicle ID.
Before deleting, check:
Whether the vehicle exists.
Whether the vehicle is Available.
A rented vehicle should not be deleted.
If the vehicle is available, remove it from the array.

8. Calculate Rental Amount
Allow the user to calculate the rental amount using the Vehicle ID.
Apply an additional discount based on the number of rental days.
Discount Rules
Rental Days    Discount
1–2 days    No discount
3–5 days    5%
6–9 days    10%
10 or more days    15%

9. Display Available Vehicles
Display only vehicles whose status is: Available
Do not display rented vehicles.

10. Exit
Exit the application.