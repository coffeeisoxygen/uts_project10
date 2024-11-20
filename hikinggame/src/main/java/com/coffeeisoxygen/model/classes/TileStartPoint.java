package com.coffeeisoxygen.model.classes;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;

public class TileStartPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileStartPoint() {
        super("S", TileType.STARTPOINT, Color.BLUE);
    }

    @Override
    public void onPlayerStep(Player player, Game game) {
        // No special effect for normal point
    }
}
