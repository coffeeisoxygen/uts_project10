package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.strategies.MapGeneratorContext;
import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;
import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.IMapManager;
import com.coffeeisoxygen.model.interfaces.IMapSaver;
import com.coffeeisoxygen.model.interfaces.ITileManager;
import com.coffeeisoxygen.model.interfaces.ITilePlacementAlgorithm;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.util.TilePlacementUtils;

public class MapManager implements IMapManager {
    private MapBoard mapBoard;
    private ITileManager tileManager;
    private MapGeneratorContext mapGeneratorContext;
    private IMapLoader mapLoader;
    private IMapSaver mapSaver;
    private IMapEditor mapEditor;
    private ITilePlacementAlgorithm tilePlacementAlgorithm;

    public MapManager(ITileManager tileManager, MapGeneratorContext mapGeneratorContext, IMapLoader mapLoader,
            IMapSaver mapSaver, IMapEditor mapEditor, ITilePlacementAlgorithm tilePlacementAlgorithm) {
        this.tileManager = tileManager;
        this.mapGeneratorContext = mapGeneratorContext;
        this.mapLoader = mapLoader;
        this.mapSaver = mapSaver;
        this.mapEditor = mapEditor;
        this.tilePlacementAlgorithm = tilePlacementAlgorithm;
    }

    @Override
    public void createMap(int rows, int cols) {
        MapBoard board = mapGeneratorContext.generateMap(rows, cols);
        this.mapBoard = new MapBoard(board);
        tilePlacementAlgorithm.placeTiles(mapBoard);
    }

    @Override
    public void loadMap() {
        Board board = mapLoader.loadMap();
        this.mapBoard = new MapBoard(board);
    }

    @Override
    public void saveMap() {
        mapSaver.saveMap(mapBoard.getBoard());
    }

    @Override
    public void resetMap() {
        TilePlacementUtils.placeNormalTiles(tileManager, mapBoard);
    }

    @Override
    public Tile getTileAt(Coordinate position) {
        return mapBoard.getTile(position);
    }

    @Override
    public boolean isValidPosition(Coordinate position) {
        return mapBoard.isValidPosition(position);
    }

    @Override
    public void setTile(Coordinate position, Tile tile) {
        mapBoard.setTile(position, tile);
    }

    @Override
    public void visualizeMap() {
        mapBoard.visualizeMap();
    }

    @Override
    public Board getBoard() {
        return mapBoard.getBoard();
    }

    public void setMapGenerator(IMapGenerator mapGenerator) {
        mapGeneratorContext.setMapGenerator(mapGenerator);
    }
}