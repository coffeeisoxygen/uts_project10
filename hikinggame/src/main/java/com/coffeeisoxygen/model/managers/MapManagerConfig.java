package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.strategies.DefaultMapStrategy;
import com.coffeeisoxygen.model.templates.TemplateData;
import com.coffeeisoxygen.model.templates.TemplateMapStrategy;
import com.coffeeisoxygen.model.util.DijkstraMapStrategy;

public class MapManagerConfig {
    public static MapManager createMapManager(String strategyType) {
        TileFactory tileFactory = new TileFactory();
        TileManager tileManager = new TileManager(tileFactory);
        IMapStrategy mapStrategy;

        switch (strategyType.toLowerCase()) {
            case "default" -> mapStrategy = new DefaultMapStrategy(tileManager);
            case "dijkstra" -> mapStrategy = new DijkstraMapStrategy(tileManager);
            default -> throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        }

        return new MapManager(tileManager, mapStrategy);
    }

    public static MapManager createMapManager(String strategyType, TemplateData templateData) {
        TileFactory tileFactory = new TileFactory();
        TileManager tileManager = new TileManager(tileFactory);
        IMapStrategy mapStrategy;

        if ("template".equalsIgnoreCase(strategyType)) {
            mapStrategy = new TemplateMapStrategy(tileManager, templateData);
        } else {
            throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        }

        return new MapManager(tileManager, mapStrategy);
    }
}