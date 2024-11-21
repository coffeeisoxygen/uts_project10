package com.coffeeisoxygen;

import java.util.Scanner;

import com.coffeeisoxygen.model.classes.board.Board;
import com.coffeeisoxygen.model.classes.board.CustomMapEditor;
import com.coffeeisoxygen.model.classes.board.CustomMapLoader;
import com.coffeeisoxygen.model.classes.board.CustomMapSaver;
import com.coffeeisoxygen.model.classes.board.DefaultMapLoader;
import com.coffeeisoxygen.model.classes.board.MapGeneratorContext;
import com.coffeeisoxygen.model.classes.board.MazeGenerator;
import com.coffeeisoxygen.model.classes.board.PercolationGenerator;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IMapEditor;
import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.IMapSaver;
import com.coffeeisoxygen.model.interfaces.ITileFactory;

public class Main {
    private static final String MAPS_DIRECTORY = "maps";

    public static void main(String[] args) {
        ITileFactory tileFactory = new TileFactory();
        MapGeneratorContext mapGeneratorContext = new MapGeneratorContext();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Load default map");
            System.out.println("2. Load custom map");
            System.out.println("3. Create custom map");
            int choice = scanner.nextInt();

            Board board;
            switch (choice) {
                case 1 -> {
                    IMapLoader defaultMapLoader = new DefaultMapLoader(tileFactory);
                    board = defaultMapLoader.loadMap();
                }
                case 2 -> {
                    System.out.println("Enter the file name to load the map:");
                    String fileName = scanner.next();
                    IMapLoader customMapLoader = new CustomMapLoader(tileFactory, MAPS_DIRECTORY, fileName);
                    board = customMapLoader.loadMap();
                }
                case 3 -> {
                    System.out.println("Enter the number of rows:");
                    int rows = scanner.nextInt();
                    System.out.println("Enter the number of columns:");
                    int cols = scanner.nextInt();

                    System.out.println("Choose a map generation algorithm:");
                    System.out.println("1. Maze Generation");
                    System.out.println("2. Percolation");
                    int algoChoice = scanner.nextInt();

                    switch (algoChoice) {
                        case 1 -> mapGeneratorContext.setMapGenerator(new MazeGenerator(tileFactory));
                        case 2 -> mapGeneratorContext.setMapGenerator(new PercolationGenerator(tileFactory));
                        default -> {
                            System.out.println("Invalid choice. Defaulting to normal tiles.");
                            mapGeneratorContext.setMapGenerator(null);
                        }
                    }

                    IMapEditor mapEditor = new CustomMapEditor(tileFactory, mapGeneratorContext);
                    board = mapEditor.createCustomMap(rows, cols);
                }
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            // Display all tiles on the board
            for (Tile tile : board.getAllTiles()) {
                System.out.println(tile.getName() + " at " + tile.getPosition() + " COLOR " + tile.getColor());
            }

            // Visualize the board
            board.visualizeBoard();

            // Save the custom map
            System.out.println("Do you want to save the current map? (yes/no)");
            String saveChoice = scanner.next();
            if (saveChoice.equalsIgnoreCase("yes")) {
                System.out.println("Enter the file name to save the map:");
                String fileName = scanner.next();
                IMapSaver customMapSaver = new CustomMapSaver(MAPS_DIRECTORY, fileName);
                customMapSaver.saveMap(board);
            }
        }
    }
}

// [ ] todo : Algorithm Improvements: 
// - [ ] todo : Research and implement more sophisticated
// algorithms for map generation.
// - [ ] todo : Game Logic: Implement the core game logic, including player
// movement,
// scoring, and game state management.
// ? [ ] MARK: UI Enhancements: Improve the user interface, possibly adding a
// graphical
// interface or enhancing the text-based interface.
// ? [ ] MARK: Testing: Write unit tests and integration tests to ensure the
// correctness
// of the game logic and map generation algorithms.
// ? [ ] MARK: Documentation: Add documentation and comments to the code to
// improve
// readability and maintainability.

