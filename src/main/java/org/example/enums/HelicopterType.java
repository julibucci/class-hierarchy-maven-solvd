package org.example.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum HelicopterType {
    RESCUE("Rescue Helicopter",4000, 6000),
    MILITARY("Military Helicopter", 8000,12000),
    COMMERCIAL("Commercial Helicopter", 7000, 10000),
    NEWS("News Helicopter",3000, 5000),
    PRIVATE("Private Helicopter", 4000, 4000);

    private final String typeName;
    private final int maxWeight;
    private final int maxAltitude;

    private static final Logger logger = LogManager.getLogger(HelicopterType.class);

    // Constructor del enum
    HelicopterType(String typeName,int maxWeight,int maxAltitude) {
        this.typeName = typeName;
        this.maxWeight = maxWeight;
        this.maxAltitude = maxAltitude;
    }

    // Métodos para acceder a los campos
    public String getTypeName() {
        return typeName;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    // Método para verificar si un helicóptero está sobrecargado
    public boolean isOverloaded(int currentWeight) {
        return currentWeight > maxWeight;
    }

    // Método para mostrar la descripción del tipo de helicóptero
    public String getDescription() {
        return typeName + ": max weight " + maxWeight + ", max altitude " + maxAltitude;
    }

    // Bloque de inicialización estático
    static {
        logger.info("HelicopterType enum loaded.");
    }

    @Override
    public String toString() {
        return getDescription();
    }
}