package com.coffeeisoxygen.config;

import com.coffeeisoxygen.model.strategies.MapGeneratorContext;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.*;
import com.coffeeisoxygen.model.managers.MapManager;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.strategies.*;
import com.coffeeisoxygen.model.util.Coordinate;

import java.util.HashMap;

public class MapManagerConfig {
    public static IMapManager createMapManager(String algorithm) {
        // Create a tile factory and manager
        ITileFactory tileFactory = new TileFactory();
        TileManager tileManager = new TileManager(tileFactory);

        // Create map strategies
        IMapGenerator simpleMapGenerator = new SimpleMapGenerator();
        ITilePlacementAlgorithm tilePlacementAlgorithm;

        switch (algorithm) {
            case "maze" -> tilePlacementAlgorithm = new MazeTilePlacement(tileManager);
            case "percolation" -> tilePlacementAlgorithm = new PercolationTilePlacement(tileManager);
            case "dijkstra" -> tilePlacementAlgorithm = new DijkstraTilePlacement(tileManager);
            case "template" -> {
                HashMap<String, TileType[][]> templates = new HashMap<>();
                tilePlacementAlgorithm = new TemplateTilePlacement(tileManager, templates);
            }
            default -> tilePlacementAlgorithm = new DefaultTilePlacementAlgorithm(tileManager);
        }

        // Create a map generator context
        MapGeneratorContext mapGeneratorContext = new MapGeneratorContext();
        mapGeneratorContext.setMapGenerator(simpleMapGenerator);

        // Create and return the map manager
        return new MapManager(tileManager, mapGeneratorContext, null, null, null, tilePlacementAlgorithm);
    }
}