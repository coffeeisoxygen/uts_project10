package com.coffeeisoxygen.model.util;

import com.coffeeisoxygen.model.classes.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITileFactory;

public class TileManager {
    public static Tile createTileWithPosition(ITileFactory tileFactory, TileType type, int row, int col, String name) {
        Tile tile = tileFactory.createTile(type);
        tile.setPosition(new Coordinate(row, col));
        tile.setName(name); // Assuming Tile class has a setName method
        return tile;
    }
}