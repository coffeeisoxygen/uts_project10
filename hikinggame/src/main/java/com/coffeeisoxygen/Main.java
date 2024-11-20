package com.coffeeisoxygen;

import java.util.Scanner;

import com.coffeeisoxygen.model.classes.Board;
import com.coffeeisoxygen.model.classes.CustomMapLoader;
import com.coffeeisoxygen.model.classes.CustomMapSaver;
import com.coffeeisoxygen.model.classes.DefaultMapLoader;
import com.coffeeisoxygen.model.classes.Tile;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.IMapSaver;
import com.coffeeisoxygen.model.interfaces.ITileFactory;

public class Main {
    private static final String MAPS_DIRECTORY = "maps";

    public static void main(String[] args) {
        ITileFactory tileFactory = new TileFactory();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Load default map");
            System.out.println("2. Load custom map");
            int choice = scanner.nextInt();
            
            Board board;
            if (choice == 1) {
                IMapLoader defaultMapLoader = new DefaultMapLoader(tileFactory);
                board = defaultMapLoader.loadMap();
            } else {
                System.out.println("Enter the file name to load the map:");
                String fileName = scanner.next();
                IMapLoader customMapLoader = new CustomMapLoader(tileFactory, MAPS_DIRECTORY, fileName);
                board = customMapLoader.loadMap();
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