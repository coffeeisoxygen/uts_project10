package com.coffeeisoxygen.model.interfaces;

import java.util.List;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.util.Coordinate;

public interface IMapManagerRefactored {
    void setTile(Coordinate position, Tile tile);

    Tile getTile(Coordinate position);

    List<Tile> getAllTiles();

    void resetBoard(Tile defaultTile);

    boolean isValidPosition(Coordinate position);

    void visualizeBoard();

    Coordinate getFinishPosition();
}