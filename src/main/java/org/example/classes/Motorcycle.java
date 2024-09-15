package org.example.classes;

import org.example.enums.VehicleSpeed;
import org.example.exceptions.InvalidYearException;
import java.util.ArrayList;
import java.util.Objects;
import org.example.exceptions.ExceedingMaxSpeedException;

public class Motorcycle extends Vehicle
{
    // Attributes
    private int engineCapacity;
    private String type;
    private boolean hasWindshield;
    private String color;
    private boolean hasABS;
    private ArrayList<String> accessories;
    private int maxSpeed;


    public Motorcycle(String brand, String model, int year, int engineCapacity, String type, boolean hasWindshield, String color, boolean hasABS, ArrayList<String> accessories, int maxSpeed) throws InvalidYearException {
        super(brand, model, year);
        this.engineCapacity = engineCapacity;
        this.type = type;
        this.hasWindshield = hasWindshield;
        this.color = color;
        this.hasABS = hasABS;
        this.accessories = new ArrayList<>();
        setMaxSpeed(maxSpeed);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasWindshield() {
        return hasWindshield;
    }

    public void setHasWindshield(boolean hasWindshield) {
        this.hasWindshield = hasWindshield;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasABS() {
        return hasABS;
    }

    public void setHasABS(boolean hasABS) {
        this.hasABS = hasABS;
    }

    public ArrayList<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<String> accessories) {
        this.accessories = accessories;
    }

    // Metodo para establecer la velocidad máxima usando el enum
    public void setMaxSpeed(int maxSpeed) {
        try {
            VehicleSpeed selectedSpeed = getVehicleSpeed(maxSpeed);
            selectedSpeed.checkSpeed(maxSpeed);  // Valida la velocidad máxima con el enum
            this.maxSpeed = maxSpeed;
        } catch (ExceedingMaxSpeedException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo auxiliar para determinar el rango de velocidad
    private VehicleSpeed getVehicleSpeed(int speed) {
        if (speed <= VehicleSpeed.SLOW.getMaxSpeed()) {
            return VehicleSpeed.SLOW;
        } else if (speed <= VehicleSpeed.MODERATE.getMaxSpeed()) {
            return VehicleSpeed.MODERATE;
        } else if (speed <= VehicleSpeed.FAST.getMaxSpeed()) {
            return VehicleSpeed.FAST;
        } else {
            return VehicleSpeed.EXTREME;
        }
    }

    @Override
    public void start() {
        System.out.println("The motorcycle is starting.");
    }

    // method toString
    @Override
    public String toString() {
        return super.toString() + "Motorcycle{" +
                "engineCapacity=" + engineCapacity +
                ", type='" + type + '\'' +
                ", hasWindshield=" + hasWindshield +
                ", color='" + color + '\'' +
                ", hasABS=" + hasABS +
                ", accessories=" + accessories +
                '}';
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineCapacity, type, hasWindshield, color, hasABS, accessories);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        // Primero, verifica si el objeto es el mismo que el objeto comparado
        if (this == obj) return true;

        // Verifica si el objeto es null o si las clases no coinciden
        if (obj == null || getClass() != obj.getClass()) return false;

        // Realiza el casteo seguro a la clase Motorcycle
        Motorcycle motorcycle = (Motorcycle) obj;

        // Compara los atributos específicos de Motorcycle
        return engineCapacity == motorcycle.engineCapacity &&
                hasWindshield == motorcycle.hasWindshield &&
                hasABS == motorcycle.hasABS &&
                Objects.equals(type, motorcycle.type) &&
                Objects.equals(color, motorcycle.color) &&
                Objects.equals(accessories, motorcycle.accessories);  // Comparar listas de accesorios
    }

    // Collection methods
    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }

    public void removeAccessory(String accessory) {
        accessories.remove(accessory);
    }
}
