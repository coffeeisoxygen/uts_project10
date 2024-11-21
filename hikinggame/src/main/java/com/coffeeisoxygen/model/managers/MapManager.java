package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.IMapManager;
import com.coffeeisoxygen.model.interfaces.IMapSaver;
import com.coffeeisoxygen.model.interfaces.ITileManager;
import com.coffeeisoxygen.model.util.Coordinate;

public class MapManager implements IMapManager {
    private MapBoard map;
    private ITileManager tileManager;
    private IMapGenerator mapGenerator;
    private IMapLoader mapLoader;
    private IMapSaver mapSaver;
    private IMapEditor mapEditor;

    public MapManager(ITileManager tileManager, IMapGenerator mapGenerator, IMapLoader mapLoader, IMapSaver mapSaver,
            IMapEditor mapEditor) {
        this.tileManager = tileManager;
        this.mapGenerator = mapGenerator;
        this.mapLoader = mapLoader;
        this.mapSaver = mapSaver;
        this.mapEditor = mapEditor;
    }

    @Override
    public void createMap(int rows, int cols) {
        Board board = mapGenerator.generateMap(rows, cols);
        this.map = new MapBoard(board);
    }

    @Override
    public void loadMap() {
        Board board = mapLoader.loadMap();
        this.map = new MapBoard(board);
    }

    @Override
    public void saveMap() {
        mapSaver.saveMap(map.getBoard());
    }

    @Override
    public void resetMap() {
        Board board = mapEditor.createCustomMap(map.getBoard().getHeight(), map.getBoard().getWidth());
        this.map = new MapBoard(board);
    }

    @Override
    public Tile getTileAt(Coordinate position) {
        return map.getTile(position);
    }

    @Override
    public boolean isValidPosition(Coordinate position) {
        return map.isValidPosition(position);
    }

    @Override
    public void setTile(Coordinate position, Tile tile) {
        map.setTile(position, tile);
    }

    @Override
    public void visualizeMap() {
        map.visualizeMap();
    }

    @Override
    public Board getBoard() {
        return map.getBoard();
    }
}