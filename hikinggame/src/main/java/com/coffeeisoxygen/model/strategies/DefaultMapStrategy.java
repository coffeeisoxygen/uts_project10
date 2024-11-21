package com.coffeeisoxygen.model.strategies;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class DefaultMapStrategy implements IMapStrategy {
    private final TileManager tileManager;

    public DefaultMapStrategy(TileManager tileManager) {
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
    }
}