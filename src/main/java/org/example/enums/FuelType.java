package org.example.enums;

public enum FuelType {
    GASOLINE("Gasoline"),
    DIESEL("Diesel"),
    ELECTRIC("Electric");

    private final String name;

    FuelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
