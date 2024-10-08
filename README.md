﻿# Vehicle Hierarchy Project
This project is a Java implementation that encompasses a vehicle hierarchy, including their specific characteristics, interfaces, custom exceptions, and logging system with Log4j. It also includes usage examples demonstrating logger configuration, exception handling, collection operations, and reflection.

Classes
1. Vehicle
: Abstract base class for all vehicles.
Attributes:
brand: The brand of the vehicle.
model: The model of the vehicle.
year: The manufacturing year of the vehicle.
Methods:
Getters and setters for attributes.
start(): Abstract method to start the vehicle.
toString(): Method to represent the vehicle as a string.
2. Airplane
: Represents an airplane.
Attributes:
altitude: Altitude at which the airplane flies.
passengerCapacity: Passenger capacity.
fuelType: Type of fuel.
passengers: List of passengers.
Methods:
Getters and setters.
start(), takeOff(): Implements Flyable.
setFuelType(String fuelType): Throws UnsupportedFuelTypeException.
addPassenger(String passenger), removePassenger(String passenger).
3. Bus
: Represents a bus.
Attributes:
passengerCapacity: Passenger capacity.
routes: Routes of the bus.
Methods:
getPassengerCapacity(): Gets the passenger capacity.
4. Car
: Represents a car.
Attributes:
doors: Number of doors.
color: Color of the car.
fuelType: Type of fuel.
hasSunroof: Indicates if it has a sunroof.
isRoofOpen: Indicates if the roof is open.
transmissionType: Type of transmission.
Methods:
accelerate(), openRoof(), closeRoof(): Car-specific methods.
5. ElectricScooter
: Represents an electric scooter.
Attributes:
features: List of scooter features.
Methods:
processAndPrintFeatures(): Processes and prints features.
6. Helicopter
: Represents a helicopter.
Attributes:
passengerCapacity: Passenger capacity.
fuelType: Type of fuel.
maintenanceTasks: Maintenance tasks.
helicopterType: Type of helicopter.
Methods:
start(): Implements Flyable.
addMaintenanceTask(), removeMaintenanceTask(): Manages maintenance tasks.
7. Motorcycle
: Represents a motorcycle.
Attributes:
accessories: Accessories of the motorcycle.
Methods:
getAccessories(), setAccessories(): Motorcycle-specific methods.
8. Boat
: Represents a boat.
Attributes:
boatType: Type of boat.
hasNavigationSystem: Indicates if it has a navigation system.
Methods:
getBoatType(): Gets the boat type.
9. Bicycle
: Represents a bicycle.
Attributes:
hasGear: Indicates if it has gears.
numberOfGears: Number of gears.
Methods:
pedal(), brake(): Methods from the Pedalable interface.
10. Truck
: Represents a truck.
Attributes:
cargo: Current cargo of the truck.
Methods:
getLoadCapacity(): Gets the load capacity.

Interfaces
1. Convertible
Methods:
openRoof()
closeRoof()
Implemented by: Car (for convertible cars).
2. Electric
Methods:
chargeBattery()
Implemented by: ElectricScooter.
3. Flyable
Methods:
takeOff()
Implemented by: Airplane, Helicopter.
4. Pedalable
Methods:
pedal()
brake()
Implemented by: Bicycle.
5. Transportable
Methods:
loadCargo()
unloadCargo()
Implemented by: Truck.

Exceptions
1. ExceedingMaxSpeedException
Usage: Thrown when the speed exceeds the limit in the VehicleSpeed class. 
2. ExceedingPassengerCapacityException
Usage: Thrown when exceeding passenger capacity in the bus.
3. InvalidYearException
Usage: Thrown when the manufacturing year is invalid.
4. NegativeAttributeException
Usage: Thrown when negative attributes are found in any class that uses them.
5. UnsupportedFuelTypeException
Usage: Thrown when the fuel type is unsupported in the Airplane class.

Enum 
BoatType.
FuelType.
HelicopterType
TransmissionType.
VehicleSpeed.

Lambda Functions
Supplier: Provides the model of the airplane.
Predicate: Checks if the bus has a high capacity.
Consumer: Prints helicopter details.
BiFunction: Calculates total truck weight and vehicle age.
Function: Provides vehicle descriptions.

Collection Streaming
processAndPrintFeatures on class ElectricScooter.
printPassengersInUpperCase on class Airplane.
processBicycles on class Bicycle.
processAndPrintPetrolCars on class Car.
processAndPrintBoats on class Boat.

Reflection
Class: Handles reflection operations, including creating instances of classes and invoking methods dynamically.

Key Methods
createInstance(Class<?> clazz, Object... args)
Description: Creates a new instance of the specified class using reflection.
Parameters:
myClass: The class type to instantiate.
args: Constructor parameters for the class.
Returns: An instance of the specified class, or null if instantiation fails.
invokeMethod(Object instance, String methodName, Object... args)

Description: Invokes a method on a given object instance using reflection.
Parameters:
instance: The object on which to invoke the method.
methodName: The name of the method to invoke.
args: Parameters for the method.


