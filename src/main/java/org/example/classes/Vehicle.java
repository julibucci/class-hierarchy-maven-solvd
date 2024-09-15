package org.example.classes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.InvalidYearException;
import java.util.Objects;

public abstract class Vehicle
{
    // Attributes
    private static final Logger logger = LogManager.getLogger(Vehicle.class);
    protected String brand;
    protected String model;
    protected int year;
    public static final int MAX_YEAR = 2024; // final variable
    private static int vehicleCount = 0; // static variable

    // Static block
    static {
        logger.info("Static block of Vehicle class executed.");
        vehicleCount = 0; // Initialize static variable
    }

    // Constructor with exception
    public Vehicle(String brand, String model, int year) throws InvalidYearException {
        this.brand = brand;
        this.model = model;
        if (year > MAX_YEAR) {
            throw new InvalidYearException("Year cannot exceed " + MAX_YEAR);
        }
        this.year = year;
        vehicleCount++;
    }

    // Getter y setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidYearException {
        if (year > MAX_YEAR) {
            throw new InvalidYearException("Year cannot exceed " + MAX_YEAR);
        }
        this.year = year;
    }

    // Abstract method
    protected abstract void start();

    // toString method
    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    // Hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        return (this == obj) ||
                (obj != null &&
                        getClass() == obj.getClass() &&
                        // Compara el año del objeto actual con el del objeto comparado
                        year == ((Vehicle) obj).year &&
                        // Compara la marca del objeto actual con la del objeto comparado
                        Objects.equals(brand, ((Vehicle) obj).brand) &&
                        // Compara el modelo del objeto actual con el del objeto comparado
                        Objects.equals(model, ((Vehicle) obj).model));
    }

    // Final method
    public final void printVehicleDetails()
    {
        logger.info("Vehicle Details:");
        logger.info("Brand: " + brand);
        logger.info("Model: " + model);
        logger.info("Year: " + year);
    }
    // Static method
    public static int getVehicleCount() {
        return vehicleCount;
    }

}
