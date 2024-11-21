package com.coffeeisoxygen.model.classes.board;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TileManager;

public class CustomMapEditor implements IMapEditor {
    private final ITileFactory tileFactory;
    private final MapGeneratorContext mapGeneratorContext;

    public CustomMapEditor(ITileFactory tileFactory, MapGeneratorContext mapGeneratorContext) {
        this.tileFactory = tileFactory;
        this.mapGeneratorContext = mapGeneratorContext;
    }

    @Override
    public Board createCustomMap(int rows, int cols) {
        IMapGenerator mapGenerator = mapGeneratorContext.getMapGenerator();
        if (mapGenerator != null) {
            return mapGenerator.generateMap(rows, cols);
        } else {
            // Default to a simple normal tile map if no generator is set
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
}