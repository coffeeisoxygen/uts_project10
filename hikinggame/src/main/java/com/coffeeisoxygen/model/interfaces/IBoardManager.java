package com.coffeeisoxygen.model.interfaces;

import java.util.List;

import com.coffeeisoxygen.model.classes.Tile;
import com.coffeeisoxygen.model.util.Coordinate;

public interface IBoardManager {
    void setTile(Coordinate position, Tile tile); // Set Tile di posisi

    Tile getTile(Coordinate position); // Get Tile di posisi

    List<Tile> getAllTiles(); // Semua Tile

    void resetBoard(Tile defaultTile); // Reset semua Tile

    boolean isValidPosition(Coordinate position); // Validasi posisi
    void visualizeBoard(); // Visualisasi Board debuging purposes
    void getFinishPosition(Coordinate position); // Mendapatkan posisi finish
}
