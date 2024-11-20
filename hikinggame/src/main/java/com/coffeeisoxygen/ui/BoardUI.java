// package com.coffeeisoxygen.ui;

// import com.coffeeisoxygen.model.classes.Board;
// import com.coffeeisoxygen.model.classes.Tile;
// import com.coffeeisoxygen.model.enums.TileType;
// import com.coffeeisoxygen.model.factory.TileFactory;
// import com.coffeeisoxygen.model.util.Coordinate;

// import java.beans.PropertyChangeEvent;
// import java.beans.PropertyChangeListener;

// public class BoardUI implements PropertyChangeListener {
// private final Board board;

// public BoardUI(Board board) {
// this.board = board;
// this.board.addPropertyChangeListener(this);
// }

// @Override
// public void propertyChange(PropertyChangeEvent evt) {
// String propertyName = evt.getPropertyName();
// switch (propertyName) {
// case "tile" -> {
// Tile oldTile = (Tile) evt.getOldValue();
// Tile newTile = (Tile) evt.getNewValue();
// System.out.println("Tile changed from " + oldTile + " to " + newTile);
// }
// case "boardReset" -> System.out.println("Board reset");
// }
// }

// public static void main(String[] args) {
// Board board = new Board(5, 5);
// BoardUI boardUI = new BoardUI(board);

// // Create a STARTPOINT tile and add it at position (2, 3)
// Tile startTile = TileFactory.createTile(TileType.STARTPOINT);
// board.setTile(new Coordinate(2, 3), startTile);

// // Reset the board with the default tile (NORMALPOINT)
// Tile safeTile = TileFactory.createTile(TileType.NORMALPOINT);
// board.resetBoard(safeTile);
// }
// }