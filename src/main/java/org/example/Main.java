package org.example;

import org.example.enums.FuelType;
import org.example.enums.TransmissionType;
import org.example.enums.BoatType;
import org.example.enums.HelicopterType;
import org.example.classes.*;
import org.example.exceptions.InvalidYearException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.io.File;
import java.util.*;
import java.util.function.*;
import org.example.interfaces.Electric;

public class Main {
    public static Logger logger;

    public static void main(String[] args) {
        // Configuration of logger
        File log4j2File = new File("C:\\Users\\julie\\OneDrive\\Escritorio\\Exercises - Solvd\\class hierarchy- solvd\\src\\resources\\log4j2.properties");
        System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());
        logger = LogManager.getLogger(Main.class);

        Vehicle airplane = null;
        Vehicle bus = null;
        Vehicle helicopter = null;
        Vehicle truck = null;
        Vehicle motorcycle = null;

        VehicleFileManager fileManager = new VehicleFileManager();
        WordCount wordCount = new WordCount();

        try {
            // Configuration of the enums
            TransmissionType carTransmission = TransmissionType.AUTOMATIC;
            FuelType truckFuelType = FuelType.DIESEL;
            HelicopterType helicopterType = HelicopterType.COMMERCIAL;

            HashSet<String> airplanePassengers = new HashSet<>();
            airplanePassengers.add("John Doe");
            airplanePassengers.add("Jane Smith");
            airplane = new Airplane("Boeing", "747", 2022, 35000, 900, "Jet Fuel", airplanePassengers);

            // Supplier<String> --> Provides the model of the airplane
            Vehicle finalAirplane = airplane;
            Supplier<String> airplaneModelSupplier = () -> finalAirplane.getModel();
            logger.info("Airplane model: " + airplaneModelSupplier.get());

            CustomLinkedList<String> busRoutes = new CustomLinkedList<>();
            busRoutes.add("Route 1");
            busRoutes.add("Route 2");
            bus = new Bus("Volvo", "B11R", 2021, 50, 2, "Diesel", busRoutes, 100);

            // Predicate<Vehicle> --> Evaluate if the bus has a capacity greater than 40 passengers
            Predicate<Vehicle> busCapacityCheck = v -> ((Bus) v).getPassengerCapacity() > 40;
            logger.info("Bus has high capacity: " + busCapacityCheck.test(bus));

            Queue<String> helicopterMaintenanceTasks = new LinkedList<>();
            helicopterMaintenanceTasks.add("Check rotor blades");
            helicopterMaintenanceTasks.add("Change oil");

            helicopter = new Helicopter("Bell", "407", 2019, 6, "Aviation Gasoline", helicopterMaintenanceTasks, helicopterType);

            // Consumer<Vehicle> --> Print helicopter details
            Consumer<Vehicle> printHelicopterDetails = h -> logger.info(h.toString());
            printHelicopterDetails.accept(helicopter);

            HashMap<String, Integer> initialCargo = new HashMap<>();
            initialCargo.put("Electronics", 500);
            initialCargo.put("Furniture", 200);
            truck = new Truck("Scania", "R450", 2020, 10000, 2, truckFuelType, initialCargo);

            // BiFunction<Integer, Integer, Integer>--> Calculate the total weight of the truck and its load
            BiFunction<Integer, Integer, Integer> calculateTotalWeight = (truckWeight, cargoWeight) -> truckWeight + cargoWeight;
            logger.info("Total truck weight: " + calculateTotalWeight.apply(10000, 500));

            // Creating a motorcycle with the VehicleSpeed enum
            ArrayList<String> initialAccessories = new ArrayList<>();
            initialAccessories.add("Saddlebags");
            initialAccessories.add("GPS");
            motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2018, 750, "Cruiser", true, "Black", true, initialAccessories, 120);

            // Function<Vehicle, String> --> Returns a description of the vehicle
            Function<Vehicle, String> getVehicleDescription = v -> "Vehicle: " + v.getBrand() + " " + v.getModel() + " (" + v.getYear() + ")";
            logger.info(getVehicleDescription.apply(motorcycle));

            // Creacion de los lambda functions con generics
            logger.info("===== Lambda functions con generics =====");
            // Function<Vehicle, String> --> Convert vehicle to description
            Function<Vehicle, String> vehicleToDescription = vehicle ->
                    "Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getYear() + ")";
            logger.info(vehicleToDescription.apply(motorcycle));

            // Predicate<Vehicle> --> Check if the vehicle is electric
            Predicate<Vehicle> isElectric = vehicle -> vehicle instanceof Electric;
            logger.info("Is the motorcycle electric? " + isElectric.test(motorcycle));

            // BiFunction<Integer, Vehicle, Integer> --> Calculate vehicle age
            BiFunction<Integer, Vehicle, Integer> calculateVehicleAge = (currentYear, vehicle) ->
                    currentYear - vehicle.getYear();
            logger.info("Age of the motorcycle: " + calculateVehicleAge.apply(2024, motorcycle));

            // Creating a boat with the BoatType enum
            BoatType boatType = BoatType.SAILBOAT;
            Boat boat = new Boat("Beneteau", "Oceanis", 2020, 30, 10, 6, "Diesel", true, boatType);
            logger.info("Boat type: " + boat.getBoatType().getName());

            // Car with TransmissionType
            Car car = new Car("Toyota", "Corolla", 2021, 4, "Blue", "Diesel", true, false, 180, TransmissionType.AUTOMATIC);
            car.setMaxSpeed(180);
            logger.info("Transmission Type of the Car: " + car.getTransmissionDescription());

            // Save vehicle details to files
            fileManager.saveVehicleDetails(airplane, "airplane_details.txt");
            fileManager.saveVehicleDetails(bus, "bus_details.txt");
            fileManager.saveVehicleDetails(helicopter, "helicopter_details.txt");
            fileManager.saveVehicleDetails(truck, "truck_details.txt");
            fileManager.saveVehicleDetails(motorcycle, "motorcycle_details.txt");
            fileManager.saveVehicleDetails(boat, "boat_details.txt");

            // Count unique words in vehicle detail files
            wordCount.countUniqueWordsInFile("airplane_details.txt", "airplane_details_word_count.txt");
            wordCount.countUniqueWordsInFile("bus_details.txt", "bus_details_word_count.txt");
            wordCount.countUniqueWordsInFile("helicopter_details.txt", "helicopter_details_word_count.txt");
            wordCount.countUniqueWordsInFile("truck_details.txt", "truck_details_word_count.txt");
            wordCount.countUniqueWordsInFile("motorcycle_details.txt", "motorcycle_details_word_count.txt");
            wordCount.countUniqueWordsInFile("boat_details.txt", "boat_details_word_count.txt");

            // Load vehicle details from files
            fileManager.loadVehicleDetails("airplane_details.txt");
            fileManager.loadVehicleDetails("bus_details.txt");
            fileManager.loadVehicleDetails("helicopter_details.txt");
            fileManager.loadVehicleDetails("truck_details.txt");
            fileManager.loadVehicleDetails("motorcycle_details.txt");
            fileManager.loadVehicleDetails("boat_details.txt");

            // Collection streaming
            logger.info("===== Collection streaming =====");
            HashSet<String> airplanePassengerSet = new HashSet<>();
            airplanePassengerSet.add("Taylor Swift");
            airplanePassengerSet.add("Olivia Rodrigo");
            airplanePassengerSet.add("Brad Pitt");

            Airplane airplane1 = new Airplane("Boeing", "747", 2022, 35000, 900, "Jet Fuel", airplanePassengerSet);

            //1. Llamar al metodo para imprimir los pasajeros en mayusculas
            airplane1.printPassengersInUpperCase(); // Casting necesario

            //2. Filter and collect high capacity trucks (Terminal operation)
            List<Truck> trucks = Arrays.asList(
                    new Truck("Volvo", "FH", 2019, 12000, 3, FuelType.DIESEL, new HashMap<>()),
                    new Truck("Mercedes", "Actros", 2021, 15000, 2, FuelType.DIESEL, new HashMap<>())
            );

            List<Truck> highCapacityTrucks = trucks.stream()
                    .filter(t -> t.getLoadCapacity() > 10000) // Intermediate operation
                    .collect(Collectors.toList()); // Terminal operation
            highCapacityTrucks.forEach(t -> logger.info("High capacity truck: " + t.getModel()));

            // 3. Find average passenger capacity of buses (Terminal operation)
            List<Bus> buses = Arrays.asList(
                    new Bus("Mercedes", "Citaro", 2020, 60, 2, "Diesel", new CustomLinkedList<>(), 100),
                    new Bus("Volvo", "7700", 2021, 70, 3, "Diesel", new CustomLinkedList<>(), 120)
            );

            double averageBusCapacity = buses.stream()
                    .mapToInt(Bus::getPassengerCapacity) // Intermediate operation
                    .average() // Terminal operation
                    .orElse(0);
            logger.info("Average bus passenger capacity: " + averageBusCapacity);

            //4.
            List<Bicycle> bicycles = Arrays.asList(
                    new Bicycle("Giant", "Defy", 2021, true, 11, "Road", true, "Aluminum"),
                    new Bicycle("Trek", "Marlin", 2022, true, 18, "Mountain", true, "Carbon"),
                    new Bicycle("Specialized", "Sirrus", 2020, false, 8, "Hybrid", false, "Steel")
            );

            Bicycle.processBicycles(bicycles);

            //5.
            List<String> features = Arrays.asList("LED Headlight", "Bluetooth Connectivity", "LED Taillight");
            ElectricScooter scooter = new ElectricScooter("Xiaomi", "M365", 2023, 45, 25, 50, true, true, features);
            scooter.processAndPrintFeatures();

            //6.
            List<Boat> boats = Arrays.asList(
                    new Boat("Beneteau", "Oceanis", 2020, 30, 8, 6, "Diesel", true, BoatType.SAILBOAT),
                    new Boat("Jeanneau", "Sun Odyssey", 2021, 33, 6, 6, "Gasoline", true, BoatType.SAILBOAT),
                    new Boat("Sea Ray", "SLX 400", 2022, 40, 4, 8, "Diesel", false, BoatType.FISHINGBOAT)
            );
            Boat.processAndPrintBoats(boats); // Call method

            //7.
            List<Car> cars = Arrays.asList(
                    new Car("Toyota", "Corolla", 2021, 4, "Blue", "Petrol", true, false, 180, TransmissionType.AUTOMATIC),
                    new Car("Honda", "Civic", 2020, 4, "Red", "Diesel", true, true, 200, TransmissionType.MANUAL),
                    new Car("Ford", "Mustang", 2022, 2, "Black", "Petrol", true, false, 250, TransmissionType.AUTOMATIC)
            );
            Car.processAndPrintPetrolCars(cars);

            logger.info("===== Reflection Utilization =====");
            helicopterMaintenanceTasks.add("Check rotors");
            helicopterMaintenanceTasks.add("Oil change");

            Reflection.printClassInfo(Airplane.class); // Imprime información sobre la clase Airplane

            int passengerCapacity = 5;
            Queue<String> maintenanceTasks = new LinkedList<>();
            HelicopterType type = HelicopterType.COMMERCIAL;

            Object helicopterInstance = Reflection.createInstance(Helicopter.class, "Brand", "Model", 2023, passengerCapacity, "FuelType", maintenanceTasks, type);

            if (helicopterInstance != null) {
                logger.info("Created Helicopter using reflection: " + helicopterInstance);

                // Invocar el método "start" de la instancia del helicóptero usando reflexión
                Reflection.invokeMethod(helicopterInstance, "start");
            }

        } catch (InvalidYearException e) {
            logger.error("An error occurred while creating a vehicle: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            logger.warn("A runtime error occurred: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage(), e);
        }

    }
}

