package com.coffeeisoxygen.model.util;

import com.coffeeisoxygen.model.interfaces.IMoveCommand;

public class Direction implements IMoveCommand {
    private Coordinate position;

    public Direction(Coordinate startPosition) {
        this.position = startPosition;
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public void moveLeft() {
        position = new Coordinate(position.getX() - 1, position.getY());
    }

    @Override
    public void moveRight() {
        position = new Coordinate(position.getX() + 1, position.getY());
    }

    @Override
    public void moveUp() {
        position = new Coordinate(position.getX(), position.getY() - 1);
    }

    @Override
    public void moveDown() {
        position = new Coordinate(position.getX(), position.getY() + 1);
    }

    @Override
    public void stopMove() {
        position = new Coordinate(position.getX(), position.getY());
        // meaning the player does not move

    }
}