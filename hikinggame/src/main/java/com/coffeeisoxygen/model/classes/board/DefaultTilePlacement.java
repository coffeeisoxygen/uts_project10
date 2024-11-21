package com.coffeeisoxygen.model.classes.board;

import com.coffeeisoxygen.model.context.MapGeneratorContext;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.Coordinate;

public class DefaultTilePlacement implements IMapEditor {
    private ITileFactory tileFactory;
    private MapGeneratorContext mapGeneratorContext;

    public DefaultTilePlacement(ITileFactory tileFactory, MapGeneratorContext mapGeneratorContext) {
        this.tileFactory = tileFactory;
        this.mapGeneratorContext = mapGeneratorContext;
    }

    @Override
    public BoardRefactored createCustomMap(int rows, int cols) {
        IMapGenerator mapGenerator = mapGeneratorContext.getMapGenerator();
        TileManager tileManager = new TileManager(tileFactory);
        BoardRefactored board = new BoardRefactored(rows, cols, tileManager);

        if (mapGenerator != null) {
            return mapGenerator.generateMap(rows, cols);
        } else {
            // Default to a simple normal tile map if no generator is set
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    Tile normalTile = tileManager.createTile(TileType.NORMALPOINT, "Tile " + row + "," + col,
                            new Coordinate(row, col));
                    board.setTile(new Coordinate(row, col), normalTile);
                }
            }
            return board;
        }
    }
}