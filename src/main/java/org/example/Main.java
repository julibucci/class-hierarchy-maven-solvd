package org.example;

import org.example.enums.FuelType;
import org.example.enums.TransmissionType;
import org.example.enums.BoatType;
import org.example.enums.HelicopterType;
import org.example.classes.*;
import org.example.exceptions.InvalidYearException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.*;

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
            // Configuración enums
            TransmissionType carTransmission = TransmissionType.AUTOMATIC;
            FuelType truckFuelType = FuelType.DIESEL;
            HelicopterType helicopterType = HelicopterType.COMMERCIAL;

            CustomLinkedList<String> airplanePassengers = new CustomLinkedList<>();
            airplanePassengers.add("John Doe");
            airplanePassengers.add("Jane Smith");
            airplane = new Airplane("Boeing", "747", 2022, 35000, 900, "Jet Fuel", airplanePassengers);

            // Supplier<String> --> Proporciona el modelo del avión
            Vehicle finalAirplane = airplane;
            Supplier<String> airplaneModelSupplier = () -> finalAirplane.getModel();
            logger.info("Airplane model: " + airplaneModelSupplier.get());

            CustomLinkedList<String> busRoutes = new CustomLinkedList<>();
            busRoutes.add("Route 1");
            busRoutes.add("Route 2");
            bus = new Bus("Volvo", "B11R", 2021, 50, 2, "Diesel", busRoutes, 100);

            // Predicate<Vehicle> --> Evalúa si el bus tiene una capacidad mayor a 40 pasajeros
            Predicate<Vehicle> busCapacityCheck = v -> ((Bus) v).getPassengerCapacity() > 40;
            logger.info("Bus has high capacity: " + busCapacityCheck.test(bus));

            Queue<String> helicopterMaintenanceTasks = new LinkedList<>();
            helicopterMaintenanceTasks.add("Check rotor blades");
            helicopterMaintenanceTasks.add("Change oil");

            helicopter = new Helicopter("Bell", "407", 2019, 6, "Aviation Gasoline", helicopterMaintenanceTasks, helicopterType);

            // Consumer<Vehicle> --> Imprime los detalles del helicóptero
            Consumer<Vehicle> printHelicopterDetails = h -> logger.info(h.toString());
            printHelicopterDetails.accept(helicopter);

            HashMap<String, Integer> initialCargo = new HashMap<>();
            initialCargo.put("Electronics", 500);
            initialCargo.put("Furniture", 200);
            truck = new Truck("Scania", "R450", 2020, 10000, 2, truckFuelType, initialCargo);

            // BiFunction<Integer, Integer, Integer>--> Calcula el peso total del camión y su carga
            BiFunction<Integer, Integer, Integer> calculateTotalWeight = (truckWeight, cargoWeight) -> truckWeight + cargoWeight;
            logger.info("Total truck weight: " + calculateTotalWeight.apply(10000, 500));

            // Creación de una motocicleta con el enum VehicleSpeed
            ArrayList<String> initialAccessories = new ArrayList<>();
            initialAccessories.add("Saddlebags");
            initialAccessories.add("GPS");
            motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2018, 750, "Cruiser", true, "Black", true, initialAccessories, 120);

            // Function<Vehicle, String> --> Devuelve una descripción del vehículo
            Function<Vehicle, String> getVehicleDescription = v -> "Vehicle: " + v.getBrand() + " " + v.getModel() + " (" + v.getYear() + ")";
            logger.info(getVehicleDescription.apply(motorcycle));

            // Creación de un barco con el enum BoatType
            BoatType boatType = BoatType.SAILBOAT;
            Boat boat = new Boat("Beneteau", "Oceanis", 2020, 30, 10, 6, "Diesel", true, boatType);
            logger.info("Boat type: " + boat.getBoatType().getName());
            logger.info("Can the boat accommodate 5 passengers? " + boat.getBoatType().canAccommodate(5));

            // Car con TransmissionType
            Car car = new Car("Toyota", "Corolla", 2021, 4, "Blue", "Diesel", true, false, 180, TransmissionType.AUTOMATIC);
            car.setMaxSpeed(180);
            logger.info("Transmission Type of the Car: " + car.getTransmissionDescription());

            // Guardar detalles de vehículos en archivos
            fileManager.saveVehicleDetails(airplane, "airplane_details.txt");
            fileManager.saveVehicleDetails(bus, "bus_details.txt");
            fileManager.saveVehicleDetails(helicopter, "helicopter_details.txt");
            fileManager.saveVehicleDetails(truck, "truck_details.txt");
            fileManager.saveVehicleDetails(motorcycle, "motorcycle_details.txt");
            fileManager.saveVehicleDetails(boat, "boat_details.txt");

            // Contar palabras únicas en los archivos de detalles de vehículos
            wordCount.countUniqueWordsInFile("airplane_details.txt", "airplane_details_word_count.txt");
            wordCount.countUniqueWordsInFile("bus_details.txt", "bus_details_word_count.txt");
            wordCount.countUniqueWordsInFile("helicopter_details.txt", "helicopter_details_word_count.txt");
            wordCount.countUniqueWordsInFile("truck_details.txt", "truck_details_word_count.txt");
            wordCount.countUniqueWordsInFile("motorcycle_details.txt", "motorcycle_details_word_count.txt");
            wordCount.countUniqueWordsInFile("boat_details.txt", "boat_details_word_count.txt");

            // Cargar detalles de vehículos desde archivos
            fileManager.loadVehicleDetails("airplane_details.txt");
            fileManager.loadVehicleDetails("bus_details.txt");
            fileManager.loadVehicleDetails("helicopter_details.txt");
            fileManager.loadVehicleDetails("truck_details.txt");
            fileManager.loadVehicleDetails("motorcycle_details.txt");
            fileManager.loadVehicleDetails("boat_details.txt");

        } catch (InvalidYearException e) {
            logger.error("An error occurred while creating a vehicle: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            logger.warn("A runtime error occurred: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage(), e);
        }
    }
}
