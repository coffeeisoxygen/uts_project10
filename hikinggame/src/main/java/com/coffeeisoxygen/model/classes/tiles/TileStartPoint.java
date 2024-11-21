package com.coffeeisoxygen.model.classes.tiles;

import java.awt.Color;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.enums.TileType;

public class TileStartPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileStartPoint() {
        super("S", TileType.STARTPOINT, Color.BLUE);
    }

    @Override
    public void onPlayerStep(Player player) {
        // No special effect for normal point
        // TODO : Add more effects
        System.out.println("You stepped on a start point!");
    }
}
