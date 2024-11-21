package com.coffeeisoxygen.model.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.classes.tiles.TileCheckPoint;
import com.coffeeisoxygen.model.classes.tiles.TileDangerPoint;
import com.coffeeisoxygen.model.classes.tiles.TileFinishPoint;
import com.coffeeisoxygen.model.classes.tiles.TileNormalPoint;
import com.coffeeisoxygen.model.classes.tiles.TileStartPoint;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITileFactory;

public class TileFactory implements ITileFactory {
    private static final Map<TileType, Supplier<Tile>> tileRegistry = new HashMap<>();

    static {
        tileRegistry.put(TileType.STARTPOINT, TileStartPoint::new);
        tileRegistry.put(TileType.FINISHPOINT, TileFinishPoint::new);
        tileRegistry.put(TileType.DANGERPOINT, TileDangerPoint::new);
        tileRegistry.put(TileType.CHECKPOINT, TileCheckPoint::new);
        tileRegistry.put(TileType.NORMALPOINT, TileNormalPoint::new);
    }

    @Override
    public Tile createTile(TileType type) {
        Supplier<Tile> tileSupplier = tileRegistry.get(type);
        if (tileSupplier != null) {
            return tileSupplier.get();
        }
        throw new IllegalArgumentException("Unknown TileType: " + type);
    }
}