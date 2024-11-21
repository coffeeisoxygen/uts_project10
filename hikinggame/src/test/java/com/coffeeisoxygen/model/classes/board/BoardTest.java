package com.coffeeisoxygen.model.classes.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(10, 10);
    }

    @Test
    public void testGetWidth() {
        assertEquals(10, board.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(10, board.getHeight());
    }

    @Test
    public void testIsValidPosition_Valid() {
        assertTrue(board.isValidPosition(5, 5));
    }

    @Test
    public void testIsValidPosition_InvalidX() {
        assertFalse(board.isValidPosition(-1, 5));
        assertFalse(board.isValidPosition(10, 5));
    }

    @Test
    public void testIsValidPosition_InvalidY() {
        assertFalse(board.isValidPosition(5, -1));
        assertFalse(board.isValidPosition(5, 10));
    }

    @Test
    public void testIsValidPosition_InvalidXY() {
        assertFalse(board.isValidPosition(-1, -1));
        assertFalse(board.isValidPosition(10, 10));
    }
}