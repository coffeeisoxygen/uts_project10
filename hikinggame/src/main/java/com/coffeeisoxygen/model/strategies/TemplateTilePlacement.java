package com.coffeeisoxygen.model.strategies;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITilePlacementAlgorithm;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class TemplateTilePlacement implements ITilePlacementAlgorithm {
    private final TileManager tileManager;
    private final int rows = 6;
    private final int cols = 12;

    public TemplateTilePlacement(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    @Override
    public void placeTiles(MapBoard mapBoard) {
        // Step 1: Create all tiles as normal tiles
        TilePlacementUtils.placeNormalTiles(tileManager, mapBoard);

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
            Coordinate position = new Coordinate(pos[0], pos[1]);
            Tile dangerTile = tileManager.createTile(TileType.DANGERPOINT, "X", position);
            mapBoard.setTile(position, dangerTile);
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
            Coordinate position = new Coordinate(pos[0], pos[1]);
            Tile checkpointTile = tileManager.createTile(TileType.CHECKPOINT, name, position);
            mapBoard.setTile(position, checkpointTile);
        }

        // Step 4: Place start and finish tiles
        mapBoard.setTile(new Coordinate(0, 0),
                tileManager.createTile(TileType.FINISHPOINT, "Finish", new Coordinate(0, 0)));
        mapBoard.setTile(new Coordinate(rows - 1, cols - 1),
                tileManager.createTile(TileType.STARTPOINT, "Start", new Coordinate(rows - 1, cols - 1)));
    }
}