package org.example.classes;

import org.example.exceptions.InvalidYearException;
import org.example.exceptions.NegativeAttributeException;

public class Boat extends Vehicle
{
    private int maxSpeed;
    private int length;
    private int passengerCapacity;
    private String fuelType;
    private boolean hasNavigationSystem;

    public Boat(String brand, String model, int year, int maxSpeed, int length, int passengerCapacity, String fuelType, boolean hasNavigationSystem) throws InvalidYearException {
        super(brand, model, year);
        this.maxSpeed = maxSpeed;
        this.length = length;
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
        this.hasNavigationSystem = hasNavigationSystem;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getLength() {
        return length;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isHasNavigationSystem() {
        return hasNavigationSystem;
    }

    public void setHasNavigationSystem(boolean hasNavigationSystem) {
        this.hasNavigationSystem = hasNavigationSystem;
    }

    @Override
    public void start() {
        System.out.println("The boat is starting.");
    }

    // Exception
    public void setLength(int length) throws NegativeAttributeException {
        if (length < 0) {
            throw new NegativeAttributeException("Length cannot be negative: " + length);
        }
        this.length = length;
    }
}
