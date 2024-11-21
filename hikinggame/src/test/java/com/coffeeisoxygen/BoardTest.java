// package com.coffeeisoxygen;

// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import com.coffeeisoxygen.model.classes.board.Board;

// public class BoardTest {
// private Board board;

// @BeforeEach
// public void setUp() {
// board = new Board(10, 10); // Assuming a 10x10 board for testing
// }

// @Test
// public void testCreateMaze() {
// board.createMaze();
// assertNotNull(board);
// assertTrue(board.isValidPosition(new Coordinate(0, 0))); // Assuming (0, 0)
// is a valid position in the maze
// }

// @Test
// public void testCreatePercolation() {
// board.createPercolation();
// assertNotNull(board);
// assertTrue(board.isValidPosition(new Coordinate(0, 0))); // Assuming (0, 0)
// is a valid position in the
// // percolation
// }

// @Test
// public void testCreateSimpleBoard() {
// board.createSimpleBoard();
// assertNotNull(board);
// assertTrue(board.isValidPosition(new Coordinate(0, 0))); // Assuming (0, 0)
// is a valid position in the simple
// // board
// }
// }