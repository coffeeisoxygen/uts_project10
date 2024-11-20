package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.Board;

public interface IMapGenerator {
    Board generateMap(int rows, int cols);
}