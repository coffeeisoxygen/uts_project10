package com.coffeeisoxygen.model.classes.tiles;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.util.Coordinate;


public class TileTest {

    private Tile tile;
    private TileType mockTileType;
    private Color mockColor;

    @BeforeEach
    public void setUp() {
        mockTileType = mock(TileType.class);
        mockColor = mock(Color.class);
        when(mockTileType.getDefaultColor()).thenReturn(mockColor);

        tile = new Tile("TestTile", mockTileType, mockColor) {
            @Override
            public void onPlayerStep(Player player) {
                // Mock implementation
            }
        };
    }

    @Test
    public void testConstructor() {
        assertEquals("TestTile", tile.getName());
        assertEquals(mockTileType, tile.getType());
        assertEquals(mockColor, tile.getColor());
    }

    @Test
    public void testSetName() {
        tile.setName("NewName");
        assertEquals("NewName", tile.getName());
    }

    @Test
    public void testSetType() {
        TileType newType = mock(TileType.class);
        Color newColor = mock(Color.class);
        when(newType.getDefaultColor()).thenReturn(newColor);

        tile.setType(newType);
        assertEquals(newType, tile.getType());
        assertEquals(newColor, tile.getColor());
    }

    @Test
    public void testSetPosition() {
        Coordinate position = new Coordinate(1, 2);
        tile.setPosition(position);
        assertEquals(position, tile.getPosition());
    }

    @Test
    public void testSetColor() {
        Color newColor = new Color(255, 0, 0);
        tile.setColor(newColor);
        assertEquals(newColor, tile.getColor());
    }
}