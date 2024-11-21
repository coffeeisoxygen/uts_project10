package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.Board;

public interface IMapGenerator {
    Board generateMap(int rows, int cols);
}