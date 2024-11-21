package com.coffeeisoxygen.model.managers;

import java.io.IOException;

import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.interfaces.ITileManager;
import com.coffeeisoxygen.model.strategies.DefaultMapStrategy;
import com.coffeeisoxygen.model.strategies.DijkstraMapStrategy;
import com.coffeeisoxygen.model.strategies.MazeMapStrategy;
import com.coffeeisoxygen.model.strategies.PercolationMapStrategy;
import com.coffeeisoxygen.model.strategies.TemplateMapStrategy;
import com.coffeeisoxygen.model.templates.TemplateData;

public class MapManagerConfig {
    public static MapManager createMapManager(String algorithm) throws IOException {
        ITileFactory tileFactory = new TileFactory();
        ITileManager tileManager = new TileManager(tileFactory);

        IMapStrategy mapStrategy;
        switch (algorithm) {
            case "maze" -> mapStrategy = new MazeMapStrategy((TileManager) tileManager);
            case "percolation" -> mapStrategy = new PercolationMapStrategy((TileManager) tileManager);
            case "dijkstra" -> mapStrategy = new DijkstraMapStrategy((TileManager) tileManager);
            case "template" -> {
                TemplateData templateData = TemplateData.loadFromResource("/templates/template.json");
                mapStrategy = new TemplateMapStrategy((TileManager) tileManager, templateData);
            }
            default -> mapStrategy = new DefaultMapStrategy((TileManager) tileManager);
        }

        return new MapManager(tileManager, mapStrategy);
    }
}