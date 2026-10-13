# Problem Statement: Vehicle Rental Management System

## Objective

Develop a console-based Vehicle Rental Management System using Java. The application should allow a rental company to manage its vehicles and perform basic rental operations.

## Vehicle Information

The system should maintain the following information for each vehicle:

- Vehicle ID
- Vehicle Name
- Vehicle Type
- Rental Price Per Day
- Number of Rental Days
- Rental Status

### Vehicle Types

The system should support the following vehicle types:

- Car
- Bike
- Van

### Rental Status

A vehicle can have one of the following statuses:

- Available
- Rented

## Functional Requirements

The application should continuously display the following menu until the user chooses to exit:

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

### 1. Add Vehicle

Allow the user to add a new vehicle by entering its ID, name, type, and rental price per day.

**Validation rules:**

- Vehicle ID must be unique and greater than 0.
- Vehicle name must not be empty.
- Vehicle type must be Car, Bike, or Van.
- Rental price per day must be greater than 0.
- Newly added vehicles must have the status `Available`.

### 2. View All Vehicles

Display all registered vehicles. If no vehicles are registered, display an appropriate message.

### 3. Search Vehicle

Allow the user to search for a vehicle using its ID.

- If the vehicle exists, display its complete details.
- If the vehicle does not exist, display `Vehicle not found`.

### 4. Rent Vehicle

Allow the user to rent a vehicle by entering its ID and the number of rental days.

Before renting, check that:

- The vehicle exists.
- The vehicle is currently `Available`.
- The number of rental days is greater than 0.

If all conditions are satisfied, change the vehicle status to `Rented` and store the number of rental days.

### 5. Return Vehicle

Allow the user to return a rented vehicle by entering its ID.

Before returning, check that:

- The vehicle exists.
- The vehicle is currently `Rented`.

If the conditions are satisfied:

- Change the vehicle status to `Available`.
- Calculate and display the rental amount.
- Reset the rental days to 0.

### 6. Update Vehicle

Allow the user to update an existing vehicle using its ID.

The following details can be updated:

- Vehicle Name
- Vehicle Type
- Rental Price Per Day

The vehicle ID must not be changed. A rented vehicle's rental price must not be updated. Display an appropriate message if an update is not allowed.

### 7. Delete Vehicle

Allow the user to delete a vehicle using its ID.

Before deleting, check that:

- The vehicle exists.
- The vehicle is currently `Available`.

Rented vehicles must not be deleted. If the vehicle is available, remove it from the array.

### 8. Calculate Rental Amount

Allow the user to calculate the rental amount using the vehicle ID.

Apply a discount based on the number of rental days:

| Rental Days | Discount |
|---|---:|
| 1–2 days | 0% |
| 3–5 days | 5% |
| 6–9 days | 10% |
| 10 or more days | 15% |

The rental amount should be calculated using the daily rental price, rental duration, and applicable discount.

### 9. Display Available Vehicles

Display only vehicles whose status is `Available`. Rented vehicles must not be displayed.

### 10. Exit

Exit the application.
