package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.interfaces.IMapStrategy;
import com.coffeeisoxygen.model.managers.TileManager;

public class TemplateMapStrategy implements IMapStrategy {
    private final TileManager tileManager;
    private final TemplateData templateData;

    public TemplateMapStrategy(TileManager tileManager, TemplateData templateData) {
        this.tileManager = tileManager;
        this.templateData = templateData;
    }

    @Override
    public MapBoard generateMap(String name, int rows, int cols) {
        MapBoard mapBoard = new MapBoard(templateData.name, templateData.rows, templateData.cols);
        placeTiles(mapBoard);
        return mapBoard;
    }

    @Override
    public void placeTiles(MapBoard mapBoard) {
        TemplateLoader.loadTemplate(tileManager, mapBoard,
                templateData.dangerPositions,
                templateData.checkpoints,
                templateData.startPositions,
                templateData.endPositions);
    }
}