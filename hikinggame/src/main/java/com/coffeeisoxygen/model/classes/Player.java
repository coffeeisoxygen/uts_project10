package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.util.Coordinate;

public class Player {
    private String name;
    private PlayerState state;
    private StringMovable stringMovable;

    public Player(String name, int energy, Coordinate position) {
        this.name = name;
        this.state = new PlayerState(energy, position);
        this.stringMovable = new StringMovable(this);
    }

    public String getName() {
        return name;
    }

    public PlayerState getState() {
        return state;
    }

    public void executeMovementPlan(String plan) {
        stringMovable.executeMovementPlan(plan);
    }
}