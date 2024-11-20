package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.enums.TileType;

public class TileFinishPoint extends Tile {

    public TileFinishPoint() {
        super("F", TileType.STARTPOINT, null); // Name dan color null, otomatis pakai default
    }

    @Override
    public void onPlayerStep(Player player) {
        // Do nothing
    }
}
