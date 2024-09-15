package org.example.classes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.InvalidYearException;

import org.example.interfaces.Pedalable;

import java.util.List;
import java.util.stream.Collectors;
public class Bicycle extends Vehicle implements Pedalable
{
    // Attributes
    private static final Logger logger = LogManager.getLogger(Bicycle.class);
    private boolean hasGear;
    private int numberOfGears;
    private String type;
    private boolean hasSuspension;
    private String frameMaterial;

    // Constructor
    public Bicycle(String brand, String model, int year, boolean hasGear, int numberOfGears, String type, boolean hasSuspension, String frameMaterial) throws InvalidYearException {
        super(brand, model, year);
        this.hasGear = hasGear;
        this.numberOfGears = numberOfGears;
        this.type = type;
        this.hasSuspension = hasSuspension;
        this.frameMaterial = frameMaterial;
    }

    // Getter and setter
    public boolean hasGear() {
        return hasGear;
    }

    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasSuspension() {
        return hasSuspension;
    }

    public void setHasSuspension(boolean hasSuspension) {
        this.hasSuspension = hasSuspension;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    // Start method
    @Override
    public void start() {
        logger.info("The bicycle is ready to ride.");
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + "Bicycle{" +
                "hasGear=" + hasGear +
                ", numberOfGears=" + numberOfGears +
                ", type='" + type + '\'' +
                ", hasSuspension=" + hasSuspension +
                ", frameMaterial='" + frameMaterial + '\'' +
                '}';
    }

    // Interface implementation
    @Override
    public void pedal() {
        logger.info("Pedaling the bicycle.");
    }

    @Override
    public void brake() {
        logger.info("Applying the bicycle brake.");
    }

    // 4.Filters bicycles with more than 5 gears, maps them to text descriptions and then prints those descriptions.
    public static void processBicycles(List<Bicycle> bicycles) {
        List<String> descriptions = bicycles.stream()
                .filter(b -> b.getNumberOfGears() > 5)
                .map(b -> "Bicycle: " + b.getBrand() + " " + b.getModel() + ", Gears: " + b.getNumberOfGears()) // Map to descriptions (NonTOp)
                .collect(Collectors.toList()); // Collect results into a list (TO)

        descriptions.forEach(description -> logger.info(description));
    }

}
