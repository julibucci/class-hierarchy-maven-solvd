package org.example.classes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.InvalidYearException;
import java.util.stream.Collectors;
import org.example.interfaces.Electric;

import java.util.ArrayList;
import java.util.List;

public final class ElectricScooter extends Vehicle implements Electric
{
    // Attributes
    private static final Logger logger = LogManager.getLogger(ElectricScooter.class);
    private int batteryLife;
    private int maxSpeed;
    private int range;
    private boolean hasLights;
    private boolean hasBluetooth;
    private List<String> features;

    // Constructor
    public ElectricScooter(String brand, String model, int year, int batteryLife, int maxSpeed, int range, boolean hasLights, boolean hasBluetooth,List<String> features) throws InvalidYearException {
        super(brand, model, year);
        this.batteryLife = batteryLife;
        this.maxSpeed = maxSpeed;
        this.range = range;
        this.hasLights = hasLights;
        this.hasBluetooth = hasBluetooth;
        this.features = new ArrayList<>(features);
    }

    // Getter and Setter
    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public boolean isHasLights() {
        return hasLights;
    }

    public void setHasLights(boolean hasLights) {
        this.hasLights = hasLights;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    // Method start
    @Override
    public void start() {
        logger.info("The electric scooter is starting.");
    }

    // Interface implementation
    public void chargeBattery() {
        logger.info("Charging the battery.");
    }

    //5. Method to process and print features using streams
    public void processAndPrintFeatures()
    {
        List<String> processedFeatures = features.stream()
                .filter(feature -> feature.contains("LED")) // Filter for features containing "LED"
                .map(feature -> "Feature: " + feature.toUpperCase())
                .collect(Collectors.toList()); // collect into a list (Terminal operation)

        processedFeatures.forEach(feature -> logger.info(feature));// print each feature (terminal operation)
    }
}
