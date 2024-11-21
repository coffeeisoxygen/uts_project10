package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapManager;
import com.coffeeisoxygen.model.interfaces.ITileManager;
import com.coffeeisoxygen.model.util.Coordinate;

public class MapManager implements IMapManager {
    private BoardManager boardManager;
    private ITileManager tileManager;

    public MapManager(Board board, ITileManager tileManager) {
        this.boardManager = new BoardManager(board);
        this.tileManager = tileManager;
    }

    @Override
    public void createMaze(int rows, int cols) {
        Board board = new Board(rows, cols);
        boardManager = new BoardManager(board);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = (row == 0 && col == 0) ? TileType.STARTPOINT : TileType.NORMALPOINT;
                Tile tile = tileManager.createTile(type, "Tile " + row + "," + col, new Coordinate(row, col));
                setTile(new Coordinate(row, col), tile);
            }
        }
    }

    @Override
    public void createPercolation(int rows, int cols) {
        Board board = new Board(rows, cols);
        boardManager = new BoardManager(board);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = (row == rows - 1 && col == cols - 1) ? TileType.FINISHPOINT : TileType.NORMALPOINT;
                Tile tile = tileManager.createTile(type, "Tile " + row + "," + col, new Coordinate(row, col));
                setTile(new Coordinate(row, col), tile);
            }
        }
    }

    @Override
    public void createSimpleBoard(int rows, int cols) {
        Board board = new Board(rows, cols);
        boardManager = new BoardManager(board);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile tile = tileManager.createTile(TileType.NORMALPOINT, "Tile " + row + "," + col, new Coordinate(row, col));
                setTile(new Coordinate(row, col), tile);
            }
        }
    }

    @Override
    public Tile getTileAt(Coordinate position) {
        return boardManager.getBoard().getTile(position);
    }

    @Override
    public boolean isValidPosition(Coordinate position) {
        return boardManager.isValidPosition(position.getX(), position.getY());
    }

    @Override
    public void setTile(Coordinate position, Tile tile) {
        boardManager.getBoard().setTile(position, tile);
    }

    @Override
    public void visualizeMap() {
        boardManager.getBoard().visualizeBoard();
    }

    @Override
    public Board getBoard() {
        return boardManager.getBoard();
    }
}