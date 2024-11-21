package com.coffeeisoxygen.model.util;

import java.util.Random;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.managers.TileManager;

public class DijkstraMapStrategy implements IMapStrategy {
    private final TileManager tileManager;

    public DijkstraMapStrategy(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    @Override
    public MapBoard generateMap(String name, int rows, int cols) {
        MapBoard mapBoard = new MapBoard(name, rows, cols);
        placeTiles(mapBoard);
        return mapBoard;
    }

    @Override
    public void placeTiles(MapBoard mapBoard) {
        TilePlacementUtils.placeDefaultTiles(tileManager, mapBoard);
        placeDangerTiles(mapBoard, 10); // Place 10 danger tiles
        placeWaterTiles(mapBoard, 5); // Place 5 water tiles
        placeForestTiles(mapBoard, 7); // Place 7 forest tiles
    }

    private void placeDangerTiles(MapBoard mapBoard, int count) {
        placeRandomTiles(mapBoard, count, TileType.DANGERPOINT, "Danger");
    }

    private void placeWaterTiles(MapBoard mapBoard, int count) {
        placeRandomTiles(mapBoard, count, TileType.NORMALPOINT, "Water");
    }

    private void placeForestTiles(MapBoard mapBoard, int count) {
        placeRandomTiles(mapBoard, count, TileType.CHECKPOINT, "Forest");
    }

    private void placeRandomTiles(MapBoard mapBoard, int count, TileType tileType, String tileName) {
        Random random = new Random();
        int rows = mapBoard.getBoard().getHeight();
        int cols = mapBoard.getBoard().getWidth();

        for (int i = 0; i < count; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            Coordinate position = new Coordinate(col, row);
            if (mapBoard.isValidPosition(position) && mapBoard.getTile(position) == null) {
                Tile tile = tileManager.createTile(tileType, tileName, position);
                mapBoard.setTile(position, tile);
            }
        }
    }
    // TODO: Implement DijkstraMapStrategy for scoring
}