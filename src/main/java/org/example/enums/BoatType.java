package org.example.enums;

public enum BoatType
{
    //Atributos
    SAILBOAT("Sailboat", 6),
    FISHING_BOAT("Fishing Boat", 8);

    private final String name;
    private final int passengerCapacity;

    // Constructor
    BoatType(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    // Metodo para verificar si un tipo de barco puede acomodar una cantidad dada de pasajeros
    public boolean canAccommodate(int passengers) {
        return passengers <= passengerCapacity;
    }
}
