package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;

public interface ITileFactory {
    Tile createTile(TileType type); // 

    Tile createTile(TileType type, Coordinate position);
}