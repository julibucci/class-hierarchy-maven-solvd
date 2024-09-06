package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.example.classes.*;
import org.example.exceptions.InvalidYearException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import java.io.File;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Logger logger;
    public static void main(String[] args) {

        // Configuracion del logger
        File log4j2File = new File("C:\\Users\\julie\\OneDrive\\Escritorio\\Exercises - Solvd\\class hierarchy- solvd\\src\\resources\\log4j2.properties");
        System.setProperty("log4j2.configurationFile", log4j2File.toURI().toString());
        logger = LogManager.getLogger(Main.class);

        Vehicle airplane = null;
        Vehicle bus = null;
        Vehicle helicopter = null;
        Vehicle truck = null;
        Vehicle motorcycle = null;

        VehicleFileManager fileManager = new VehicleFileManager();
        WordCount wordCount = new WordCount();  // Instancia de WordCount

        try {
            CustomLinkedList<String> airplanePassengers = new CustomLinkedList<>();
            airplanePassengers.add("John Doe");
            airplanePassengers.add("Jane Smith");
            airplane = new Airplane("Boeing", "747", 2022, 35000, 900, "Jet Fuel", airplanePassengers);

            CustomLinkedList<String> busRoutes = new CustomLinkedList<>();
            busRoutes.add("Route 1");
            busRoutes.add("Route 2");
            bus = new Bus("Volvo", "B11R", 2021, 50, 2, "Diesel", busRoutes);

            LinkedList<String> helicopterMaintenanceTasks = new LinkedList<>();
            helicopterMaintenanceTasks.add("Check rotor blades");
            helicopterMaintenanceTasks.add("Change oil");

            helicopter = new Helicopter("Bell", "407", 2019, 1000, 6, 15000, "Aviation Gasoline", false, helicopterMaintenanceTasks);

            HashMap<String, Integer> initialCargo = new HashMap<>();
            initialCargo.put("Electronics", 500);
            initialCargo.put("Furniture", 200);
            truck = new Truck("Scania", "R450", 2020, 10000, 4, true, "Diesel", 2, initialCargo);

            ArrayList<String> initialAccessories = new ArrayList<>();
            initialAccessories.add("Saddlebags");
            initialAccessories.add("GPS");
            motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2018, 750, "Cruiser", true, "Black", true, initialAccessories);

            // Guardar detalles de vehiculos en archivos
            fileManager.saveVehicleDetails(airplane, "airplane_details.txt");
            fileManager.saveVehicleDetails(bus, "bus_details.txt");
            fileManager.saveVehicleDetails(helicopter, "helicopter_details.txt");
            fileManager.saveVehicleDetails(truck, "truck_details.txt");
            fileManager.saveVehicleDetails(motorcycle, "motorcycle_details.txt");

            // Contar palabras en los archivos de detalles de vehículos
            wordCount.countUniqueWordsInFile("airplane_details.txt", "airplane_details_word_count.txt");
            wordCount.countUniqueWordsInFile("bus_details.txt", "bus_details_word_count.txt");
            wordCount.countUniqueWordsInFile("helicopter_details.txt", "helicopter_details_word_count.txt");
            wordCount.countUniqueWordsInFile("truck_details.txt", "truck_details_word_count.txt");
            wordCount.countUniqueWordsInFile("motorcycle_details.txt", "motorcycle_details_word_count.txt");

            // Cargar detalles de vehiculos desde archivos
            fileManager.loadVehicleDetails("airplane_details.txt");
            fileManager.loadVehicleDetails("bus_details.txt");
            fileManager.loadVehicleDetails("helicopter_details.txt");
            fileManager.loadVehicleDetails("truck_details.txt");
            fileManager.loadVehicleDetails("motorcycle_details.txt");

        } catch (InvalidYearException e) {
            logger.error("An error occurred while creating a vehicle: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            logger.warn("A runtime error occurred: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage(), e);
        }
    }
}