package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.enums.TileType;
;
public class TileDangerPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileDangerPoint() {
        super("X", TileType.DANGERPOINT, null); // Name and color null, automatically use default
    }

    @Override
    public void onPlayerStep(Player player, Game game) {
        player.getState().reduceEnergy(player.getState().getEnergy()); // Reduce all energy
        if (player.getState().isAlive()) {
            game.setWinning(false);
        }
    }
}