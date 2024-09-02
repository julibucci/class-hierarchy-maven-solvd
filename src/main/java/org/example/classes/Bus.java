package org.example.classes;

import org.example.exceptions.ExceedingPassengerCapacityException;
import org.example.exceptions.InvalidYearException;

import java.util.ArrayList;

public class Bus extends Vehicle
{
    private int seatingCapacity;
    private int numberOfDoors;
    private String fuelType;
    private ArrayList<String> routes;

    public Bus(String brand, String model, int year, int seatingCapacity, int numberOfDoors, String fuelType, CustomLinkedList<String> routes) throws InvalidYearException {
        super(brand, model, year);
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.routes = new ArrayList<>();
    }

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

    @Override
    public void start() {
        System.out.println("The bus is starting.");
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
