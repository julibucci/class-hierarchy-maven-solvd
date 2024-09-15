package org.example.classes;

import org.example.enums.BoatType;
import org.example.exceptions.InvalidYearException;
import org.example.exceptions.NegativeAttributeException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Boat extends Vehicle
{
    private static final Logger logger = LogManager.getLogger(Boat.class);
    private int maxSpeed;
    private int length;
    private int passengerCapacity;
    private String fuelType;
    private boolean hasNavigationSystem;
    private BoatType boatType; // Enum

    public Boat(String brand, String model, int year, int maxSpeed, int length, int passengerCapacity, String fuelType, boolean hasNavigationSystem,BoatType boatType) throws InvalidYearException {
        super(brand, model, year);
        this.maxSpeed = maxSpeed;
        this.length = length;
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
        this.hasNavigationSystem = hasNavigationSystem;
        this.boatType = boatType;
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

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }
    @Override
    public void start() {
        logger.info("The boat is starting.");
    }

    // Exception
    public void setLength(int length) throws NegativeAttributeException {
        if (length < 0) {
            throw new NegativeAttributeException("Length cannot be negative: " + length);
        }
        this.length = length;
    }
}
