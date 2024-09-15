package org.example.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.ExceedingPassengerCapacityException;
import org.example.exceptions.InvalidYearException;

import java.util.ArrayList;

public class Bus extends Vehicle
{
    // Attributes
    private static final Logger logger = LogManager.getLogger(Bus.class);
    private int seatingCapacity;
    private int numberOfDoors;
    private String fuelType;
    private ArrayList<String> routes;
    private int passengerCapacity;

    // Constructor
    public Bus(String brand, String model, int year, int seatingCapacity, int numberOfDoors, String fuelType, CustomLinkedList<String> routes,int passengerCapacity) throws InvalidYearException {
        super(brand, model, year);
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.routes = new ArrayList<>();
        this.passengerCapacity = passengerCapacity;
    }

    // Getter and setter
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<String> routes) {
        this.routes = routes;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    // Method start
    @Override
    public void start() {
        logger.info("The bus is starting.");
    }

    // Exception
    public void setSeatingCapacity(int seatingCapacity) throws ExceedingPassengerCapacityException {
        if (seatingCapacity > 50) // we assume that the limit is 50
        {
            throw new ExceedingPassengerCapacityException("Seating capacity exceeds the allowed limit of 50.");
        }
        this.seatingCapacity = seatingCapacity;
    }
}
