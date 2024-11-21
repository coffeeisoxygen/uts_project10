package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.util.Coordinate;

public interface IMapManager {
    void createMaze(int rows, int cols);
    void createPercolation(int rows, int cols);
    void createSimpleBoard(int rows, int cols);
    Tile getTileAt(Coordinate position);
    boolean isValidPosition(Coordinate position);
    void setTile(Coordinate position, Tile tile);
    void visualizeMap();
    Board getBoard();
}