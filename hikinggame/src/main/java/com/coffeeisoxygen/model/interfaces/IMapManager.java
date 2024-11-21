package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.util.Coordinate;

public interface IMapManager {
    void createMap(int rows, int cols);

    void loadMap();

    void saveMap();

    void resetMap();

    Tile getTileAt(Coordinate position);

    boolean isValidPosition(Coordinate position);

    void setTile(Coordinate position, Tile tile);

    void visualizeMap();

    Board getBoard();
}