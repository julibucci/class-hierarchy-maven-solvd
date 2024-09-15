package org.example.classes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordCount {

    // Logger instance
    private static final Logger logger = LogManager.getLogger(WordCount.class);

    public void countUniqueWordsInFile(String inputFilePath, String outputFilePath) {
        try {
            // Read content of the file
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            // Check the content read
            if (StringUtils.isBlank(content)) {
                logger.info("The input file is empty or could not be read.");
                return;
            }

            // Clean the content
            // Replace special characters with spaces and convert to lowercase
            content = content.replaceAll("[^a-zA-Z0-9\\s]", " ").toLowerCase();

            // Count the words
            Map<String, Integer> wordCountMap = new HashMap<>();
            String[] words = content.split("\\s+");

            for (String word : words) {
                if (StringUtils.isNotBlank(word)) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Check if word count map is empty
            if (wordCountMap.isEmpty()) {
                logger.info("No valid words were found in the file.");
                return;
            }

            // Write results to output file
            StringBuilder resultBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(System.lineSeparator());
            }
            FileUtils.writeStringToFile(new File(outputFilePath), resultBuilder.toString(), "UTF-8");

            logger.info("Word count results saved to file: " + outputFilePath);

        } catch (IOException e) {
            logger.error("An error occurred: " + e.getMessage(), e);
        }
    }
}

