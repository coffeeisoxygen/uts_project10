package com.coffeeisoxygen.model.util;

import java.util.*;

import com.coffeeisoxygen.model.classes.mapboard.MapBoard;
import com.coffeeisoxygen.model.classes.tiles.Tile;
import com.coffeeisoxygen.model.enums.TileType;
import com.coffeeisoxygen.model.managers.TileManager;

public class PathfindingUtils {

    public static void findPath(MapBoard mapBoard, TileManager tileManager) {
        Coordinate start = new Coordinate(0, 0);
        Coordinate finish = new Coordinate(mapBoard.getBoard().getWidth() - 1, mapBoard.getBoard().getHeight() - 1);

        PriorityQueue<Coordinate> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c.getX() + c.getY()));
        queue.add(start);

        Map<Coordinate, Coordinate> cameFrom = new HashMap<>();
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(finish)) {
                break;
            }

            for (Coordinate neighbor : getNeighbors(current, mapBoard)) {
                if (!cameFrom.containsKey(neighbor)) {
                    queue.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }

        // Reconstruct path
        Coordinate current = finish;
        while (current != null) {
            Tile pathTile = tileManager.createTile(TileType.CHECKPOINT, "SAFE", current);
            mapBoard.setTile(current, pathTile);
            current = cameFrom.get(current);
        }

        // Place start and finish tiles
        mapBoard.setTile(start, tileManager.createTile(TileType.STARTPOINT, "Start", start));
        mapBoard.setTile(finish, tileManager.createTile(TileType.FINISHPOINT, "Finish", finish));
    }

    private static List<Coordinate> getNeighbors(Coordinate coordinate, MapBoard mapBoard) {
        List<Coordinate> neighbors = new ArrayList<>();
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (mapBoard.isValidPosition(new Coordinate(x - 1, y)))
            neighbors.add(new Coordinate(x - 1, y));
        if (mapBoard.isValidPosition(new Coordinate(x + 1, y)))
            neighbors.add(new Coordinate(x + 1, y));
        if (mapBoard.isValidPosition(new Coordinate(x, y - 1)))
            neighbors.add(new Coordinate(x, y - 1));
        if (mapBoard.isValidPosition(new Coordinate(x, y + 1)))
            neighbors.add(new Coordinate(x, y + 1));

        return neighbors;
    }
}