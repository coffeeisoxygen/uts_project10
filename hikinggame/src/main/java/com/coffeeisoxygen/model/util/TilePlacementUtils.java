package com.coffeeisoxygen.model.util;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.managers.TileManager;

public class TilePlacementUtils {
    public static void placeDefaultTiles(TileManager tileManager, MapBoard mapBoard) {
        for (int row = 0; row < mapBoard.getBoard().getHeight(); row++) {
            for (int col = 0; col < mapBoard.getBoard().getWidth(); col++) {
                Coordinate position = new Coordinate(col, row); // Swap row and col
                Tile tile = tileManager.createTile(TileType.NORMALPOINT, "Normal", position);
                mapBoard.setTile(position, tile);
            }
        }
    }
}