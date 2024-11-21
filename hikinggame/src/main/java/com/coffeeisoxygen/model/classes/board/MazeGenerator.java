package com.coffeeisoxygen.model.classes.board;
// TODO: fix maze generator

// ![ ] define a way to generate a maze

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TileManager;

public class MazeGenerator implements IMapGenerator {
    private final ITileFactory tileFactory;

    public MazeGenerator(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Board generateMap(int rows, int cols) {
        Board board = new Board(rows, cols, tileFactory);
        boolean[][] visited = new boolean[rows][cols];
        Stack<Coordinate> stack = new Stack<>();
        Coordinate start = new Coordinate(0, 0);
        stack.push(start);
        visited[start.getX()][start.getY()] = true;

        while (!stack.isEmpty()) {
            Coordinate current = stack.peek();
            Coordinate next = getNextUnvisitedNeighbor(current, visited, rows, cols);

            if (next != null) {
                stack.push(next);
                visited[next.getX()][next.getY()] = true;
                board.setTile(next, TileManager.createTileWithPosition(tileFactory, TileType.NORMALPOINT, next.getX(),
                        next.getY(), "N"));
            } else {
                stack.pop();
            }
        }

        // Ensure there is a path from start to finish
        ensurePath(board, visited, rows, cols);

        // Set start and finish tiles
        board.setTile(new Coordinate(0, 0),
                TileManager.createTileWithPosition(tileFactory, TileType.STARTPOINT, 0, 0, "Start"));
        board.setTile(new Coordinate(rows - 1, cols - 1),
                TileManager.createTileWithPosition(tileFactory, TileType.FINISHPOINT, rows - 1, cols - 1, "Finish"));

        return board;
    }

    private Coordinate getNextUnvisitedNeighbor(Coordinate current, boolean[][] visited, int rows, int cols) {
        int x = current.getX();
        int y = current.getY();
        Coordinate[] neighbors = {
                new Coordinate(x - 1, y),
                new Coordinate(x + 1, y),
                new Coordinate(x, y - 1),
                new Coordinate(x, y + 1)
        };
        Collections.shuffle(Arrays.asList(neighbors));

        for (Coordinate neighbor : neighbors) {
            if (isValidPosition(neighbor, visited, rows, cols)) {
                return neighbor;
            }
        }
        return null;
    }

    private boolean isValidPosition(Coordinate position, boolean[][] visited, int rows, int cols) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y];
    }

    private void ensurePath(Board board, boolean[][] visited, int rows, int cols) {
        // Ensure there is a path from start to finish
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col]) {
                    board.setTile(new Coordinate(row, col),
                            TileManager.createTileWithPosition(tileFactory, TileType.DANGERPOINT, row, col, "X"));
                }
            }
        }
    }
}