package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;

public interface IMapStrategy {
    MapBoard generateMap(String name, int rows, int cols);

    void placeTiles(MapBoard mapBoard);
}