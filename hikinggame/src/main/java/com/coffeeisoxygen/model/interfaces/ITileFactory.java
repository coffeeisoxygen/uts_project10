package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;

public interface ITileFactory {
    Tile createTile(TileType type);

}
