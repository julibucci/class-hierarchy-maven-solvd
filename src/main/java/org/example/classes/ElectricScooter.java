package org.example.classes;
import org.example.exceptions.InvalidYearException;

import org.example.interfaces.Electric;
public final class ElectricScooter extends Vehicle implements Electric
{
    private int batteryLife;
    private int maxSpeed;
    private int range;
    private boolean hasLights;
    private boolean hasBluetooth;

    public ElectricScooter(String brand, String model, int year, int batteryLife, int maxSpeed, int range, boolean hasLights, boolean hasBluetooth) throws InvalidYearException {
        super(brand, model, year);
        this.batteryLife = batteryLife;
        this.maxSpeed = maxSpeed;
        this.range = range;
        this.hasLights = hasLights;
        this.hasBluetooth = hasBluetooth;
    }

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

    @Override
    public void start() {
        System.out.println("The electric scooter is starting.");
    }

    // Interface implementation
    public void chargeBattery() {
        System.out.println("Charging the battery.");
    }
}
