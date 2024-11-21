package com.coffeeisoxygen.model.templates;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TemplateData {
    public int[][] dangerPositions;
    public int[][] checkpointPositions;
    public String[] checkpointNames;
    public int[][] startPositions;
    public int[][] endPositions;

    public static TemplateData loadFromResource(String resourcePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = TemplateData.class.getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            return mapper.readValue(inputStream, TemplateData.class);
        }
    }
}