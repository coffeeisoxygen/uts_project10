package com.coffeeisoxygen.model.interfaces;

import java.util.List;

import com.coffeeisoxygen.model.classes.board.BoardRefactored;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;

public class MapManagerRefactored implements IMapManagerRefactored {
    private BoardRefactored board;
    private ITileManager tileManager;

    public MapManagerRefactored(BoardRefactored board, ITileManager tileManager) {
        this.board = board;
        this.tileManager = tileManager;
    }

    @Override
    public void setTile(Coordinate position, Tile tile) {
        board.setTile(position, tile);
    }

    @Override
    public Tile getTile(Coordinate position) {
        return board.getTile(position);
    }

    @Override
    public List<Tile> getAllTiles() {
        return board.getAllTiles();
    }

    @Override
    public void resetBoard(Tile defaultTile) {
        board.resetBoard(defaultTile);
    }

    @Override
    public boolean isValidPosition(Coordinate position) {
        return board.isValidPosition(position);
    }

    @Override
    public void visualizeBoard() {
        board.visualizeBoard();
    }

    @Override
    public Coordinate getFinishPosition() {
        return board.getFinishPosition();
    }

    public void createMaze(int rows, int cols) {
        board = new BoardRefactored(rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = (row == 0 && col == 0) ? TileType.STARTPOINT : TileType.NORMALPOINT;
                Tile tile = tileManager.createTile(type, "Tile " + row + "," + col, new Coordinate(row, col));
                board.setTile(new Coordinate(row, col), tile);
            }
        }
    }

    public void createPercolation(int rows, int cols) {
        board = new BoardRefactored(rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = (row == rows - 1 && col == cols - 1) ? TileType.FINISHPOINT : TileType.NORMALPOINT;
                Tile tile = tileManager.createTile(type, "Tile " + row + "," + col, new Coordinate(row, col));
                board.setTile(new Coordinate(row, col), tile);
            }
        }
    }

    public void createSimpleBoard(int rows, int cols) {
        board = new BoardRefactored(rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile tile = tileManager.createTile(TileType.NORMALPOINT, "Tile " + row + "," + col,
                        new Coordinate(row, col));
                board.setTile(new Coordinate(row, col), tile);
            }
        }
    }
}