package com.coffeeisoxygen.model.classes;

import java.awt.Color;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;

public class TileFinishPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileFinishPoint() {
        super("Finish Point", TileType.FINISHPOINT, Color.GREEN);
    }

    @Override
    public void onPlayerStep(Player player, Game game) {
        PlayerState state = player.getState();
        if (state.isAlive()) {
            System.out.println("Player reached the finish point and is alive.");
            game.setWinning(true);
        }
    }
}