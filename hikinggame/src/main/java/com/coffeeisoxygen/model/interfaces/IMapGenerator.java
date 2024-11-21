package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.BoardRefactored;

public interface IMapGenerator {
    BoardRefactored generateMap(int rows, int cols);
}