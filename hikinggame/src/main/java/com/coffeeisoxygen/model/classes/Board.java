package com.coffeeisoxygen.model.classes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IBoardManager;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;

public class Board implements IBoardManager, Serializable {
    private static final long serialVersionUID = 1L;

    private final int rows;
    private final int cols;
    private final Tile[][] tiles;
    private final PropertyChangeSupport support;
    private transient ITileFactory tileFactory;

    public Board(int rows, int cols, ITileFactory tileFactory) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[rows][cols];
        this.support = new PropertyChangeSupport(this);
        this.tileFactory = tileFactory;
        initializeBoard();
    }

    private void initializeBoard() {
        Tile defaultTile = tileFactory.createTile(TileType.NORMALPOINT);
        resetBoard(defaultTile);
    }

    @Override
    public void resetBoard(Tile defaultTile) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile newTile = tileFactory.createTile(defaultTile.getType());
                newTile.setPosition(new Coordinate(row, col));
                setTile(new Coordinate(row, col), newTile);
            }
        }
        support.firePropertyChange("boardReset", null, null);
    }

    @Override
    public List<Tile> getAllTiles() {
        List<Tile> tileList = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (tiles[row][col] != null) {
                    tileList.add(tiles[row][col]);
                }
            }
        }
        return tileList;
    }

    @Override
    public boolean isValidPosition(Coordinate position) {
        return position.getX() >= 0 && position.getX() < rows &&
                position.getY() >= 0 && position.getY() < cols;
    }

    private void validatePosition(Coordinate position) {
        if (!isValidPosition(position)) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    @Override
    public void setTile(Coordinate position, Tile tile) {
        validatePosition(position);
        tiles[position.getX()][position.getY()] = tile;
        support.firePropertyChange("tileSet", null, tile);
    }

    @Override
    public Tile getTile(Coordinate position) {
        validatePosition(position);
        return tiles[position.getX()][position.getY()];
    }

    @Override
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.tileFactory = new TileFactory(); // Reinitialize the tileFactory after deserialization
    }
}