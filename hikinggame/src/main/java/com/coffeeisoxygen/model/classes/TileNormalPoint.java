package com.coffeeisoxygen.model.classes;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;

public class TileNormalPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileNormalPoint() {
        super("N", TileType.NORMALPOINT, Color.GRAY);
    }

    @Override
    public void onPlayerStep(Player player) {
        // Implementation for when a player steps on the normal point
    }
}