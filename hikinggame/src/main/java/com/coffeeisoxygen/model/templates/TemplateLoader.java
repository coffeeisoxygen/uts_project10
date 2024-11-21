package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class TemplateLoader {
    public static void loadTemplate(TileManager tileManager, MapBoard mapBoard,
            int[][] dangerPositions,
            TemplateData.Checkpoint[] checkpoints,
            int[][] startPositions,
            int[][] endPositions) {
        // Print map dimensions
        System.out.println("Map dimensions: " + mapBoard.getBoard().getHeight() + " rows, "
                + mapBoard.getBoard().getWidth() + " cols");

        // Step 1: Create all tiles as normal tiles
        TilePlacementUtils.placeDefaultTiles(tileManager, mapBoard);
        // debuging only
        System.out.println("Default tiles placed");
        mapBoard.visualizeMap();
        // remove after debugging
        // ? [ ] Mark:

        // Step 2: Place danger tiles
        for (int[] pos : dangerPositions) {
            Coordinate position = new Coordinate(pos[0], pos[1]);
            System.out.println("Setting danger position: " + position);
            if (!mapBoard.isValidPosition(position)) {
                System.err.println("Invalid danger position: " + position);
                continue;
            }
            Tile tile = tileManager.createTile(TileType.DANGERPOINT, "Danger", position);
            mapBoard.setTile(position, tile);
        }

        // Step 3: Place checkpoint tiles
        for (TemplateData.Checkpoint checkpoint : checkpoints) {
            Coordinate position = new Coordinate(checkpoint.position[0], checkpoint.position[1]);
            System.out.println("Setting checkpoint position: " + position);
            if (!mapBoard.isValidPosition(position)) {
                System.err.println("Invalid checkpoint position: " + position);
                continue;
            }
            Tile tile = tileManager.createTile(TileType.CHECKPOINT, checkpoint.name, position);
            mapBoard.setTile(position, tile);
        }

        // Step 4: Place start tiles
        for (int[] pos : startPositions) {
            Coordinate position = new Coordinate(pos[0], pos[1]);
            System.out.println("Setting start position: " + position);
            if (!mapBoard.isValidPosition(position)) {
                System.err.println("Invalid start position: " + position);
                continue;
            }
            Tile tile = tileManager.createTile(TileType.STARTPOINT, "Start", position);
            mapBoard.setTile(position, tile);
        }

        // Step 5: Place end tiles
        for (int[] pos : endPositions) {
            Coordinate position = new Coordinate(pos[0], pos[1]);
            System.out.println("Setting end position: " + position);
            if (!mapBoard.isValidPosition(position)) {
                System.err.println("Invalid end position: " + position);
                continue;
            }
            Tile tile = tileManager.createTile(TileType.FINISHPOINT, "Finish", position);
            mapBoard.setTile(position, tile);
        }
    }
}