package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;

public class TileCheckPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileCheckPoint() {
        super("C", TileType.CHECKPOINT, null); // Name and color null, automatically use default
    }

    @Override
    public void onPlayerStep(Player player, Game game) {
        if (game.getCurrentMove() == 'S') {
            player.getState().addEnergy(10);
        }
    }
}