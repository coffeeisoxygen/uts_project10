package com.coffeeisoxygen.model.classes.tiles;

import java.awt.Color;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.enums.TileType;

public class TileFinishPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileFinishPoint() {
        super("Finish Point", TileType.FINISHPOINT, Color.GREEN);
    }

    @Override
    public void onPlayerStep(Player player) {
        // PlayerState state = player.getState();
        // if (state.isAlive()) {
        // System.out.println("Player reached the finish point and is alive.");
        // game.setWinning(true);

        // TODO: Add more effects
        System.out.println("You reached the finish point!");
    }
}