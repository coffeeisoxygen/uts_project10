package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.interfaces.IBoardManager;

public class BoardManager implements IBoardManager {
    private Board board;

    public BoardManager(Board board) {
        this.board = board;
    }

    @Override
    public int getWidth() {
        return board.getWidth();
    }

    @Override
    public int getHeight() {
        return board.getHeight();
    }

    @Override
    public boolean isValidPosition(int x, int y) {
        return board.isValidPosition(x, y);
    }

    @Override
    public Board getBoard() {
        return board;
    }
}