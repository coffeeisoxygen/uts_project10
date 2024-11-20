package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.util.Coordinate;

public class PlayerState {
    private int energy;
    private Coordinate position;
    private boolean isAlive;

    public PlayerState(int energy, Coordinate position) {
        this.energy = energy;
        this.position = position;
        this.isAlive = true;
    }

    public int getEnergy() {
        return energy;
    }

    public void addEnergy(int energy) {
        this.energy += energy;
    }

    public void reduceEnergy(int energy) {
        this.energy -= energy;
        if (this.energy <= 0) {
            this.energy = 0;
            this.isAlive = false;
        }
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}