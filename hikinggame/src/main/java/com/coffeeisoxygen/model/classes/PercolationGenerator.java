package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TileManager;

import java.util.Random;

public class PercolationGenerator implements IMapGenerator {
    private final ITileFactory tileFactory;
    private final Random random = new Random();

    public PercolationGenerator(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Board generateMap(int rows, int cols) {
        Board board = new Board(rows, cols, tileFactory);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = random.nextBoolean() ? TileType.NORMALPOINT : TileType.DANGERPOINT;
                Tile tile = TileManager.createTileWithPosition(tileFactory, type, row, col, type == TileType.NORMALPOINT ? "N" : "X");
                board.setTile(new Coordinate(row, col), tile);
            }
        }

        // Set start and finish tiles
        board.setTile(new Coordinate(0, 0), TileManager.createTileWithPosition(tileFactory, TileType.STARTPOINT, 0, 0, "Start"));
        board.setTile(new Coordinate(rows - 1, cols - 1), TileManager.createTileWithPosition(tileFactory, TileType.FINISHPOINT, rows - 1, cols - 1, "Finish"));

        return board;
    }
}