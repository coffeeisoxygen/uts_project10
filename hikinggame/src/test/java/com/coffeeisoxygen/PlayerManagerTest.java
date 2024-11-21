package com.coffeeisoxygen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.managers.PlayerManager;
import com.coffeeisoxygen.model.util.Coordinate;

public class PlayerManagerTest {
    private Player player;
    private PlayerManager playerManager;

    @BeforeEach
    public void setUp() {
        player = new Player(10, "TestPlayer", new Coordinate(0, 0));
        playerManager = new PlayerManager(player);
    }

    @Test
    public void testMoveLeft() {
        playerManager.moveLeft();
        assertEquals(new Coordinate(-1, 0), player.getPosition());
        assertEquals(9, player.getEnergy());
    }

    @Test
    public void testMoveRight() {
        playerManager.moveRight();
        assertEquals(new Coordinate(1, 0), player.getPosition());
        assertEquals(9, player.getEnergy());
    }

    @Test
    public void testMoveUp() {
        playerManager.moveUp();
        assertEquals(new Coordinate(0, -1), player.getPosition());
        assertEquals(9, player.getEnergy());
    }

    @Test
    public void testMoveDown() {
        playerManager.moveDown();
        assertEquals(new Coordinate(0, 1), player.getPosition());
        assertEquals(9, player.getEnergy());
    }

    @Test
    public void testDontMove() {
        playerManager.dontMove();
        assertEquals(new Coordinate(0, 0), player.getPosition());
        assertEquals(9, player.getEnergy());
    }

    @Test
    public void testExecuteMovementPlan() {
        String movementPlan = "RRUUDDLL";
        playerManager.executeMovementPlan(movementPlan);
        assertEquals(new Coordinate(0, 0), player.getPosition());
        assertEquals(2, player.getEnergy());
    }

    @Test
    public void testHandleKeyPress() {
        playerManager.handleKeyPress('R');
        assertEquals(new Coordinate(1, 0), player.getPosition());
        assertEquals(9, player.getEnergy());

        playerManager.handleKeyPress('U');
        assertEquals(new Coordinate(1, -1), player.getPosition());
        assertEquals(8, player.getEnergy());
    }
}