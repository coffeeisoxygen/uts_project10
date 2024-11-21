package com.coffeeisoxygen.model.classes.tiles;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.enums.TileType;;

public class TileDangerPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileDangerPoint() {
        super("X", TileType.DANGERPOINT, null); // Name and color null, automatically use default
    }

    @Override
    public void onPlayerStep(Player player) {
        // player.getState().reduceEnergy(player.getState().getEnergy()); // Reduce all
        // energy
        // if (player.getState().isAlive()) {
        // game.setWinning(false);
        // TODO: Add more effects
        System.out.println("You stepped on a danger point!");
    }
}
