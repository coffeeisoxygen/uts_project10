package com.coffeeisoxygen.model.classes;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;

public class TileStartPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileStartPoint() {
        super("S", TileType.STARTPOINT, Color.BLUE);
    }

    @Override
    public void onPlayerStep(Player player) {
        // Implementation for when a player steps on the start point
    }
}