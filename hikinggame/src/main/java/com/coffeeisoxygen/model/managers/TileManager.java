package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITileFactory;
import com.coffeeisoxygen.model.interfaces.ITileManager;
import com.coffeeisoxygen.model.util.Coordinate;

public class TileManager implements ITileManager {
    private ITileFactory tileFactory;

    public TileManager(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Tile createTile(TileType type, String name) {
        Tile tile = tileFactory.createTile(type);
        tile.setName(name);
        return tile;
    }

    @Override
    public Tile createTile(TileType type, String name, Coordinate position) {
        Tile tile = tileFactory.createTile(type);
        tile.setName(name);
        tile.setPosition(position);
        return tile;
    }

    @Override
    public void placeTile(Tile tile, Coordinate position) {
        tile.setPosition(position);
    }

    @Override
    public void resetTile(Coordinate position) {
        // // Assuming you have a way to access the mapBoard
        // Tile defaultTile = createTile(TileType.NORMALPOINT, "Normal", position);
        // MapBoard.setTile(position, defaultTile);
    }

    @Override
    public void changeTileType(Tile tile, TileType newType) {
        tile.setType(newType);
        tile.setColor(newType.getDefaultColor());
    }

    public static Tile createTile(ITileFactory tileFactory, TileType type, int row, int col) {
        Tile tile = tileFactory.createTile(type);
        tile.setPosition(new Coordinate(row, col));
        return tile;
    }

    public void reset() {
        // Assuming you have a way to access the mapBoard
        // for (int row = 0; row < MapBoard.getBoard().getHeight(); row++) {
        // for (int col = 0; col < MapBoard.getBoard().getWidth(); col++) {
        // Coordinate position = new Coordinate(col, row);
        // resetTile(position);
        // }
        // }
        // }
    }
}