package org.example.classes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class WordCount {

    public void countUniqueWordsInFile(String inputFilePath, String outputFilePath) {
        try {
            // Leer el contenido del archivo
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            // Verificar el contenido leído
            if (StringUtils.isBlank(content)) {
                System.out.println("El archivo de entrada está vacío o no se pudo leer.");
                return;
            }

            // Limpieza del contenido
            // Reemplazar caracteres especiales por espacios y convertir a minúsculas
            content = content.replaceAll("[^a-zA-Z0-9\\s]", " ").toLowerCase();

            // Contar las palabras
            Map<String, Integer> wordCountMap = new HashMap<>();
            String[] words = content.split("\\s+");

            for (String word : words) {
                if (StringUtils.isNotBlank(word)) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Verificar si el mapa de conteo de palabras está vacío
            if (wordCountMap.isEmpty()) {
                System.out.println("No se encontraron palabras válidas en el archivo.");
                return;
            }

            // Escribir los resultados en el archivo de salida
            StringBuilder resultBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(System.lineSeparator());
            }
            FileUtils.writeStringToFile(new File(outputFilePath), resultBuilder.toString(), "UTF-8");

            System.out.println("Word count results saved to file: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
