package com.coffeeisoxygen;

import java.io.IOException;

import com.coffeeisoxygen.model.managers.MapManager;
import com.coffeeisoxygen.model.managers.MapManagerConfig;
import com.coffeeisoxygen.model.templates.TemplateData;

public class Main {
    public static void main(String[] args) {
        try {
            // Load template data
            TemplateData templateData = TemplateData.loadFromResource("/templates/gametemplate/firstmap.json");

            // Using TemplateMapStrategy
            MapManager templateMapManager = MapManagerConfig.createMapManager("template", templateData);
            templateMapManager.createMap(templateData.name, templateData.rows, templateData.cols);
            templateMapManager.visualizeMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}