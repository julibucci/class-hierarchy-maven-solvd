package org.example.classes;

import java.io.*;

public class VehicleFileManager
{
    // Method to write vehicle details to a file
    public void saveVehicleDetails(Vehicle vehicle, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(vehicle.toString());
            System.out.println("Vehicle details saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read vehicle details from a file
    public void loadVehicleDetails(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Loaded vehicle details: " + line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
