package com.coffeeisoxygen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.util.Coordinate;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player(10, "TestPlayer", new Coordinate(0, 0));
    }

    @Test
    public void testPlayerInitialization() {
        assertEquals(10, player.getEnergy());
        assertEquals("TestPlayer", player.getName());
        assertEquals(new Coordinate(0, 0), player.getPosition());
    }

    @Test
    public void testSetPosition() {
        Coordinate newPosition = new Coordinate(5, 5);
        player.setPosition(newPosition);
        assertEquals(newPosition, player.getPosition());
    }
}