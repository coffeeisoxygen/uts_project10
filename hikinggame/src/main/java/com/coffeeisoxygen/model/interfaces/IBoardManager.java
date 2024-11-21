package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.board.Board;

public interface IBoardManager {
    int getWidth();

    int getHeight();

    boolean isValidPosition(int x, int y);

    Board getBoard();
}