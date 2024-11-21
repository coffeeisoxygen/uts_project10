package com.coffeeisoxygen.model.strategies;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.interfaces.ITilePlacementAlgorithm;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class DefaultTilePlacement implements ITilePlacementAlgorithm {
    private final TileManager tileManager;

    public DefaultTilePlacement(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    @Override
    public void placeTiles(MapBoard mapBoard) {
        TilePlacementUtils.placeNormalTiles(tileManager, mapBoard);
    }
}