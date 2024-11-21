package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.Board;

public interface IMapEditor {
    Board createCustomMap(int rows, int cols);
}