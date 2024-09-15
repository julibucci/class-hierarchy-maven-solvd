package org.example.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.FuelType;
import org.example.enums.TransmissionType;
import org.example.exceptions.ExceedingMaxSpeedException;
import org.example.exceptions.InvalidYearException;

import org.example.interfaces.Convertible;
public class Car extends Vehicle implements Convertible
{
    private static final Logger logger = LogManager.getLogger(Car.class);
    // Attributes
    protected int doors;
    protected String color;
    private String fuelType;
    private boolean hasSunroof;
    private boolean isRoofOpen;
    private int maxSpeed;
    private TransmissionType transmissionType;


    // Constructor
    public Car(String brand, String model, int year, int doors, String color, String fuelType, boolean hasSunroof, boolean isRoofOpen,int maxSpeed, TransmissionType transmissionType) throws InvalidYearException {
        super(brand, model, year);
        this.doors = doors;
        this.color = color;
        this.fuelType = fuelType;
        this.hasSunroof = hasSunroof;
        this.isRoofOpen = false; // By default the roof is close
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
    }

    // Getter y setter
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public boolean isRoofOpen() {
        return isRoofOpen;
    }

    public void setRoofOpen(boolean roofOpen) {
        isRoofOpen = roofOpen;
    }

    @Override
    public void start() {
        logger.info("The car is starting.");
    }

    // Method overloading
    public void accelerate() {
        logger.info("The car is accelerating.");
    }

    public void accelerate(int speed) {
        logger.info("The car is accelerating to " + speed + " km/h.");
    }

    // Method toString
    @Override
    public String toString() {
        return super.toString() + "Car{" +
                "doors=" + doors +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", hasSunroof=" + hasSunroof +
                "isRoofOpen=" + isRoofOpen +
                '}';
    }

    // Interface implementation
    @Override
    public void openRoof() {
        if (hasSunroof && !isRoofOpen) {
            logger.info("Opening the cars roof.");
            isRoofOpen = true;
        } else if (isRoofOpen) {
            logger.info("The roof is already open.");
        } else {
            logger.info("This car doesn't have a sunroof.");
        }
    }

    @Override
    public void closeRoof() {
        if (hasSunroof && isRoofOpen) {
            logger.info("Closing the cars roof.");
            isRoofOpen = false;
        } else if (!isRoofOpen) {
            logger.info("The roof is already closed.");
        } else {
            logger.info("This car doesn't have a sunroof.");
        }
    }

    public void setMaxSpeed(int maxSpeed) {
        try {
            if (maxSpeed > 200) {
                throw new ExceedingMaxSpeedException("Max speed cannot exceed 200 km/h");
            }
            this.maxSpeed = maxSpeed;
        } catch (ExceedingMaxSpeedException e) {
            logger.error(e.getMessage(),e);
        }
    }

    public String getTransmissionDescription() {
        return this.transmissionType.getDescription();
    }
}
