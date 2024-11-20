package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.util.Coordinate;

public class Game {
    private Board board;
    private Player player;
    private boolean isWinning;
    private char currentMove;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.isWinning = false;
    }

    public void executeMovementPlan(String plan) {
        player.executeMovementPlan(plan);
        PlayerState state = player.getState();

        while (state.isAlive()) {
            Coordinate position = state.getPosition();
            if (!board.isValidPosition(position)) {
                state.setAlive(false);
                System.out.println("Player moved out of bounds.");
                break;
            }

            Tile tile = board.getTile(position);
            tile.onPlayerStep(player, this);

            if (isWinning) {
                System.out.println("Congratulations! You won the game.");
                break;
            }

            if (state.getEnergy() <= 0) {
                System.out.println("Game over! You ran out of energy.");
                break;
            }
        }

        if (!state.isAlive()) {
            System.out.println("Game over! You lost.");
        }
    }

    public boolean isWinning() {
        return isWinning;
    }

    public void setWinning(boolean isWinning) {
        this.isWinning = isWinning;
    }

    public char getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(char currentMove) {
        this.currentMove = currentMove;
    }
}