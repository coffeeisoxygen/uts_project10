package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;

public interface IMapEditor {
    MapBoard createCustomMap(int rows, int cols);
}