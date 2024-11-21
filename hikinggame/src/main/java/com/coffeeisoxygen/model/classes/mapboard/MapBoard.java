package com.coffeeisoxygen.model.classes.mapboard;

import java.io.Serializable;
import java.util.HashMap;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.util.Coordinate;

public class MapBoard implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Board board;
    private final Tile[][] tiles;
    private final HashMap<Coordinate, Tile> tileAttributes;

    public MapBoard(Board board) {
        this.board = board;
        this.tiles = new Tile[board.getHeight()][board.getWidth()];
        this.tileAttributes = new HashMap<>();
    }

    public  Board getBoard() {
        return board;
    }

    public void setTile(Coordinate position, Tile tile) {
        if (board.isValidPosition(position.getX(), position.getY())) {
            tiles[position.getY()][position.getX()] = tile;
            tileAttributes.put(position, tile);
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    public Tile getTile(Coordinate position) {
        if (board.isValidPosition(position.getX(), position.getY())) {
            return tiles[position.getY()][position.getX()];
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    public Tile getTileAttributes(Coordinate position) {
        return tileAttributes.get(position);
    }

    public boolean isValidPosition(Coordinate position) {
        return board.isValidPosition(position.getX(), position.getY());
    }

    public void visualizeMap() {
        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                Tile tile = tiles[row][col];
                if (tile != null) {
                    System.out.print(tile.getName() + " ");
                } else {
                    System.out.print("Empty ");
                }
            }
            System.out.println();
        }
    }
}