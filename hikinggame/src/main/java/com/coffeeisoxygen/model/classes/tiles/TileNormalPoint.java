package com.coffeeisoxygen.model.classes.tiles;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.classes.Player;

public class TileNormalPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileNormalPoint() {
        super("Normal Point", TileType.NORMALPOINT, Color.GRAY);
    }

    @Override
    public void onPlayerStep(Player player, Game game) {
        // No special effect for normal point
    }
}