package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.interfaces.IMovement;
import com.coffeeisoxygen.model.interfaces.IAction;

public class StringMovable implements IMovement, IAction {
    private Player player;

    public StringMovable(Player player) {
        this.player = player;
    }

    @Override
    public void moveLeft() {
        PlayerState state = player.getState();
        if (state.getEnergy() > 0) {
            state.getPosition().setX(state.getPosition().getX() - 1);
            state.reduceEnergy(1);
        } else {
            System.out.println("Not enough energy to move left.");
        }
    }

    @Override
    public void moveRight() {
        PlayerState state = player.getState();
        if (state.getEnergy() > 0) {
            state.getPosition().setX(state.getPosition().getX() + 1);
            state.reduceEnergy(1);
        } else {
            System.out.println("Not enough energy to move right.");
        }
    }

    @Override
    public void moveUp() {
        PlayerState state = player.getState();
        if (state.getEnergy() > 0) {
            state.getPosition().setY(state.getPosition().getY() - 1);
            state.reduceEnergy(1);
        } else {
            System.out.println("Not enough energy to move up.");
        }
    }

    @Override
    public void moveDown() {
        PlayerState state = player.getState();
        if (state.getEnergy() > 0) {
            state.getPosition().setY(state.getPosition().getY() + 1);
            state.reduceEnergy(1);
        } else {
            System.out.println("Not enough energy to move down.");
        }
    }

    @Override
    public void stay() {
        PlayerState state = player.getState();
        if (state.getEnergy() > 0) {
            state.reduceEnergy(1);
        } else {
            System.out.println("Not enough energy to stay.");
        }
    }

    public void executeMovementPlan(String plan) {
        for (char move : plan.toCharArray()) {
            switch (move) {
                case 'L' -> moveLeft();
                case 'R' -> moveRight();
                case 'U' -> moveUp();
                case 'D' -> moveDown();
                case 'S' -> stay();
                default -> throw new IllegalArgumentException("Invalid move: " + move);
            }
        }
    }
}