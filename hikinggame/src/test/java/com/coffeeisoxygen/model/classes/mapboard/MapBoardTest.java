package com.coffeeisoxygen.model.classes.mapboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.managers.TileManager;
import com.coffeeisoxygen.model.util.Coordinate;


public class MapBoardTest {

    private MapBoard mapBoard;
    private final String name = "TestMap";
    private final int rows = 5;
    private final int cols = 5;

    @Mock
    private Tile mockTile;

    @Mock
    private TileManager mockTileManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mapBoard = new MapBoard(name, rows, cols);
    }

    @Test
    public void testGetName() {
        assertEquals(name, mapBoard.getName());
    }

    @Test
    public void testGetBoard() {
        Board board = mapBoard.getBoard();
        assertNotNull(board);
        assertEquals(rows, board.getHeight());
        assertEquals(cols, board.getWidth());
    }

    @Test
    public void testSetTileValidPosition() {
        Coordinate position = new Coordinate(2, 2);
        mapBoard.setTile(position, mockTile);
        assertEquals(mockTile, mapBoard.getTile(position));
    }

    @Test
    public void testSetTileInvalidPosition() {
        Coordinate position = new Coordinate(-1, -1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mapBoard.setTile(position, mockTile));
        assertNotNull(exception);
    }

    @Test
    public void testGetTileValidPosition() {
        Coordinate position = new Coordinate(2, 2);
        mapBoard.setTile(position, mockTile);
        assertEquals(mockTile, mapBoard.getTile(position));
    }

    @Test
    public void testGetTileInvalidPosition() {
        Coordinate position = new Coordinate(-1, -1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mapBoard.getTile(position));
        assertNotNull(exception);
    }

    @Test
    public void testGetTileAttributes() {
        Coordinate position = new Coordinate(2, 2);
        mapBoard.setTile(position, mockTile);
        assertEquals(mockTile, mapBoard.getTileAttributes(position));
    }

    @Test
    public void testIsValidPosition() {
        Coordinate validPosition = new Coordinate(2, 2);
        Coordinate invalidPosition = new Coordinate(-1, -1);
        assertTrue(mapBoard.isValidPosition(validPosition));
        assertFalse(mapBoard.isValidPosition(invalidPosition));
    }

    @Test
    public void testVisualizeMap() {
        // This test is to ensure no exceptions are thrown during visualization
        mapBoard.visualizeMap();
    }



    @Test
    public void testGetTiles() {
        Tile[][] tiles = mapBoard.getTiles();
        assertNotNull(tiles);
        assertEquals(rows, tiles.length);
        assertEquals(cols, tiles[0].length);
    }
}