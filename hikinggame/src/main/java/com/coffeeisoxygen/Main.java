package com.coffeeisoxygen;

import com.coffeeisoxygen.model.classes.board.MapGeneratorContext;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.IMapManager;
import com.coffeeisoxygen.model.interfaces.IMapSaver;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.interfaces.ITilePlacementAlgorithm;
import com.coffeeisoxygen.model.managers.MapManager;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.strategies.CustomMapEditor;
import com.coffeeisoxygen.model.strategies.CustomMapLoader;
import com.coffeeisoxygen.model.strategies.CustomMapSaver;
import com.coffeeisoxygen.model.strategies.DefaultTilePlacementAlgorithm;
import com.coffeeisoxygen.model.strategies.DijkstraTilePlacement;
import com.coffeeisoxygen.model.strategies.MazeTilePlacement;
import com.coffeeisoxygen.model.strategies.PercolationTilePlacement;
import com.coffeeisoxygen.model.strategies.SimpleMapGenerator;
import com.coffeeisoxygen.model.strategies.TemplateTilePlacement;
import com.coffeeisoxygen.model.util.Coordinate;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create a tile factory and manager
        ITileFactory tileFactory = new TileFactory();
        TileManager tileManager = new TileManager(tileFactory);

        // Create map strategies
        IMapGenerator simpleMapGenerator = new SimpleMapGenerator();
        IMapLoader mapLoader = new CustomMapLoader();
        IMapSaver mapSaver = new CustomMapSaver("map.ser");
        IMapEditor mapEditor = new CustomMapEditor();
        ITilePlacementAlgorithm defaultTilePlacementAlgorithm = new DefaultTilePlacementAlgorithm(tileManager);
        ITilePlacementAlgorithm mazeTilePlacementAlgorithm = new MazeTilePlacement(tileManager);
        ITilePlacementAlgorithm percolationTilePlacementAlgorithm = new PercolationTilePlacement(tileManager);
        ITilePlacementAlgorithm dijkstraTilePlacementAlgorithm = new DijkstraTilePlacement(tileManager);

        // Create a map generator context
        MapGeneratorContext mapGeneratorContext = new MapGeneratorContext();
        mapGeneratorContext.setMapGenerator(simpleMapGenerator);

        // Create a template tile placement algorithm
        HashMap<String, TileType[][]> templates = new HashMap<>();
        ITilePlacementAlgorithm templateTilePlacementAlgorithm = new TemplateTilePlacement(tileManager);

        // Create a map manager
        IMapManager mapManager = new MapManager(tileManager, mapGeneratorContext, mapLoader, mapSaver, mapEditor, templateTilePlacementAlgorithm);

        // Create and place tiles on the map
        mapManager.createMap(10, 10);
        Tile startTile = tileManager.createTile(TileType.STARTPOINT, "Start", new Coordinate(0, 0));
        Tile finishTile = tileManager.createTile(TileType.FINISHPOINT, "Finish", new Coordinate(9, 9));
        mapManager.setTile(new Coordinate(0, 0), startTile);
        mapManager.setTile(new Coordinate(9, 9), finishTile);

        // Visualize the map
        mapManager.visualizeMap();

        // Save the map
        mapManager.saveMap();

        // Load the map
        mapManager.loadMap();
        mapManager.visualizeMap();

        // Reset the map
        mapManager.resetMap();
        mapManager.visualizeMap();

        // Change map generator strategy
        IMapGenerator anotherMapGenerator = new AnotherMapGenerator();
        mapManager.setMapGenerator(anotherMapGenerator);
        mapManager.createMap(10, 10);
        mapManager.visualizeMap();

        // Use different tile placement algorithms
        mapManager = new MapManager(tileManager, mapGeneratorContext, mapLoader, mapSaver, mapEditor, mazeTilePlacementAlgorithm);
        mapManager.createMap(10, 10);
        mapManager.visualizeMap();

        mapManager = new MapManager(tileManager, mapGeneratorContext, mapLoader, mapSaver, mapEditor, percolationTilePlacementAlgorithm);
        mapManager.createMap(10, 10);
        mapManager.visualizeMap();

        mapManager = new MapManager(tileManager, mapGeneratorContext, mapLoader, mapSaver, mapEditor, dijkstraTilePlacementAlgorithm);
        mapManager.createMap(10, 10);
        mapManager.visualizeMap();
    }
}