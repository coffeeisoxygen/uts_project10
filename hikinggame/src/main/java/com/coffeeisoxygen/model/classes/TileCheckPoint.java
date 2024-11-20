package com.coffeeisoxygen.model.classes;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;

public class TileCheckPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileCheckPoint() {
        super("C", TileType.CHECKPOINT, Color.YELLOW);
    }

    @Override
    public void onPlayerStep(Player player) {
        // Implementation for when a player steps on the checkpoint
    }
}