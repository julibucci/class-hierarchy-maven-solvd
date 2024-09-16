# Vehicle Hierarchy Project
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

Abstract Class-
Vehicle is an abstract class because it defines a set of common attributes and methods for all vehicles, but it cannot be instantiated directly. It serves as a base for subclasses that represent specific types of vehicles such as Car, Truck, Airplane, etc.

Lambda Functions
Supplier: Provides the model of the airplane.
Predicate: Checks if the bus has a high capacity.
Consumer: Prints helicopter details.
BiFunction: Calculates total truck weight and vehicle age.
Function: Provides vehicle descriptions.

Reflection
Reflection Class: Handles reflection operations, including creating instances of classes and invoking methods dynamically.

Utility Classes
StringUtils: Contains static methods for string manipulation.
FileUtils: Contains static methods for file operations such as reading and writing.

Usage
Compile and Run: Ensure that all dependencies are included, and configure your log4j2 properties file accordingly.
Custom Linked List: The CustomLinkedList class is used in various parts of the project for custom linked list operations.
Process Data: Utilize methods from StringUtils and FileUtils for string and file manipulations.
Reflection: Use the Reflection class to handle dynamic class and method operations.
