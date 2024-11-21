package com.coffeeisoxygen.model.classes.board;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TileManager;

public class DefaultMapLoader implements IMapLoader {
    private final ITileFactory tileFactory;
    private final int rows = 6;
    private final int cols = 12;

    public DefaultMapLoader(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Board loadMap() {
        return getDefaultTileLayout();
    }

    private Board getDefaultTileLayout() {
        Board board = new Board(rows, cols, tileFactory);

        // Step 1: Create all tiles as normal tiles
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile normalTile = TileManager.createTileWithPosition(tileFactory, TileType.NORMALPOINT, row, col, "N");
                board.setTile(new Coordinate(row, col), normalTile);
            }
        }

        // Step 2: Place danger tiles
        int[][] dangerPositions = {
                { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0, 6 }, { 0, 7 }, { 0, 8 },
                { 1, 1 }, { 1, 5 }, { 1, 6 }, { 1, 8 }, { 1, 10 },
                { 2, 1 }, { 2, 2 }, { 2, 3 }, { 2, 10 },
                { 3, 5 }, { 3, 8 }, { 3, 9 }, { 3, 10 },
                { 4, 2 }, { 4, 5 }, { 4, 7 }, { 4, 8 }, { 4, 9 }, { 4, 10 },
                { 5, 2 }
        };
        for (int[] pos : dangerPositions) {
            board.setTile(new Coordinate(pos[0], pos[1]),
                    TileManager.createTileWithPosition(tileFactory, TileType.DANGERPOINT, pos[0], pos[1], "X"));
        }

        // Step 3: Place checkpoint tiles
        int[][] checkpointPositions = {
                { 1, 7 }, { 2, 5 }, { 3, 1 }, { 4, 6 }, { 5, 0 }, { 5, 3 }
        };
        String[] checkpointNames = {
                "Checkpoint 1", "Checkpoint 2", "Checkpoint 3", "Checkpoint 4", "Checkpoint 5", "Checkpoint 6"
        };
        for (int i = 0; i < checkpointPositions.length; i++) {
            int[] pos = checkpointPositions[i];
            String name = checkpointNames[i];
            board.setTile(new Coordinate(pos[0], pos[1]),
                    TileManager.createTileWithPosition(tileFactory, TileType.CHECKPOINT, pos[0], pos[1], name));
        }

        // Step 4: Place start and finish tiles
        board.setTile(new Coordinate(0, 0),
                TileManager.createTileWithPosition(tileFactory, TileType.FINISHPOINT, 0, 0, "Finish"));
        board.setTile(new Coordinate(rows - 1, cols - 1),
                TileManager.createTileWithPosition(tileFactory, TileType.STARTPOINT, rows - 1, cols - 1, "Start"));

        return board;
    }
}