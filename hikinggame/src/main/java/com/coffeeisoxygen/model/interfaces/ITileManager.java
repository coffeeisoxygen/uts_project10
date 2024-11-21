package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;

public interface ITileManager {

    Tile createTile(TileType type, String name);

    Tile createTile(TileType type, String name, Coordinate position);

    void placeTile(Tile tile, Coordinate position);

    void resetTile(Coordinate position);

    void changeTileType(Tile tile, TileType newType);
}