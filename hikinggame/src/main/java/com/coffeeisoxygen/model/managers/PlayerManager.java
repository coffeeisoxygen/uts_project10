package com.coffeeisoxygen.model.managers;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.util.Direction;

public class PlayerManager {
    private Player player;
    private Direction direction;

    public PlayerManager(Player player) {
        this.player = player;
        this.direction = new Direction(player.getPosition());
    }

    public void moveLeft() {
        if (player.getEnergy() > 0) {
            direction.moveLeft();
            player.setPosition(direction.getPosition());
            player.setEnergy(player.getEnergy() - 1);
        } else {
            System.out.println("Not enough energy to move left.");
        }
    }

    public void moveRight() {
        if (player.getEnergy() > 0) {
            direction.moveRight();
            player.setPosition(direction.getPosition());
            player.setEnergy(player.getEnergy() - 1);
        } else {
            System.out.println("Not enough energy to move right.");
        }
    }

    public void moveUp() {
        if (player.getEnergy() > 0) {
            direction.moveUp();
            player.setPosition(direction.getPosition());
            player.setEnergy(player.getEnergy() - 1);
        } else {
            System.out.println("Not enough energy to move up.");
        }
    }

    public void moveDown() {
        if (player.getEnergy() > 0) {
            direction.moveDown();
            player.setPosition(direction.getPosition());
            player.setEnergy(player.getEnergy() - 1);
        } else {
            System.out.println("Not enough energy to move down.");
        }
    }

    public void dontMove() {
        if (player.getEnergy() > 0) {
            direction.stopMove();
            player.setPosition(direction.getPosition());
            player.setEnergy(player.getEnergy() - 1);
        } else {
            System.out.println("Not enough energy to stay still.");
        }
    }

    public void executeMovementPlan(String plan) {
        for (char move : plan.toCharArray()) {
            switch (Character.toUpperCase(move)) {
                case 'U' -> moveUp();
                case 'D' -> moveDown();
                case 'L' -> moveLeft();
                case 'R' -> moveRight();
                case 'S' -> dontMove();
                default -> throw new IllegalArgumentException("Invalid move: " + move);
            }
        }
    }

    public void handleKeyPress(char key) {
        switch (Character.toUpperCase(key)) {
            case 'U' -> moveUp();
            case 'D' -> moveDown();
            case 'L' -> moveLeft();
            case 'R' -> moveRight();
            case 'S' -> dontMove();
            default -> System.out.println("Invalid key: " + key);
        }
    }
}