package com.coffeeisoxygen.model.context;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.interfaces.IMapGenerator;

public class MapGeneratorContext {
    private IMapGenerator mapGenerator;

    public void setMapGenerator(IMapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    public IMapGenerator getMapGenerator() {
        return mapGenerator;
    }

    public MapBoard generateMap(int rows, int cols) {
        if (mapGenerator == null) {
            throw new IllegalStateException("MapGenerator is not set");
        }
        return mapGenerator.generateMap(rows, cols);
    }
}