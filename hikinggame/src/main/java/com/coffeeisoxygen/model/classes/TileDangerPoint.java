package com.coffeeisoxygen.model.classes;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;

public class TileDangerPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileDangerPoint() {
        super("X", TileType.DANGERPOINT, Color.RED);
    }

    @Override
    public void onPlayerStep(Player player) {
        // Implementation for when a player steps on the danger point
    }
}