package com.coffeeisoxygen.model.classes.board;

// TODO: fix percolation generator

// ![ ] define a way to generate a percolation map

import java.util.Random;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TileManager;

public class PercolationGenerator implements IMapGenerator {
    private final ITileFactory tileFactory;
    private final Random random = new Random();

    public PercolationGenerator(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Board generateMap(int rows, int cols) {
        Board board = new Board(rows, cols, tileFactory);
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = random.nextBoolean() ? TileType.NORMALPOINT : TileType.DANGERPOINT;
                Tile tile = TileManager.createTileWithPosition(tileFactory, type, row, col,
                        tileFactory.createTile(type).getName());
                board.setTile(new Coordinate(row, col), tile);
                visited[row][col] = type == TileType.NORMALPOINT;
            }
        }

        // Ensure there is a path from start to finish
        ensurePath(board, visited, rows, cols);

        // Set start and finish tiles
        board.setTile(new Coordinate(0, 0), TileManager.createTileWithPosition(tileFactory, TileType.STARTPOINT, 0, 0,
                tileFactory.createTile(TileType.STARTPOINT).getName()));
        board.setTile(new Coordinate(rows - 1, cols - 1), TileManager.createTileWithPosition(tileFactory,
                TileType.FINISHPOINT, rows - 1, cols - 1, tileFactory.createTile(TileType.FINISHPOINT).getName()));

        return board;
    }

    private void ensurePath(Board board, boolean[][] visited, int rows, int cols) {
        // Ensure there is a path from start to finish
        boolean[][] path = new boolean[rows][cols];
        if (findPath(0, 0, visited, path, rows, cols)) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (!path[row][col]) {
                        board.setTile(new Coordinate(row, col), TileManager.createTileWithPosition(tileFactory,
                                TileType.DANGERPOINT, row, col,
                                tileFactory.createTile(TileType.DANGERPOINT).getName()));
                    }
                }
            }
        }
    }

    private boolean findPath(int row, int col, boolean[][] visited, boolean[][] path, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || !visited[row][col] || path[row][col]) {
            return false;
        }
        path[row][col] = true;
        if (row == rows - 1 && col == cols - 1) {
            return true;
        }
        if (findPath(row + 1, col, visited, path, rows, cols) ||
                findPath(row - 1, col, visited, path, rows, cols) ||
                findPath(row, col + 1, visited, path, rows, cols) ||
                findPath(row, col - 1, visited, path, rows, cols)) {
            return true;
        }
        path[row][col] = false;
        return false;
    }
}