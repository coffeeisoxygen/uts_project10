package com.coffeeisoxygen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.coffeeisoxygen.model.util.Coordinate;

public class CoordinateTest {

    @Test
    public void testCoordinateInitialization() {
        Coordinate coordinate = new Coordinate(5, 10);
        assertEquals(5, coordinate.getX());
        assertEquals(10, coordinate.getY());
    }

    @Test
    public void testCoordinateToString() {
        Coordinate coordinate = new Coordinate(5, 10);
        assertEquals("(5, 10)", coordinate.toString());
    }
}