package com.coffeeisoxygen.model.classes;

import java.awt.Color;
import java.io.Serializable;

import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;

public abstract class Tile implements Serializable {
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

    public void setName(String name) {
        this.name = name;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
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

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void onPlayerStep(Player player);
}