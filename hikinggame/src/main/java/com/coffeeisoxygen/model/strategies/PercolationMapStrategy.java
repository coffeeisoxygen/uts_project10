package com.coffeeisoxygen.model.strategies;

import java.util.Random;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class PercolationMapStrategy implements IMapStrategy {
    private final TileManager tileManager;
    private final Random random = new Random();

    public PercolationMapStrategy(TileManager tileManager) {
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

        // Example percolation generation logic
        for (int row = 0; row < mapBoard.getBoard().getHeight(); row++) {
            for (int col = 0; col < mapBoard.getBoard().getWidth(); col++) {
                if (random.nextDouble() < 0.3) { // 30% chance to place a percolation tile
                    Coordinate position = new Coordinate(row, col);
                    Tile percolationTile = tileManager.createTile(TileType.DANGERPOINT, "Percolation", position);
                    mapBoard.setTile(position, percolationTile);
                }
            }
        }

        // Place start and finish tiles
        mapBoard.setTile(new Coordinate(0, 0),
                tileManager.createTile(TileType.STARTPOINT, "Start", new Coordinate(0, 0)));
        mapBoard.setTile(new Coordinate(mapBoard.getBoard().getHeight() - 1, mapBoard.getBoard().getWidth() - 1),
                tileManager.createTile(TileType.FINISHPOINT, "Finish",
                        new Coordinate(mapBoard.getBoard().getHeight() - 1, mapBoard.getBoard().getWidth() - 1)));
    }
}