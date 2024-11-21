package com.coffeeisoxygen.model.classes.board;

import com.coffeeisoxygen.model.interfaces.IMapGenerator;

public class MapGeneratorContext {
    private IMapGenerator mapGenerator;

    public void setMapGenerator(IMapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    public IMapGenerator getMapGenerator() {
        return mapGenerator;
    }
}