package com.coffeeisoxygen.model.classes.tiles;

import java.awt.Color;
import java.io.Serializable;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.interfaces.ITileEffect;
import com.coffeeisoxygen.model.util.Coordinate;
import com.coffeeisoxygen.model.classes.Player;

public abstract class Tile implements ITileEffect, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private TileType type;
    private Coordinate position;
    private Color color;

    public Tile(String name, TileType type, Color color) {
        this.type = type;
        this.name = (name != null && !name.isEmpty()) ? name : type.name();
        this.color = (color != null) ? color : type.getDefaultColor();
    }

    public String getName() {
        return name;
    }

    public String setName() {
        return name;
    }

    public TileType getType() {
        return type;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public abstract void onPlayerStep(Player player);
}