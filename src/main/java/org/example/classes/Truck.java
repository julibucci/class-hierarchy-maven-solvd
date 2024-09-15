package org.example.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.FuelType;
import org.example.exceptions.InvalidYearException;

import java.util.HashMap;
import org.example.interfaces.Transportable;

public class Truck extends Vehicle implements Transportable
{
    private static final Logger logger = LogManager.getLogger(Truck.class);
    // Attributes
    private int loadCapacity;
    private int cabinSize;
    private HashMap<String, Integer> cargo;
    private FuelType fuelType;

    // Constructor
    public Truck(String brand, String model, int year, int loadCapacity, int cabinSize, FuelType fuelType, HashMap<String, Integer> cargo) throws InvalidYearException {
        super(brand, model, year);
        this.loadCapacity = loadCapacity;
        this.cabinSize = cabinSize;
        this.fuelType = fuelType;
        this.cargo = cargo != null ? cargo : new HashMap<>();
    }

    // Getter y setter
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getCabinSize() {
        return cabinSize;
    }

    public void setCabinSize(int cabinSize) {
        this.cabinSize = cabinSize;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public HashMap<String, Integer> getCargo() {
        return cargo;
    }

    public void setCargo(HashMap<String, Integer> cargo) {
        this.cargo = cargo;
    }

    @Override
    public void start() {
        logger.info("The truck is starting.");
    }

    // Interface implementation
    @Override
    public void loadCargo() {
        logger.info("Loading cargo into the truck.");
    }

    @Override
    public void unloadCargo() {
        logger.info("Unloading cargo from the truck.");
    }

    // Collections methods
    public void addCargo(String type, int quantity) {
        cargo.put(type, quantity);
    }

    public void removeCargo(String type) {
        cargo.remove(type);
    }
}
