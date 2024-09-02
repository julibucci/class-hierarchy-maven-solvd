package org.example.classes;
import org.example.exceptions.UnsupportedFuelTypeException;
import java.util.HashSet;

import org.example.interfaces.Flyable;
import org.example.exceptions.InvalidYearException;
public class Airplane extends Vehicle implements Flyable
{
    private int altitude;
    private int passengerCapacity;
    private String fuelType;
    private HashSet<String> passengers;

    public Airplane(String brand, String model, int year, int altitude, int passengerCapacity, String fuelType, CustomLinkedList<String> passengers) throws InvalidYearException {
        super(brand, model, year);
        this.altitude = altitude;
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
        this.passengers = new HashSet<>();
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
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

    public HashSet<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(HashSet<String> passengers) {
        this.passengers = passengers;
    }

    @Override
    public void start() {
        System.out.println("The airplane is taking off.");
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + "Airplane{" +
                "altitude=" + altitude +
                ", passengerCapacity=" + passengerCapacity +
                ", fuelType='" + fuelType + '\'' +
                ", passengers=" + passengers +
                '}';
    }

    // Interface implementation
    @Override
    public void takeOff() {
        System.out.println("The airplane is taking off.");
        this.altitude = 10000;
    }

    // Exception
    public void setFuelType(String fuelType) throws UnsupportedFuelTypeException {
        if (!fuelType.equalsIgnoreCase("Jet Fuel") && !fuelType.equalsIgnoreCase("Aviation Gasoline")) {
            throw new UnsupportedFuelTypeException("Unsupported fuel type: " + fuelType);
        }
        this.fuelType = fuelType;
    }

    // Collection
    public void addPassenger(String passenger) {
        passengers.add(passenger);
    }

    public void removePassenger(String passenger) {
        passengers.remove(passenger);
    }
}
