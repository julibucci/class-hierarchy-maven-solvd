package org.example.classes;
import org.example.exceptions.InvalidYearException;

import org.example.interfaces.Pedalable;
public class Bicycle extends Vehicle implements Pedalable
{
    private boolean hasGear;
    private int numberOfGears;
    private String type;
    private boolean hasSuspension;
    private String frameMaterial;

    public Bicycle(String brand, String model, int year, boolean hasGear, int numberOfGears, String type, boolean hasSuspension, String frameMaterial) throws InvalidYearException {
        super(brand, model, year);
        this.hasGear = hasGear;
        this.numberOfGears = numberOfGears;
        this.type = type;
        this.hasSuspension = hasSuspension;
        this.frameMaterial = frameMaterial;
    }

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

    @Override
    public void start() {
        System.out.println("The bicycle is ready to ride.");
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
        System.out.println("Pedaling the bicycle.");
    }

    @Override
    public void brake() {
        System.out.println("Applying the bicycle brake.");
    }


}
