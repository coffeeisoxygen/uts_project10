// package com.coffeeisoxygen;

// import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
// import com.coffeeisoxygen.model.classes.tiles.Tile;
// import com.coffeeisoxygen.model.enums.TileType;
// import com.coffeeisoxygen.model.util.Coordinate;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// public class MapboardTest {

// @Test
// public void testSetTile() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(0, 0);
// Tile tile = new NormalTile(TileType.NORMALPOINT, "Normal", position);
// mapBoard.setTile(position, tile);
// assertEquals(tile, mapBoard.getTile(position));
// }

// @Test
// public void testInvalidPosition() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(6, 12);
// Tile tile = new Tile(TileType.NORMALPOINT, "Normal", position);
// assertThrows(IllegalArgumentException.class, () -> mapBoard.setTile(position,
// tile));
// }

// @Test
// public void testGetTile() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(1, 1);
// Tile tile = new Tile(TileType.NORMALPOINT, "Normal", position);
// mapBoard.setTile(position, tile);
// assertEquals(tile, mapBoard.getTile(position));
// }

// @Test
// public void testRemoveTile() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(2, 2);
// Tile tile = new Tile(TileType.NORMALPOINT, "Normal", position);
// mapBoard.setTile(position, tile);
// mapBoard.removeTile(position);
// assertNull(mapBoard.getTile(position));
// }

// @Test
// public void testClearBoard() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position1 = new Coordinate(0, 0);
// Coordinate position2 = new Coordinate(1, 1);
// Tile tile1 = new Tile(TileType.NORMALPOINT, "Normal1", position1);
// Tile tile2 = new Tile(TileType.NORMALPOINT, "Normal2", position2);
// mapBoard.setTile(position1, tile1);
// mapBoard.setTile(position2, tile2);
// mapBoard.clearBoard();
// assertNull(mapBoard.getTile(position1));
// assertNull(mapBoard.getTile(position2));
// }

// @Test
// public void testIsTileSet() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(3, 3);
// Tile tile = new Tile(TileType.NORMALPOINT, "Normal", position);
// mapBoard.setTile(position, tile);
// assertTrue(mapBoard.isTileSet(position));
// mapBoard.removeTile(position);
// assertFalse(mapBoard.isTileSet(position));
// }

// @Test
// public void testBoardSize() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// assertEquals(6, mapBoard.getWidth());
// assertEquals(12, mapBoard.getHeight());
// }

// @Test
// public void testSetTileOverwrite() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(4, 4);
// Tile tile1 = new Tile(TileType.NORMALPOINT, "Normal1", position);
// Tile tile2 = new Tile(TileType.NORMALPOINT, "Normal2", position);
// mapBoard.setTile(position, tile1);
// assertEquals(tile1, mapBoard.getTile(position));
// mapBoard.setTile(position, tile2);
// assertEquals(tile2, mapBoard.getTile(position));
// }

// @Test
// public void testSetTileNull() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(5, 5);
// assertThrows(NullPointerException.class, () -> mapBoard.setTile(position,
// null));
// }

// @Test
// public void testGetTileOutOfBounds() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(7, 7);
// assertThrows(IndexOutOfBoundsException.class, () ->
// mapBoard.getTile(position));
// }

// @Test
// public void testRemoveTileOutOfBounds() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// Coordinate position = new Coordinate(7, 7);
// assertThrows(IndexOutOfBoundsException.class, () ->
// mapBoard.removeTile(position));
// }

// @Test
// public void testClearBoardEmpty() {
// MapBoard mapBoard = new MapBoard("TestMap", 6, 12);
// mapBoard.clearBoard();
// for (int i = 0; i < mapBoard.getWidth(); i++) {
// for (int j = 0; j < mapBoard.getHeight(); j++) {
// assertNull(mapBoard.getTile(new Coordinate(i, j)));
// }
// }
// }
// }