package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;

public interface IMapGenerator {
    MapBoard generateMap(int rows, int cols);
}