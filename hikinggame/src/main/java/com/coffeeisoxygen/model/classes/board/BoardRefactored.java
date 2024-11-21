package com.coffeeisoxygen.model.classes.board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.util.Coordinate;

public class BoardRefactored implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int rows;
    private final int cols;
    private final Map<Coordinate, Tile> tiles;

    public BoardRefactored(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new HashMap<>();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Map<Coordinate, Tile> getTiles() {
        return tiles;
    }

    public void setTile(Coordinate position, Tile tile) {
        validatePosition(position);
        tiles.put(position, tile);
    }

    public Tile getTile(Coordinate position) {
        validatePosition(position);
        return tiles.get(position);
    }

    public List<Tile> getAllTiles() {
        return new ArrayList<>(tiles.values());
    }

    public void resetBoard(Tile defaultTile) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile newTile = new Tile(defaultTile.getName(), defaultTile.getType(), defaultTile.getColor());
                newTile.setPosition(new Coordinate(row, col));
                setTile(new Coordinate(row, col), newTile);
            }
        }
    }

    public boolean isValidPosition(Coordinate position) {
        return position.getX() >= 0 && position.getX() < rows &&
                position.getY() >= 0 && position.getY() < cols;
    }

    private void validatePosition(Coordinate position) {
        if (!isValidPosition(position)) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    public void visualizeBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile tile = getTile(new Coordinate(row, col));
                switch (tile.getType()) {
                    case STARTPOINT:
                        System.out.print("S ");
                        break;
                    case FINISHPOINT:
                        System.out.print("F ");
                        break;
                    case DANGERPOINT:
                        System.out.print("X ");
                        break;
                    case CHECKPOINT:
                        System.out.print("C ");
                        break;
                    case NORMALPOINT:
                    default:
                        System.out.print("N ");
                        break;
                }
            }
            System.out.println();
        }
    }

    public Coordinate getFinishPosition() {
        for (Tile tile : tiles.values()) {
            if (tile.getType() == TileType.FINISHPOINT) {
                return tile.getPosition();
            }
        }
        return null;
    }
}