package com.coffeeisoxygen.model.util;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.managers.TileManager;

public class TemplateLoader {
    public static void loadTemplate(TileManager tileManager, MapBoard mapBoard,
            int[][] dangerPositions,
            int[][] checkpointPositions,
            int[][] startPositions,
            int[][] endPositions) {
        // Step 1: Create all tiles as normal tiles
        TilePlacementUtils.placeDefaultTiles(tileManager, mapBoard);

        // Step 2: Place danger tiles
        for (int[] pos : dangerPositions) {
            Coordinate position = new Coordinate(pos[0], pos[1]);
            Tile tile = tileManager.createTile(TileType.DANGERPOINT, "Danger", position);
            mapBoard.setTile(position, tile);
        }

        // Step 3: Place checkpoint tiles
        String[] checkpointNames = {
                "Checkpoint 1", "Checkpoint 2", "Checkpoint 3", "Checkpoint 4", "Checkpoint 5", "Checkpoint 6"
        };
        for (int i = 0; i < checkpointPositions.length; i++) {
            int[] pos = checkpointPositions[i];
            String name = checkpointNames[i];
            Coordinate position = new Coordinate(pos[0], pos[1]);
            Tile tile = tileManager.createTile(TileType.CHECKPOINT, name, position);
            mapBoard.setTile(position, tile);
        }

        // Step 4: Place start tiles
        for (int[] pos : startPositions) {
            Coordinate position = new Coordinate(pos[0], pos[1]);
            Tile tile = tileManager.createTile(TileType.STARTPOINT, "Start", position);
            mapBoard.setTile(position, tile);
        }

        // Step 5: Place end tiles
        for (int[] pos : endPositions) {
            Coordinate position = new Coordinate(pos[0], pos[1]);
            Tile tile = tileManager.createTile(TileType.FINISHPOINT, "Finish", position);
            mapBoard.setTile(position, tile);
        }
    }
}