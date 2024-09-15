package org.example.classes;

import org.example.enums.HelicopterType;
import org.example.exceptions.InvalidYearException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Helicopter extends Vehicle
{
    // Attributes
    private static final Logger logger = LogManager.getLogger(Helicopter.class);
    private int passengerCapacity;
    private String fuelType;
    private Queue<String> maintenanceTasks;
    private HelicopterType helicopterType;


    // Constructor
    public Helicopter(String brand, String model, int year, int passengerCapacity, String fuelType, Queue<String> maintenanceTasks, HelicopterType helicopterType) throws InvalidYearException {
        super(brand, model, year);
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
        this.maintenanceTasks = new LinkedList<>(maintenanceTasks);
        this.helicopterType = helicopterType;
    }

    // Getter y setter
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

    public Queue<String> getMaintenanceTasks() {
        return maintenanceTasks;
    }

    public void setMaintenanceTasks(Queue<String> maintenanceTasks) {
        this.maintenanceTasks = maintenanceTasks;
    }

    public HelicopterType getHelicopterType() {
        return helicopterType;
    }

    public void setHelicopterType(HelicopterType helicopterType) {
        this.helicopterType = helicopterType;
    }

    public int getMaxAltitude() {
        return helicopterType.getMaxAltitude();
    }

    // Start method
    @Override
    public void start() {
        logger.info("The helicopter is starting.");
    }

    // Method toString
    @Override
    public String toString() {
        return super.toString() + "Helicopter{" +
                "passengerCapacity=" + passengerCapacity +
                ", fuelType='" + fuelType + '\'' +
                ", maxAltitude=" + getMaxAltitude() +
                ", maintenanceTasks=" + maintenanceTasks +
                ", helicopterType=" + helicopterType +
                '}';
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerCapacity, fuelType, maintenanceTasks, helicopterType);
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Helicopter helicopter = (Helicopter) obj;
        return passengerCapacity == helicopter.passengerCapacity &&
                Objects.equals(fuelType, helicopter.fuelType) &&
                Objects.equals(maintenanceTasks, helicopter.maintenanceTasks) &&
                helicopterType == helicopter.helicopterType;
    }

    // Collection methods
    public void addMaintenanceTask(String task) {
        maintenanceTasks.add(task);
    }

    public String performMaintenanceTask() {
        return maintenanceTasks.poll();
    }
}

