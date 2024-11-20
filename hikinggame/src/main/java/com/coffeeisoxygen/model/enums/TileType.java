package com.coffeeisoxygen.model.enums;

import java.awt.Color;

public enum TileType {
    STARTPOINT(Color.BLUE), // blue
    FINISHPOINT(Color.GREEN), // YELLOW
    CHECKPOINT(Color.YELLOW), // GREEN
    DANGERPOINT(Color.RED), // RED
    NORMALPOINT(Color.DARK_GRAY); // DARK_GRAY

    private final Color defaultColor;

    TileType(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }
}
