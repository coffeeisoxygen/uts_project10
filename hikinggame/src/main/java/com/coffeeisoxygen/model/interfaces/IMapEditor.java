package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.BoardRefactored;

public interface IMapEditor {
    BoardRefactored createCustomMap(int rows, int cols);
}