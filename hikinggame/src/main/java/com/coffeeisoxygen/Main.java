package com.coffeeisoxygen;

import java.io.IOException;

import com.coffeeisoxygen.model.managers.MapManager;
import com.coffeeisoxygen.model.managers.MapManagerConfig;

public class Main {
    public static void main(String[] args) {
        try {
            // Using DefaultMapStrategy
            MapManager defaultMapManager = MapManagerConfig.createMapManager("default");
            defaultMapManager.createMap("DefaultMap", 6, 12);
            defaultMapManager.visualizeMap();

            // Using DijkstraMapStrategy
            MapManager dijkstraMapManager = MapManagerConfig.createMapManager("dijkstra");
            dijkstraMapManager.createMap("DijkstraMap", 6, 12);
            dijkstraMapManager.visualizeMap();

            // Using TemplateMapStrategy
            MapManager templateMapManager = MapManagerConfig.createMapManager("template");
            templateMapManager.createMap("TemplateMap", 6, 12);
            templateMapManager.visualizeMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}