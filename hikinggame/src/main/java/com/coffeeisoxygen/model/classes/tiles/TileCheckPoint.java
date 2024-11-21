package com.coffeeisoxygen.model.classes.tiles;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.enums.TileType;

public class TileCheckPoint extends Tile {
    private static final long serialVersionUID = 1L;

    public TileCheckPoint() {
        super("C", TileType.CHECKPOINT, null); // Name and color null, automatically use default
    }

    @Override
    public void onPlayerStep(Player player) {
        // if (player.getCheckPoint() == null) {
        // player.setCheckPoint(getPosition());
    }

}
