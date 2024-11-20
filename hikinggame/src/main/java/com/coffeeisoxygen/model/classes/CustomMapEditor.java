package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TileManager;

public class CustomMapEditor implements IMapEditor {
    private final ITileFactory tileFactory;

    public CustomMapEditor(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Board createCustomMap(int rows, int cols) {
        Board board = new Board(rows, cols, tileFactory);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Tile normalTile = TileManager.createTileWithPosition(tileFactory, TileType.NORMALPOINT, row, col, "N");
                board.setTile(new Coordinate(row, col), normalTile);
            }
        }
        return board;
    }
}