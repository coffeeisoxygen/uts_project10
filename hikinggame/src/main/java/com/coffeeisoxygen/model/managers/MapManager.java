package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.interfaces.ITileManager;
import com.coffeeisoxygen.model.util.Coordinate;

public class MapManager {
    private MapBoard mapBoard;
    private final ITileManager tileManager;
    private final IMapStrategy mapStrategy;

    public MapManager(ITileManager tileManager, IMapStrategy mapStrategy) {
        this.tileManager = tileManager;
        this.mapStrategy = mapStrategy;
    }

    public void createMap(String name, int rows, int cols) {
        this.mapBoard = mapStrategy.generateMap(name, rows, cols);
    }

    public Tile getTileAt(Coordinate position) {
        return mapBoard.getTile(position);
    }

    public boolean isValidPosition(Coordinate position) {
        return mapBoard.isValidPosition(position);
    }

    public void setTile(Coordinate position, Tile tile) {
        mapBoard.setTile(position, tile);
    }

    public void visualizeMap() {
        mapBoard.visualizeMap();
    }

    public Board getBoard() {
        return mapBoard.getBoard();
    }
}