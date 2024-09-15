package org.example.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class VehicleFileManager
{
    private static final Logger logger = LogManager.getLogger(VehicleFileManager.class);
    // Method to write vehicle details to a file
    public void saveVehicleDetails(Vehicle vehicle, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(vehicle.toString());
            logger.info("Vehicle details saved to file: " + filePath);
        } catch (IOException e) {
            logger.error("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read vehicle details from a file
    public void loadVehicleDetails(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                logger.info("Loaded vehicle details: " + line);
            }
        } catch (IOException e) {
            logger.error("An error occurred while reading the file: " + e.getMessage(),e);
        }
    }

    // Method to count unique words in a file
    public void countWordsInVehicleDetails(String filePath)
    {
        WordCount wordCountManager = new WordCount();
        String resultFilePath = filePath.replace(".txt", "_word_count.txt");
        wordCountManager.countUniqueWordsInFile(filePath, resultFilePath);
    }
}
