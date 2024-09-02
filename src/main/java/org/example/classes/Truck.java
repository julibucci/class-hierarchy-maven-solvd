package org.example.classes;
import org.example.exceptions.InvalidYearException;

import java.util.HashMap;

import org.example.interfaces.Transportable;
public class Truck extends Vehicle implements Transportable {
    // Attributes
    private int loadCapacity;
    private int numberOfAxles;
    private boolean hasTrailer;
    private String fuelType;
    private int cabinSize;
    private HashMap<String, Integer> cargo;

    // Constructor
    public Truck(String brand, String model, int year, int loadCapacity, int numberOfAxles, boolean hasTrailer, String fuelType, int cabinSize,HashMap<String, Integer> cargo) throws InvalidYearException {
        super(brand, model, year);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.hasTrailer = hasTrailer;
        this.fuelType = fuelType;
        this.cabinSize = cabinSize;
        this.cargo = new HashMap<>();
    }

    // Getter y setter
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getCabinSize() {
        return cabinSize;
    }

    public void setCabinSize(int cabinSize) {
        this.cabinSize = cabinSize;
    }

    public HashMap<String, Integer> getCargo() {
        return cargo;
    }

    public void setCargo(HashMap<String, Integer> cargo) {
        this.cargo = cargo;
    }

    @Override
    public void start() {
        System.out.println("The truck is starting.");
    }

    // Interface implementation
    @Override
    public void loadCargo() {
        System.out.println("Loading cargo into the truck.");
    }

    @Override
    public void unloadCargo() {
        System.out.println("Unloading cargo from the truck.");
    }

    // Collections methods
    public void addCargo(String type, int quantity) {
        cargo.put(type, quantity);
    }

    public void removeCargo(String type) {
        cargo.remove(type);
    }
}
