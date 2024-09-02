package org.example.classes;
import org.example.exceptions.InvalidYearException;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Helicopter extends Vehicle
{
    private int rotorSpeed;
    private int passengerCapacity;
    private int maxAltitude;
    private String fuelType;
    private boolean hasAutopilot;
    private Queue<String> maintenanceTasks;

    public Helicopter(String brand, String model, int year, int rotorSpeed, int passengerCapacity, int maxAltitude, String fuelType, boolean hasAutopilot,Queue<String> maintenanceTasks) throws InvalidYearException {
        super(brand, model, year);
        this.rotorSpeed = rotorSpeed;
        this.passengerCapacity = passengerCapacity;
        this.maxAltitude = maxAltitude;
        this.fuelType = fuelType;
        this.hasAutopilot = hasAutopilot;
        this.maintenanceTasks = new LinkedList<>();
    }

    public int getRotorSpeed() {
        return rotorSpeed;
    }

    public void setRotorSpeed(int rotorSpeed) {
        this.rotorSpeed = rotorSpeed;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isHasAutopilot() {
        return hasAutopilot;
    }

    public void setHasAutopilot(boolean hasAutopilot) {
        this.hasAutopilot = hasAutopilot;
    }

    public Queue<String> getMaintenanceTasks() {
        return maintenanceTasks;
    }

    public void setMaintenanceTasks(Queue<String> maintenanceTasks) {
        this.maintenanceTasks = maintenanceTasks;
    }

    @Override
    public void start() {
        System.out.println("The helicopter is starting.");
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + "Helicopter{" +
                "rotorSpeed=" + rotorSpeed +
                ", passengerCapacity=" + passengerCapacity +
                ", maxAltitude=" + maxAltitude +
                ", fuelType='" + fuelType + '\'' +
                ", hasAutopilot=" + hasAutopilot +
                ", maintenanceTasks=" + maintenanceTasks +
                '}';
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rotorSpeed, passengerCapacity, maxAltitude, fuelType, hasAutopilot, maintenanceTasks);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Helicopter helicopter = (Helicopter) obj;
        return rotorSpeed == helicopter.rotorSpeed &&
                passengerCapacity == helicopter.passengerCapacity &&
                maxAltitude == helicopter.maxAltitude &&
                hasAutopilot == helicopter.hasAutopilot &&
                Objects.equals(fuelType, helicopter.fuelType) &&
                Objects.equals(maintenanceTasks, helicopter.maintenanceTasks);
    }

    // Collection methods
    public void addMaintenanceTask(String task) {
        maintenanceTasks.add(task);
    }

    public String performMaintenanceTask() {
        return maintenanceTasks.poll();
    }
}
