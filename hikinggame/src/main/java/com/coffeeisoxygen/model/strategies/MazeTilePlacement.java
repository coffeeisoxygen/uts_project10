package com.coffeeisoxygen.model.strategies;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITilePlacementAlgorithm;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class MazeTilePlacement implements ITilePlacementAlgorithm {
    private final TileManager tileManager;

    public MazeTilePlacement(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    @Override
    public void placeTiles(MapBoard mapBoard) {
        TilePlacementUtils.placeNormalTiles(tileManager, mapBoard);

        // Generate a maze using DFS
        int rows = mapBoard.getBoard().getHeight();
        int cols = mapBoard.getBoard().getWidth();
        int[][] grid = new int[rows][cols];
        int currentRow = 0;
        int currentCol = 0;

        // Initialize the grid (all cells are walls)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = 1; // 1 represents a wall
            }
        }

        // Start DFS from a random cell
        grid[currentRow][currentCol] = 0; // Mark the starting cell as visited
        generateMazeDFS(grid, currentRow, currentCol);

        // Place tiles on the map based on the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinate position = new Coordinate(i, j);
                if (grid[i][j] == 1) {
                    mapBoard.setTile(position, tileManager.createTile(TileType.DANGERPOINT, "Wall", position));
                }
            }
        }

        // Place start and finish tiles
        mapBoard.setTile(new Coordinate(0, 0),
                tileManager.createTile(TileType.STARTPOINT, "Start", new Coordinate(0, 0)));
        mapBoard.setTile(new Coordinate(mapBoard.getBoard().getHeight() - 1, mapBoard.getBoard().getWidth() - 1),
                tileManager.createTile(TileType.FINISHPOINT, "Finish",
                        new Coordinate(mapBoard.getBoard().getHeight() - 1, mapBoard.getBoard().getWidth() - 1)));
    }

    private void generateMazeDFS(int[][] grid, int row, int col) {
        int[] dr = { 0, 1, 0, -1 }; // Directions: down, right, up, left
        int[] dc = { 1, 0, -1, 0 };

        int rows = grid.length;
        int cols = grid[0].length;


        // Iterate over all possible directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            // Check if the new cell is within bounds and unvisited
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                // Carve a passage between the current cell and the new cell
                grid[newRow][newCol] = 0;
                generateMazeDFS(grid, newRow, newCol);
            }
        }
    }
}
